class HtmlEntity(object):
	def __init__(self):
		self._father=None
		self._params=None

	@property
	def father(self):
		return self._father

	@property
	def params(self):
		return self._params

	@father.setter
	def father(self,value):
		self._father=value

	@params.setter
	def params(self,value):
		self._params=value