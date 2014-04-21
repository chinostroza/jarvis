import os
import re
import sys
from generator.classgenerator import ClassGenerator
from generator.functiongenerator import FunctionGenerator

class ReadClass(object):
	def __init__(self):
		self._path=None
		self._lines=[]

	@property
	def path(self):
		return self._path

	@property
	def lines(self):
		return self._lines

	@lines.setter
	def lines(self,value):
		self._lines=value

	@path.setter
	def path(self,value):
		self._path=value

	def read(self):
		myClassFile = open(self.path, 'r')
		self.lines= myClassFile.readlines()

	def showLines(self):
		self.read()
		cont=0
		for line in self.lines:
			print str(cont)+"\t"+ line
			cont+=1
	def createClass(self):
		myClass = ClassGenerator("")
		contTab=0
		inDefClass=False
		for line in self.lines:
			contTab=0
			for caracter in line:
				if caracter == "\t":
					contTab+=1
			#finding a bash execute 
			result = re.match("#!/usr/bin/python", line)
			if result:
				myClass.addPythonCommand=True
			#finding a import
			result = re.match("import\s([a-zA-z\.]+)", line)
			if result:
				myClass.addImport(result.group(1))
			#finding a from import 
			result = re.match("from\s([a-zA-Z]+)\simport\s([a-zA-Z\.]+)",line)
			if result:
				myClass.addFromImport(result.group(1),result.group(2))
			#finding a name class and dad name class
			result = re.match("class\s([a-zA-Z]+)\(([a-zA-Z\.]+)\)\:", line)
			if result:
				#save context class object
				myClass.setNameClass(result.group(1))
				myClass.setNameDadClass(result.group(2))
			#finding a function
			result = re.match("[\s]*def\s([a-zA-Z\_]+)\(([a-zA-z\_\,]*)\)",line)
			if result:
				if (contTab==1):
					inDefClass=True
					myDef = FunctionGenerator(result.group(1))
					myDef.addParam(result.group(2))
					myClass.addFunction(myDef)
				if (contTab==0):
					outDef = FunctionGenerator(result.group(1))
					outDef.addParam(result.group(2))
					myClass.addOutFunction(outDef)
			result = re.match("[\s]*([a-zA-Z0-9\_]+)[\s]*\=[\s]*([a-zA-Z0-9\_]+)")
			if result:
				if (contTab==2 and inDefClass):
					myDef.addLine(line)
		print myClass.generate()

if __name__ == "__main__":

	print "J.A.R.V.I.S.\n"
	
	print "Read Class\n"

	comando=sys.argv[1]
	myReadClass = ReadClass()
	myReadClass.path = os.getcwd() + comando
	myReadClass.showLines()
	myReadClass.createClass()

		