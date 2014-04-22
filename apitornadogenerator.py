from tornadogenerator import TornadoGenerator
from generator.entitygenerator import Entity
from generator.classgenerator import ClassGenerator
from generator.handler import Handler
from generator.functiongenerator import FunctionGenerator
from generator.filegenerator import FileGenerator
import os

class ApiTornadoGenerator(TornadoGenerator):
	def __init__(self):
		super(ApiTornadoGenerator, self).__init__()
		self._port=None
		self._namedb=""

	@property
	def namedb(self):
		return self._namedb

	@namedb.setter
	def namedb(self,value):
		self._namedb=value

	@property
	def port(self):
		return self._port

	@port.setter
	def port(self,value):
		self._port=value

	def genMain(self):

		tornadoClass = ClassGenerator("Application")
		for entity in self.entitys:
			for operator in self.operators:
				myHandler = Handler()
				myHandler.url = "r\"/"+entity.getName().lower() + "/" + operator+"\""
				myHandler.classHandler=entity.getName().title()+operator.title()+"Handler"
				self.addHandler(myHandler)
				tornadoClass.addFromImport(myHandler.classHandler.lower(),myHandler.classHandler)

		#tornadoClass.addFromImport("globals","port")
		tornadoClass.addPythonCommand=True
		tornadoClass.setNameDadClass("tornado.web.Application")
		tornadoClass.addImport("os.path")
		tornadoClass.addImport("pymongo")
		tornadoClass.addImport("tornado.httpserver")
		tornadoClass.addImport("tornado.ioloop")
		tornadoClass.addFromImport("tornado.options","define,options")
		tornadoClass.addImport("tornado.web")
		tornadoClass.addbeforeClassLines("define(\"port\", default="+str(self.port)+", help=\"run on the given port\", type=int)\n")
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
		initFunction.addLine("\t\ttornado.web.Application.__init__(self, handlers, **settings)\n\n")

		#add database
		initFunction.addLine("\t\t\'\'\' configure database \'\'\'\n")
		initFunction.addLine("\t\tconnection  = pymongo.Connection(\"localhost\", 27017)\n")
		initFunction.addLine("\t\tself.db     = connection."+self.namedb+"\n")

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
				'''
				# validate access token
				if not self.ValidateToken():
					return

				# isntantitate product
				product = Product()

				product.codigo_proveedor = self.TryGetParam("codigo_proveedor", "")
				product.codigo_interno = self.TryGetParam("codigo_interno", "")
				product.nombre = self.TryGetParam("nombre", "")
				product.precio = self.TryGetParam("precio", "")
				product.stock = self.TryGetParam("stock", "")
				product.descuento = self.TryGetParam("descuento", "")
				product.estado = self.TryGetParam("estado", "")
				product.marca = self.TryGetParam("marca", "")
				product.familia = self.TryGetParam("familia", "")
				product.descripcion = self.TryGetParam("descripcion", "")

				# saving current product
				oid = product.Save(self.db.products)
				

				self.write(oid)
				'''
				#get add method
				myDefGet = FunctionGenerator('get')
				myDefGet.addParam("self")

				myDefGet.addLine("\t\t#validate access token\n")
				myDefGet.addLine("\t\tif not self.ValidateToken():\n")
				myDefGet.addLine("\t\t\treturn\n")

				myDefGet.addLine("\t\t"+entity.getName().lower()+"="+entity.getName()+"()\n")

				listArgument = entity.getAttrs()
				for key,value in listArgument.iteritems():
					myDefGet.addLine("\t\t"+entity.getName().lower()+"."+key+"=self.get_argument(\""+key+"\",\"\")\n")

				myDefGet.addLine("\t\toid="+entity.getName().lower()+".Save(self.db."+entity.getName().lower()+"s)\n")
				myDefGet.addLine("\t\tself.write(oid)")

				#myDefGet.addLine("\t\tself.render(\""+entity.getName().lower()+"/add.html\","+entity.getName().lower()+"="+entity.getName().lower()+")")
				myHandler.addFunction(myDefGet)
				#post add method
				'''
				myDefPost = FunctionGenerator('post')
				myDefPost.addParam('self')
				listArgument = entity.getAttrs()
				myDefPost.addLine("\t\t"+entity.getName().lower()+"="+entity.getName()+"()\n")
				for key,value in listArgument.iteritems():
					myDefPost.addLine("\t\t"+entity.getName().lower()+"."+key+"=self.get_argument(\""+key+"\",\"\")\n")
				myDefPost.addLine("\t\t"+entity.getName().lower()+".save()\n")
				myDefPost.addLine("\t\tself.redirect(\"/"+entity.getName().lower()+"?dn=t\")")	
				myHandler.addFunction(myDefPost)
				'''
				#get list method
			if operator == "list":
				myDefGet = FunctionGenerator('get')
				myDefGet.addParam("self")

				myDefGet.addLine("\t\t#validate access token\n")
				myDefGet.addLine("\t\tif not self.ValidateToken():\n")
				myDefGet.addLine("\t\t\treturn\n")
				myDefGet.addLine("\t\tcurrent_page 	= \"1\"\n")
				myDefGet.addLine("\t\titems_per_page 	= \"10\"\n")
				myDefGet.addLine("\t\t"+entity.getName().lower()+"="+entity.getName()+"()\n")
				myDefGet.addLine("\t\ttry:\n")
				myDefGet.addLine("\t\t\tcurrent_page 	= int(self.TryGetParam(\"page\", \"1\"))\n")
				myDefGet.addLine("\t\t\titems_per_page 	= int(self.TryGetParam(\"items\", \"10\"))\n")
				myDefGet.addLine("\t\texcept Exception, e:\n")
				myDefGet.addLine("\t\t\tprint str(e)\n")
				myDefGet.addLine("\t\tself.write("+entity.getName().lower()+".GetList(current_page, items_per_page, self.db."+entity.getName().lower()+"s))\n")
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
		modelClass.addFromImport("bson","json_util")
		modelClass.addFromImport("bson.objectid","ObjectId")
		modelClass.addFromImport("basemodel ","BaseModel")

		mySaveFunction = FunctionGenerator("Save")
		mySaveFunction.addParam("self")
		mySaveFunction.addParam("collection")
		mySaveFunction.addLine("\t\tdata = collection.find({\"id\" : self.id})\n")
		mySaveFunction.addLine("\t\tif data.count() >= 1:\n")
		mySaveFunction.addLine("\t\t\tcollection.update(\n")
		mySaveFunction.addLine("\t\t\t\t{\"_id\" : data[0][\"_id\"]},\n")
		mySaveFunction.addLine("\t\t\t\t{\"$set\" : {\n")
		listArgument = entity.getAttrs()
		cantAttrs = len(listArgument)
		contAttrs = 0
		for key,value in listArgument.iteritems():
			if contAttrs == (cantAttrs - 1):
				mySaveFunction.addLine("\t\t\t\t\t\""+key+"\": self."+key+"\n")
			else:
				mySaveFunction.addLine("\t\t\t\t\t\""+key+"\": self."+key+",\n")
			contAttrs +=1
		mySaveFunction.addLine("\t\t\t\t}})\n")
		mySaveFunction.addLine("\t\t\treturn str(data[0][\"_id\"])\n")
		mySaveFunction.addLine("\t\t#save the object and return the id\n")
		mySaveFunction.addLine("\t\tobject_id = collection.insert(\n")
		mySaveFunction.addLine("\t\t\t{\n")
		for key,value in listArgument.iteritems():
			if contAttrs == (cantAttrs - 1):
				mySaveFunction.addLine("\t\t\t\t\""+key+"\": self."+key+"\n")
			else:
				mySaveFunction.addLine("\t\t\t\t\""+key+"\": self."+key+",\n")
			contAttrs +=1
		mySaveFunction.addLine("\t\t\t})\n")
		mySaveFunction.addLine("\t\treturn str(object_id)\n")
		modelClass.addFunction(mySaveFunction)
		'''
		def Save(self, collection):

			# validate codigo_proveedor and codigo_interno
			data = collection.find({"codigo_interno" : self.codigo_interno})
			if data.count() >= 1:

				collection.update(
					{"_id" : data[0]["_id"]},
					{"$set" : {
						"codigo_proveedor" 	: self.codigo_proveedor,
						"codigo_interno" 	: self.codigo_interno,
						"nombre"  			: self.nombre,
						"precio" 			: self.precio,
						"stock" 			: self.stock,
						"descuento" 		: self.descuento,
						"estado" 			: self.estado,
						"marca" 			: self.marca,
						"familia" 			: self.familia,
						"descripcion" 		: self.descripcion	
					}})

				return str(data[0]["_id"])

			#save the object and return the id
			object_id = collection.insert(
				{
				"codigo_proveedor" 	: self.codigo_proveedor,
				"codigo_interno" 	: self.codigo_interno,
				"nombre"  			: self.nombre,
				"precio" 			: self.precio,
				"stock" 			: self.stock,
				"descuento" 		: self.descuento,
				"estado" 			: self.estado,
				"marca" 			: self.marca,
				"familia" 			: self.familia,
				"descripcion" 		: self.descripcion
				})

			return str(object_id)
		'''


		myFileGenerator= FileGenerator()
		pathModel = self.path+"model/"
		myFileGenerator.createDirectory(pathModel)
		myFileGenerator.createFile(pathModel+"__init__.py")

		myBaseModel = FileGenerator()
		origen = os.path.join(os.path.dirname(__file__),"generator/defaultapi/model/basemodel.py")
		destino=self.path+"model/basemodel.py"
		myBaseModel.copyanything(origen,destino)


		pathFile=self.path+"model/"+modelClass.getName().lower()+".py"
		self.addFile(pathFile,modelClass.generate())

	def genBaseHandler(self):
		myBaseHandler = FileGenerator()
		origen = os.path.join(os.path.dirname(__file__),"generator/defaultapi/basehandler.py")
		destino=self.path+"basehandler.py"
		myBaseHandler.copyanything(origen,destino)


	def generate(self):
		#generamos el proyecto de api
		self.genProjectDirectory()
		#generamos el base handler
		self.genBaseHandler()
		#self.genGlobals()
		for entity in self.entitys:
				for operator in self.operators:
					self.genHandler(entity,operator)
				self.genModel(entity)
		self.genMain()

if __name__ == '__main__':
	userAttrs = dict({
		"id":"Int",
		"username":"String",
		"password":"String",
		"firstname":"String",
		"lastname":"String",
		"email":"String",
		"avatar":"url"
		})
	designAttrs=dict({
		"id":"Int",
		"avatar":"string",
		"created":"Date",
		"designer":"Designer",
		"user":"User",
		"category":"Category",
		"updated":"Date",
		"title":"string",
		"description":"string",
		"costunit":"string",
		"body":"json"
	})

	designEntity = Entity("Design",designAttrs)
	userEntity = Entity("User",userAttrs)
	listEntity=[]
	listEntity.append(designEntity)
	listEntity.append(userEntity)
	myApiTornado = ApiTornadoGenerator()
	myApiTornado.entitys=listEntity
	myApiTornado.operators=["list","add"]
	myApiTornado.path="/Users/chinostroza/jarvis/wscontrolprint/"
	myApiTornado.name="wscontrolprint"
	myApiTornado.namedb="controlprint"
	myApiTornado.port=9999
	myApiTornado.generate()

	