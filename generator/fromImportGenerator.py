class fromImportGenerator(object):
	def __init__(self):
		self._valueFrom=None
		self._valueImport=None

	@property
	def valueFrom(self):
		return self._valueFrom

	@property
	def valueImport(self):
		return self._valueImport

	@valueFrom.setter
	def valueFrom(self,value):
		self._valueFrom=value

	@valueImport.setter
	def valueImport(self,value):
		self._valueImport=value

