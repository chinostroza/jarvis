#!/usr/bin/python
from bson import json_util
from bson.objectid import ObjectId
from basemodel  import BaseModel
class Cart(BaseModel):
	def __init__(self):
		self._date=None
		self._items=None
		self._total=None
		self._userid=None
		self._identifier=None

	@property
	def date(self):
		return self._date

	@property
	def items(self):
		return self._items

	@property
	def total(self):
		return self._total

	@property
	def userid(self):
		return self._userid

	@property
	def identifier(self):
		return self._identifier

	@date.setter
	def date(self,value):
		self._date=value

	@items.setter
	def items(self,value):
		self._items=value

	@total.setter
	def total(self,value):
		self._total=value

	@userid.setter
	def userid(self,value):
		self._userid=value

	@identifier.setter
	def identifier(self,value):
		self._identifier=value

	def InitById(self,identifier,collection):
		data = collection.find({"_id":ObjectId(identifier)})
		if data.count() >= 1:
			self.date = data[0]["date"]
			self.items = data[0]["items"]
			self.total = data[0]["total"]
			self.userid = data[0]["userid"]
			self.identifier = str(data[0]["_id"])


	def Print(self):
		try:
			data = {
				"date": self.date,
				"items": self.items,
				"total": self.total,
				"userid": self.userid,
				"_id":ObjectId(self.identifier),
			}
			return data
		except Exception, e:
			return self.ShowError("id: " + self.identifier + " not found")


	def Save(self,collection):
		data = collection.find({"identifier" : self.identifier})
		if data.count() >= 1:
			collection.update(
				{"_id" : data[0]["_id"]},
				{"$set" : {
					"date": self.date,
					"items": self.items,
					"total": self.total,
					"userid": self.userid,
					"identifier": self.identifier
				}})
			return str(data[0]["_id"])
		#save the object and return the id
		object_id = collection.insert(
			{
				"date": self.date,
				"items": self.items,
				"total": self.total,
				"userid": self.userid,
				"identifier": self.identifier,
			})
		return str(object_id)


