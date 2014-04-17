class DictGenerator(object):
	def __init__(self):
		self.name=''
		self.xdict=None
	def setName(self,name):
		self.name=name
	def setDict(self,xdict):
		self.xdict=xdict
	def getName(self):
		return self.name
	def getDict(self):
		return self.xdict