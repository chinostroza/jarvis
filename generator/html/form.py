from htmlentity import HtmlEntity

class Form(HtmlEntity):
	def __init__(self):
		self._action=None
		self._inputs=[]
		self._outStr=""
		self._method=None
		self._enctype=None

	@property
	def action(self):
		return self._action

	@property
	def inputs(self):
		return self._inputs

	@property
	def outStr(self):
		return self._outStr

	@property
	def method(self):
		return self._method

	@property
	def enctype(self):
		return self._enctype

	@action.setter
	def action(self,value):
		self._action=value

	@inputs.setter
	def inputs(self,value):
		self._inputs.append(value)

	@outStr.setter
	def outStr(self,value):
		self._outStr=value

	@method.setter
	def method(self,value):
		self._method=value

	@enctype.setter
	def enctype(self,value):
		self._enctype=value

	def addInput(self,value):
		self._inputs.append(value)

	def generate(self):
		self.outStr+="<form action=\""+self.action+"\""
		self.outStr+=" method=\""+self.method+"\""
		self.outStr+=" enctype=\""+self.enctype+"\">\n"

		for xinput in self.inputs:
			self.outStr+="\t<input"
			self.outStr+=" id=\""+xinput.id+"\""
			self.outStr+=" type=\""+xinput.type+"\""
			self.outStr+=" name=\""+xinput.name+"\"/>\n"
		self.outStr+="</form>"
		return self.outStr