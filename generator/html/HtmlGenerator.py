class HtmlGenerator(object):
	def __init__(self):
		self._htmlentitys=[]
		self._outStr=None

	@property
	def htmlentitys(self):
		return self._htmlentitys

	@property
	def outStr(self):
		return self._outStr

	@htmlentitys.setter
	def htmlentitys(self,value):
		self._htmlentitys.append(value)

	@outStr.setter
	def outStr(self,value):
		self._outStr=value

