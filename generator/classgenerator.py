from pprint import pprint
from functiongenerator import FunctionGenerator
from importGenerator import importGenerator
from fromImportGenerator import fromImportGenerator

class ClassGenerator(object):
	def __init__(self,nameClass,**attrs):
		self.attrs=attrs
		self.namefile=""
		self.nameClass=nameClass
		self.listImports=[]
		self.outStr=""
		self.functionList = []
		self.nameDadClass=""
		self.listFromImport=[]
		self.addPythonCommand=False
		self.afterClassLines=[]
		self.beforeClassLines=[]
		self.path=""

	def addbeforeClassLines(self,value):
		self.beforeClassLines.append(value)

	def addafterClassLines(self,value):
		self.afterClassLines.append(value)

	def addSetter(self):
		for key,value in self.attrs.iteritems():
			setterFunction = FunctionGenerator(key)
			setterFunction.addDecorator("@"+key+".setter")
			setterFunction.addParam("self")
			setterFunction.addParam("value")
			setterFunction.addLine("\t\tself._"+key+"=value")
			self.addFunction(setterFunction)

	def addProperty(self):
		#generamos el constructor
		initFunction = FunctionGenerator("__init__")
		initFunction.addParam("self")
		cantidadItem = len(self.attrs)
		contador = 0
		for key,value in self.attrs.iteritems():
			strValue="None"
			if value == "[]":
				strValue="[]"
			if contador < (cantidadItem-1):
				initFunction.addLine("\t\tself._"+key+"="+strValue+"\n")
			else:
				initFunction.addLine("\t\tself._"+key+"="+strValue+"")
			contador+=1

		self.addFunction(initFunction)
		#generamos los property
		for key,value in self.attrs.iteritems():
			propertyFuntion = FunctionGenerator(key)
			propertyFuntion.addDecorator("@property")
			propertyFuntion.addParam("self")
			propertyFuntion.addLine("\t\treturn self._"+key)
			self.addFunction(propertyFuntion)

	def addSet(self):
		for key,value in self.attrs.iteritems():
			setFunction = FunctionGenerator("set"+key)
			setFunction.addParam("self")
			setFunction.addParam(key)
			setFunction.addLine("\t\tself."+key+"="+key)
			self.addFunction(setFunction)
	def addGet(self):
		for key,value in self.attrs.iteritems():
			getFunction = FunctionGenerator("get"+key)
			getFunction.addParam("self")
			getFunction.addLine("\t\treturn self."+key)
			self.addFunction(getFunction)
	def setNamefile(self,namefile):
		self.namefile=namefile

	def setNameClass(self,nameClass):
		self.nameClass=nameClass

	def setNameDadClass(self,nameDadClass):
		self.nameDadClass=nameDadClass
	def getName(self):
		return self.nameClass
	def getNameDadClass(self):
		return self.nameDadClass
	
	def addImport(self,modulo):
		myImport = importGenerator()
		myImport.value=modulo
		self.listImports.append(myImport)

	def addFromImport(self,vFrom,vImport):
		myFromImport = fromImportGenerator()
		myFromImport.valueFrom=vFrom
		myFromImport.valueImport=vImport
		self.listFromImport.append(myFromImport)

	def addFunction(self,objFunction):
		self.functionList.append(objFunction)

	def createFile(self,pathfile,strFile):
		myFileGenerator = FileGenerator()
		myFileGenerator.createFile(self.path+pathfile)
		myFileGenerator.stringToFile(self.path+pathfile,strFile)

	def generate(self):
		#generate from import
		if self.addPythonCommand:
			self.outStr+="#!/usr/bin/python\n"
		for xImport in self.listImports:
			self.outStr+="import "+xImport.value+"\n"
		for xFromImport in self.listFromImport:
			self.outStr+="from "+xFromImport.valueFrom+" import "+xFromImport.valueImport+"\n"
		
		for line in self.beforeClassLines:
			self.outStr+=line

		strDadClass=''
		if self.getNameDadClass() <> '':
			strDadClass='('+ self.nameDadClass + ')'

		self.outStr+='class ' + self.nameClass + strDadClass + ':\n'
	
		for xfunc in self.functionList:
			if xfunc.getDecorator() <> "":
				self.outStr+="\t"+xfunc.getDecorator()+"\n"
			self.outStr+='\tdef ' + xfunc.getName() +'('+xfunc.getParamStr()+'):\n'
			self.outStr+=xfunc.generate()
			self.outStr+="\n\n"

		for line in self.afterClassLines:
			self.outStr+=line

		return self.outStr	
