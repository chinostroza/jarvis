#!/usr/bin/env python

from bson import json_util
from bson.objectid import ObjectId

class BaseModel(object):

	def RemoveById(self, id_mongo, collection):
		collection.remove({"_id" : ObjectId(id_mongo)})

	def FindById(self, id_mongo, collection):
		d = collection.find({"_id": ObjectId(id_mongo)})

		return str(json_util.dumps(d[0]))

	def GetList(self, current_page, items_per_page, collection):

		page 	= int(current_page) - 1
		items	= int(items_per_page)
		data	= "[]"

		try:
			data	= str(json_util.dumps(collection.find().limit(items).skip(items*page)))
		except Exception, e:
			print str(e)

		return data

	def Save(self, collection):
		return ""