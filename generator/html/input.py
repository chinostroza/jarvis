class Input(object):
	def __init__(self):
		self._type=""
		self._id=""
		self._value=""
		self._name=""

	@property
	def type(self):
		return self._type

	@property
	def id(self):
		return self._id

	@property
	def value(self):
		return self._value

	@property
	def name(self):
		return self._name

	@type.setter
	def type(self,value):
		self._type=value

	@id.setter
	def id(self,value):
		self._id=value

	@value.setter
	def value(self,value):
		self._value=value

	@name.setter
	def name(self,value):
		self._name=value

