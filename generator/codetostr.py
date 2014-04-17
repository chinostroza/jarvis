class CodeToStr(object):
	def paramToStr(self,params):
		outStr=""
		cantidad = len(params)
		contador = 0
		for xparam in params:
			if contador  < 1 : 
				outStr+=xparam
			else:
				outStr+="," + xparam
			contador+=1
		return outStr

		