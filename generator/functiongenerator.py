from dictgenerator import DictGenerator
from codetostr import CodeToStr

class FunctionGenerator(object):
	def __init__(self,functionName):
		self.name=functionName
		self.decorator=""
		self.params=[]
		self.lines = []
		self.asig = []
		self.dicts = []

		self.outStr=''
	def addDecorator(self,strDecorator):
		self.decorator=strDecorator
	def getDecorator(self):
		return self.decorator
	def addParam(self,param):
		self.params.append(param)
	def getParamStr(self):
		myCodeToStr = CodeToStr()
		return myCodeToStr.paramToStr(self.params)
	def setName(self,name):
		self.name=name
	def addAsig(self,var,value):
		myAsig = Asignacion(var,value)
		self.asig.append(myAsig)

	def addDict(self,name,xdict):

		myDict = DictGenerator()
		myDict.setName(name)
		myDict.setDict(xdict)

		self.dicts.append(myDict)

	def addLine(self,strline):
		self.lines.append(strline)
	def getName(self):
		return self.name
	def generate(self):
		for xdict in self.dicts:
			self.outStr+="\t\t"+xdict.getName()+"=dict({\n"
			myDict = xdict.getDict()
			for key, value in myDict.iteritems():
				self.outStr+="\t\t\'"+key+"\':\'"+value+"\',\n"
			self.outStr+="\t\t})\n"
		for line in self.lines:
			self.outStr+=line
		return self.outStr