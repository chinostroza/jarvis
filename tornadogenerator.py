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

		file_path = os.path.join(os.path.dirname(__file__),"generator/default/") + "templates/"+entity.getName().lower()+"/"+operator+".html"
		if os.path.isfile(file_path):
			#create directory
			pathProject = self.path+"/templates/"+entity.getName().lower()+"/"
			myFileGenerator = FileGenerator()
			myFileGenerator.createDirectory(pathProject)
			#copyFile
			myFileGenerator.copyanything(file_path,pathProject+operator+".html")
		else:
			if (operator == "list") or (operator == "get"):
				page=markup.page()
				page.table(border=1)
				page.thead()
				page.tr()
				for key,value in entity.getAttrs().iteritems():
					page.th(key)
					page.th.close()
				page.tr.close()
				page.thead.close()
				page.tbody()
				page.add("{% for x in "+entity.getName().lower()+" %}")
				page.tr()
				for key,value in entity.getAttrs().iteritems():
					page.td()
					page.add("{{ x[\""+key+"\"] }}")
					page.td.close()
				page.tr.close
				page.add("{% end %}")
				page.tbody.close()
				page.table.close()
				page.add("{% end %}")

				#generate file
				pathProject = self.path+"/templates/"+entity.getName().lower()+"/"
				myFileGenerator = FileGenerator()
				myFileGenerator.createDirectory(pathProject)
				pathfile=pathProject+"/list.html"
				myFileGenerator.createFile(pathfile)

				soup = BeautifulSoup(str(page))
				soup.body.hidden=True
				outsrt="{% extends \"../base.html\" %}\n"
				outsrt+="{% block body %}\n"
				outsrt+=str(soup.body.prettify(formatter=None))
				myFileGenerator.stringToFile(pathfile,outsrt)
			'''
			<table>
				<thead>
					<tr>
						<!-- repeat -->
						<th></th>
						<!-- repeat -->
					</tr>
				</thead>
				<tbody>
					<!-- repeat -->
					<tr>
						<td>
						</td>
					</tr>
					<!-- repeat -->
				</tbody>
			</table>
			'''
			if operator == "add":
				page=markup.page()
				page.form(role="form",action="/"+entity.getName().lower()+"/add",method="post",enctype="multipart/form-data" )
				for key,value in entity.getAttrs().iteritems():
					page.div(class_="form-group")
					page.label(key,for_=key)
					page.input(type="text" ,class_="form-control",name=key, id=key, placeholder="")
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
		if operator == "get":
			myDefGet = FunctionGenerator("get")
			myDefGet.addParam("self")
			myDefGet.addParam("identifier")
			myDefGet.addLine("\t\t"+entity.getName().lower()+"="+entity.getName()+"()\n")
			myDefGet.addLine("\t\tself.render(\""+entity.getName().lower()+"/get.html\","+entity.getName().lower()+"="+entity.getName().lower()+".InitById(identifier))")
			myHandler.addFunction(myDefGet)
			'''
			class GetProductHandler(BaseHandler):
				def get(self):

					# validate access token
					if not self.ValidateToken():
						return


					idd = self.get_argument("id", "")
					sku = self.get_argument("sku", "")

					product = Product()

					if idd != "":
						product.InitById(idd)
						self.write(json_util.dumps(product.Print()))
					else:
						product.InitBySku(sku)
						self.write(json_util.dumps(product.Print()))
			'''

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
			myDefPost.addLine("\t\t"+entity.getName().lower()+".Save()\n")
			#myDefPost.addLine("\t\tself.redirect(\"/"+entity.getName().lower()+"?dn=t\")")	
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
		
		#getlist()
		getListFunction = FunctionGenerator("getList")
		getListFunction.addParam("self")
		getListFunction.addLine("\t\turl = self.wsurl()+\"/"+entity.getName().lower()+"/list?token=\"+ self.token() + \"&items=100\"\n")
		getListFunction.addLine("\t\tcontent = urllib2.urlopen(url).read()\n")
		getListFunction.addLine("\t\tdata = json_util.loads(content)\n")
		getListFunction.addLine("\t\tself.identifier = data\n")
		getListFunction.addLine("\t\treturn data")
		modelClass.addFunction(getListFunction)
		#Save
		'''
		def Save(self):
			url = self.wsurl()+"/product/add?token=" + self.token()

			url += "&nombre=" + self.name
			url += "&precio=" + self.price
			url += "&descripcion=" + self.description
			url += "&cantidad=" + self.quantity
			url += "&marca=" + self.brand
			url += "&sku=" + self.sku
			url += "&categoria=" + self.category
			url += "&id=" + self.identifier

			return urllib.urlopen(url).read()
		'''
		saveFunction = FunctionGenerator("Save")
		saveFunction.addParam("self")
		saveFunction.addLine("\t\turl = self.wsurl()+\"/"+entity.getName().lower()+"/add?token=\" + self.token()\n")
		for key,value in entity.getAttrs().iteritems():
			saveFunction.addLine("\t\turl +=\"&"+key+"=\"+ self."+key+"\n")
		saveFunction.addLine("\t\treturn urllib.urlopen(url).read()\n")

		modelClass.addFunction(saveFunction)

		initByIdFunction = FunctionGenerator("InitById")
		initByIdFunction.addParam("self")
		initByIdFunction.addParam("identifier")
		initByIdFunction.addLine("\t\turl = self.wsurl()+\"/"+entity.getName().lower()+"/get\"\n")
		initByIdFunction.addLine("\t\turl += \"?token=\" + self.token()\n")
		initByIdFunction.addLine("\t\turl += \"&identifier=\" + identifier\n")

		initByIdFunction.addLine("\t\tjson_string = urllib.urlopen(url).read()\n")
		initByIdFunction.addLine("\t\tdata = json_util.loads(json_string)\n")

		for key,value in entity.getAttrs().iteritems():
			if key == "identifier":
				initByIdFunction.addLine("\t\tself."+key+"=str(data[\"_id\"])\n")
			else:
				initByIdFunction.addLine("\t\tself."+key+"=data[\""+key+"\"]\n")

		initByIdFunction.addLine("\t\treturn data")
		modelClass.addFunction(initByIdFunction)
		'''
			def InitWithId(self, idd):
				url = self.wsurl() + "/product/find"

				url += "?token=" + self.token()
				url += "&id=" + idd

				json_string = urllib.urlopen(url).read()
				data = json_util.loads(json_string)

				self.name = data["nombre"]
				self.identifier = str(data["_id"])
				self.price = data["precio"]
				self.description = data["descripcion"]
				self.quantity = data["stock"]
				self.brand = data["marca"]
				self.sku = data["codigo_interno"]
				self.category = data["familia"]
		'''

		myFileGenerator= FileGenerator()
		pathModel = self.path+"model/"
		myFileGenerator.createDirectory(pathModel)
		myFileGenerator.createFile(pathModel+"__init__.py")

		myBaseModel = FileGenerator()
		origen = os.path.join(os.path.dirname(__file__),"generator/default/model/basemodel.py")
		destino=self.path+"model/basemodel.py"
		myBaseModel.copyanything(origen,destino)


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
				if operator == "get":
					#([^/]+)
					myHandler.url = "r\"/"+entity.getName().lower() + "/" + operator+"/([^/]+)\""
				else:
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
		'''
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
		'''
		myBaseHtml = FileGenerator()
		origen = os.path.join(os.path.dirname(__file__),"generator/default/templates/base.html")
		destino=self.path+"templates/base.html"
		myBaseHtml.copyanything(origen,destino)

	def genHomeHandler(self):
		
		myHomeHandler = FileGenerator()
		origen = os.path.join(os.path.dirname(__file__),"generator/default/homehandler.py")
		destino=self.path+"homehandler.py"
		myHomeHandler.copyanything(origen,destino)

		origen = os.path.join(os.path.dirname(__file__),"generator/default/templates/home.html")
		destino=self.path+"templates/home.html"
		myHomeHandler.copyanything(origen,destino)

	def genGlobals(self):

		myGlobals = FileGenerator()
		origen = os.path.join(os.path.dirname(__file__),"generator/default/globals.py")
		destino=self.path+"globals.py"
		myGlobals.copyanything(origen,destino)

	def generate(self):
		self.genProjectDirectory()
		self.genStaticDirectory()
		self.genBaseHandler()
		self.genGlobals()
		for entity in self.entitys:
			for operator in self.operators:
				self.genHandler(entity,operator)
				self.genTemplate(entity,operator)
			self.genModel(entity)
		self.genMain()
		self.genBaseHtml()
		self.genHomeHandler()

if __name__ == '__main__':
	

	#cart.addItem({'ID' : 101, 'itemNumber' : 'product_1', 'price': 12.5, 'weight': 120});
	cartAttrs=dict({
		"identifier":"string",
		"total":"Float",
		"userid":"String",
		"date":"datetime",
		"items":"json"
	})

	cartEntity = Entity("Cart",cartAttrs)
	listEntity=[]
	listEntity.append(cartEntity)
	myTornado = TornadoGenerator()
	myTornado.entitys=listEntity
	myTornado.operators=["list","add","get"]
	myTornado.path="/Users/chinostroza/codeWeb2Print/cart/"
	myTornado.name="controlprint"
	myTornado.generate()