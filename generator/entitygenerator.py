class Entity(object):
	def __init__(self,name,attrs):
		self.name=name
		self.attrs=attrs
	def getName(self):
		return self.name
	def getAttrs(self):
		return self.attrs