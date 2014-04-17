class Handler(object):
	def __init__(self):
		self._url=None
		self._classHandler=None

	@property
	def url(self):
		return self._url

	@property
	def classHandler(self):
		return self._classHandler

	@url.setter
	def url(self,value):
		self._url=value

	@classHandler.setter
	def classHandler(self,value):
		self._classHandler=value

