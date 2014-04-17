import os.path
from generator.classgenerator import ClassGenerator
from generator.functiongenerator import FunctionGenerator
from generator.filegenerator import FileGenerator
from generator.entitygenerator import Entity
from generator.html import markup
from generator.handler import Handler
from bs4 import BeautifulSoup


class TornadoGenerator(object):
	def __init__(self):

		self._entitys=[]
		self._operators=[]
		self._path=""
		self._handlers=[]
		self._name=""

	@property
	def name(self):
		return self._name

	@property
	def path(self):
		return self._path

	@property
	def entitys(self):
		return self._entitys

	@property
	def operators(self):
		return self._operators

	@property
	def handlers(self):
		return self._handlers

	@name.setter
	def name(self,value):
		self._name=value

	@path.setter
	def path(self,value):
		self._path=value

	@entitys.setter
	def entitys(self,value):
		self._entitys=value

	@operators.setter
	def operators(self,value):
		self._operators=value

	@handlers.setter
	def handlers(self,value):
		self._handlers=value

	def addHandler(self,handler):
		myHandler = Handler()
		myHandler.url=handler.url
		myHandler.classHandler=handler.classHandler
		self._handlers.append(myHandler)

	def genTemplate(self,entity,operator):
		if operator == "add":
			page=markup.page()
			page.form(role="form",action=entity.getName(),method="post",enctype="multipart/form-data" )
			for key,value in entity.getAttrs().iteritems():
				page.div(class_="form-group")
				page.label(key,for_=key)
				page.input(type="text" ,class_="form-control", id=key, placeholder="")
				page.div.close()
			page.button("Submit",type="submit",class_="btn btn-default")
			page.add("{% raw xsrf_form_html() %}")
			page.form.close()
			page.add("{% end %}")
			#generate file
			pathProject = self.path+"/templates/"+entity.getName().lower()+"/"
			myFileGenerator = FileGenerator()
			myFileGenerator.createDirectory(pathProject)
			pathfile=pathProject+"/add.html"
			myFileGenerator.createFile(pathfile)

			soup = BeautifulSoup(str(page))
			soup.body.hidden=True
			outsrt="{% extends \"../base.html\" %}\n"
			outsrt+="{% block body %}\n"
			outsrt+=str(soup.body.prettify(formatter=None))
			myFileGenerator.stringToFile(pathfile,outsrt)

	def genHandler(self,entity,operator):
		outStr=""
		#class for add Handler
		myHandler = ClassGenerator(entity.getName().title()+operator.title()+"Handler",**entity.getAttrs())
		myHandler.setNameDadClass('BaseHandler')
		#TODO add import and from import

		myHandler.addImport("tornado.auth")
		myHandler.addImport("tornado.httpserver")
		myHandler.addImport("tornado.ioloop")
		myHandler.addImport("tornado.options")
		myHandler.addImport("tornado.web")

		myHandler.addFromImport("basehandler","BaseHandler")
		myHandler.addFromImport("model."+entity.getName().lower(),entity.getName())
		if operator == "add":
			#get add method
			myDefGet = FunctionGenerator('get')
			myDefGet.addParam("self")
			myDefGet.addLine("\t\t"+entity.getName().lower()+"="+entity.getName()+"()\n")
			myDefGet.addLine("\t\tself.render(\""+entity.getName().lower()+"/add.html\","+entity.getName().lower()+"="+entity.getName().lower()+")")
			myHandler.addFunction(myDefGet)
			#post add method
			myDefPost = FunctionGenerator('post')
			myDefPost.addParam('self')
			listArgument = entity.getAttrs()
			myDefPost.addLine("\t\t"+entity.getName().lower()+"="+entity.getName()+"()\n")
			for key,value in listArgument.iteritems():
				myDefPost.addLine("\t\t"+entity.getName().lower()+"."+key+"=self.get_argument(\""+key+"\",\"\")\n")
			myDefPost.addLine("\t\t"+entity.getName().lower()+".save()\n")
			myDefPost.addLine("\t\tself.redirect(\"/"+entity.getName().lower()+"?dn=t\")")	
			myHandler.addFunction(myDefPost)
			#get list method
		if operator == "list":
			myDefGet = FunctionGenerator('get')
			myDefGet.addParam("self")
			myDefGet.addLine("\t\t"+entity.getName().lower()+"="+entity.getName()+"()\n")
			myDefGet.addLine("\t\tself.render(\""+entity.getName().lower()+"/list.html\","+entity.getName().lower()+"="+entity.getName().lower()+".getList())")
			myHandler.addFunction(myDefGet)
		#generate a file
		outStr+=myHandler.generate()
		myFileGenerator = FileGenerator()
		pathfile=self.path+"/"+myHandler.getName().lower()+".py"
		myFileGenerator.createFile(pathfile)
		myFileGenerator.stringToFile(pathfile,outStr)
		outStr=""

	def genModel(self,entity):

		entityDict=entity.getAttrs()
		entityDict["wsurl"]="string"
		entityDict["token"]="string"
		entityDict["identifier"]="string"
		modelClass = ClassGenerator(entity.getName(),**entityDict)
		modelClass.setNameDadClass('BaseModel')
		modelClass.addProperty()
		modelClass.addSetter()
		modelClass.addPythonCommand=True
		modelClass.addImport("tornado.auth")
		modelClass.addImport("tornado.httpserver")
		modelClass.addImport("tornado.ioloop")
		modelClass.addImport("tornado.options")
		modelClass.addImport("tornado.web")
		modelClass.addImport("urllib")
		modelClass.addImport("urllib2")
		modelClass.addFromImport("basehandler","BaseHandler")
		modelClass.addFromImport("bson","json_util")
		modelClass.addFromImport("model.basemodel ","BaseModel")
		getListFunction = FunctionGenerator("getList")
		getListFunction.addParam("self")
		getListFunction.addLine("\t\turl = self.wsurl()+\"/"+entity.getName().lower()+"/list?token=\"+ self.token() + \"&items=100\"\n")
		getListFunction.addLine("\t\tcontent = urllib2.urlopen(url).read()\n")
		getListFunction.addLine("\t\tdata = json_util.loads(content)\n")
		getListFunction.addLine("\t\tself.identifier = data\n")
		getListFunction.addLine("\t\treturn data")
		modelClass.addFunction(getListFunction)
		myFileGenerator= FileGenerator()
		pathModel = self.path+"model/"
		myFileGenerator.createDirectory(pathModel)
		pathFile=self.path+"model/"+modelClass.getName().lower()+".py"
		self.addFile(pathFile,modelClass.generate())

	def addFile(self,path,_str):

		myFileGenerator = FileGenerator()
		myFileGenerator.createFile(path)
		myFileGenerator.stringToFile(path,_str)

	def genMain(self):

		tornadoClass = ClassGenerator("Application")

		#add HomeHandler
		homeHandler = Handler()
		homeHandler.url="r\"/\""
		homeHandler.classHandler="HomeHandler"
		self.addHandler(homeHandler)
		tornadoClass.addFromImport(homeHandler.classHandler.lower(),homeHandler.classHandler)
		for entity in self.entitys:
			for operator in self.operators:
				myHandler = Handler()
				myHandler.url = "r\"/"+entity.getName().lower() + "/" + operator+"\""
				myHandler.classHandler=entity.getName().title()+operator.title()+"Handler"
				self.addHandler(myHandler)
				tornadoClass.addFromImport(myHandler.classHandler.lower(),myHandler.classHandler)

		tornadoClass.addFromImport("globals","port")
		tornadoClass.addPythonCommand=True
		tornadoClass.setNameDadClass("tornado.web.Application")
		tornadoClass.addImport("os.path")
		tornadoClass.addImport("pymongo")
		tornadoClass.addImport("tornado.httpserver")
		tornadoClass.addImport("tornado.ioloop")
		tornadoClass.addFromImport("tornado.options","define,options")
		tornadoClass.addImport("tornado.web")
		tornadoClass.addbeforeClassLines("define(\"port\", default=port, help=\"run on the given port\", type=int)\n")
		initFunction = FunctionGenerator("__init__")
		initFunction.addParam("self")
		initFunction.addLine("\t\tsettings = dict(\n")
		initFunction.addLine("\t\t\tblog_title=u\"ControlPrint\",\n")
		initFunction.addLine("\t\t\ttemplate_path=os.path.join(os.path.dirname(__file__), \"templates\"),\n")
		initFunction.addLine("\t\t\tstatic_path=os.path.join(os.path.dirname(__file__), \"static\"),\n")
		initFunction.addLine("\t\t\txsrf_cookies=True,\n")
		initFunction.addLine("\t\t\tcookie_secret=\"12oETzKXQAGaYdkL5gEmGeJJFuYh7EQnp2XdTP1o\",\n")
		initFunction.addLine("\t\t\tlogin_url=\"/auth/login\",\n")
		initFunction.addLine("\t\t\tdebug=True)\n\n")

		initFunction.addLine("\t\thandlers=[\n")
		totalHandler=len(self.handlers)
		contHandler=0
		for handler in self.handlers:
			if contHandler >= totalHandler - 1:
				initFunction.addLine("\t\t\t("+handler.url+","+handler.classHandler+")\n")
			else:
				initFunction.addLine("\t\t\t("+handler.url+","+handler.classHandler+"),\n")
			contHandler+=1
		initFunction.addLine("\t\t]\n\n")
		initFunction.addLine("\t\ttornado.web.Application.__init__(self, handlers, **settings)")
		tornadoClass.addFunction(initFunction)
		tornadoClass.addafterClassLines("def main():\n")
		tornadoClass.addafterClassLines("\ttornado.options.parse_command_line()\n")
		tornadoClass.addafterClassLines("\thttp_server = tornado.httpserver.HTTPServer(Application())\n")
		tornadoClass.addafterClassLines("\thttp_server.listen(options.port)\n")
		tornadoClass.addafterClassLines("\ttornado.ioloop.IOLoop.instance().start()\n\n")
		tornadoClass.addafterClassLines("if __name__ == \"__main__\":\n")
		tornadoClass.addafterClassLines("\tmain()")

		myFileGenerator = FileGenerator()
		pathfile=self.path+"/main.py"
		myFileGenerator.createFile(pathfile)
		outSrt=tornadoClass.generate()
		myFileGenerator.stringToFile(pathfile,outSrt)

	def genProjectDirectory(self):
		#create directory project
		myFileGenerator = FileGenerator()
		pathProject = self.path
		myFileGenerator.createDirectory(pathProject)

	def genStaticDirectory(self):
		myStaticFolder = FileGenerator()
		origen = os.path.join(os.path.dirname(__file__),"generator/default/static")
		destino=self.path+"static"
		myStaticFolder.copyanything(origen,destino)

	def genBaseHandler(self):
		myBaseHandler = ClassGenerator("BaseHandler")
		myBaseHandler.addImport("tornado.web")
		myBaseHandler.setNameDadClass("tornado.web.RequestHandler")
		myInitFunction = FunctionGenerator("__init__")
		myInitFunction.addParam("self")
		myInitFunction.addParam("application")
		myInitFunction.addParam("request")
		myInitFunction.addParam("**kwargs")
		myInitFunction.addLine("\t\ttornado.web.RequestHandler.__init__(self, application, request, **kwargs)")
		myBaseHandler.addFunction(myInitFunction)
		myDbFunction = FunctionGenerator("db")
		myDbFunction.addDecorator("@property")
		myDbFunction.addParam('self')
		myDbFunction.addLine("\t\treturn self.application.db")
		myBaseHandler.addFunction(myDbFunction)
		fileBaseHandler = FileGenerator()
		pathfileGlobal = self.path+"/"+"basehandler"+".py"
		fileBaseHandler.createFile(pathfileGlobal)
		fileBaseHandler.stringToFile(pathfileGlobal,myBaseHandler.generate())

	def genBaseHtml(self):

		page = markup.page( )
		page.init( title=self.name, 
					css=( "/static/lib/bootstrap-3.1.1-dist/css/bootstrap.min.css" ),
					charset=("utf-8"), 
					metainfo={"viewport":"width=device-width, initial-scale=1"},
					doctype="<!DOCTYPE html>",
					script=["/static/lib/jquery-1.11.0.min.js",
							"/static/lib/bootstrap-3.1.1-dist/js/bootstrap.min.js"] )

		page.add("{% block body %}{% end %}")
		page.div(class_="container")
		page.div(class_="row")
		page.div.close()
		page.div.close()

		fileBaseHtml = FileGenerator()
		pathfile = self.path+"templates/base.html"
		fileBaseHtml.createDirectory(self.path+"templates")
		fileBaseHtml.createFile(pathfile)
		fileBaseHtml.stringToFile(pathfile,str(page))

	def genEntity(self):
		self.genProjectDirectory()
		self.genStaticDirectory()
		self.genBaseHandler()
		self.genBaseHtml()
		for entity in self.entitys:
			for operator in self.operators:
				self.genHandler(entity,operator)
				self.genTemplate(entity,operator)
			self.genModel(entity)
		self.genMain()

if __name__ == '__main__':
	designAttrs=dict({
		"id":"Int",
		"created":"Date",
		"designer":"Designer",
		"user":"User",
		"category":"Category",
		"updated":"Date",
		"title":"string",
		"body":"json"
	})

	designEntity = Entity("Design",designAttrs)
	listEntity=[]
	listEntity.append(designEntity)
	myTornado = TornadoGenerator()
	myTornado.entitys=listEntity
	myTornado.operators=["list","add"]
	myTornado.path="/Users/chinostroza/jarvis/controlprint/"
	myTornado.name="controlprint"
	myTornado.genEntity()