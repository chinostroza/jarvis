	def get(self, current_page, items_per_page, collection,_id):
		page 	= int(current_page) - 1
		items	= int(items_per_page)
		data	= "[]"

		try:
			data	= collection.find({"{{ entity }}":{{ _id }}}).limit(items).skip(items*page)
		except Exception, e:
			print str(e)
		return data	