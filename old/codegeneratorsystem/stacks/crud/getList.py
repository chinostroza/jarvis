	def getList(self,collection):
		data	= "[]"
		try:
			data	= collection.find()
		except Exception, e:
			print str(e)
		return data