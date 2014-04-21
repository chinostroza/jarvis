#!/usr/bin/python
from bson import json_util
from bson.objectid import ObjectId
from basemodel  import BaseModel
class Design(BaseModel):
	def __init__(self):
		self._category=None
		self._body=None
		self._updated=None
		self._designer=None
		self._title=None
		self._created=None
		self._user=None
		self._id=None

	@property
	def category(self):
		return self._category

	@property
	def body(self):
		return self._body

	@property
	def updated(self):
		return self._updated

	@property
	def designer(self):
		return self._designer

	@property
	def title(self):
		return self._title

	@property
	def created(self):
		return self._created

	@property
	def user(self):
		return self._user

	@property
	def id(self):
		return self._id

	@category.setter
	def category(self,value):
		self._category=value

	@body.setter
	def body(self,value):
		self._body=value

	@updated.setter
	def updated(self,value):
		self._updated=value

	@designer.setter
	def designer(self,value):
		self._designer=value

	@title.setter
	def title(self,value):
		self._title=value

	@created.setter
	def created(self,value):
		self._created=value

	@user.setter
	def user(self,value):
		self._user=value

	@id.setter
	def id(self,value):
		self._id=value

	def Save(self,collection):
		data = collection.find({"id" : self.id})
		if data.count() >= 1:
			collection.update(
				{"_id" : data[0]["_id"]},
				{"$set" : {
					"category": self.category,
					"body": self.body,
					"updated": self.updated,
					"designer": self.designer,
					"created": self.created,
					"title": self.title,
					"user": self.user,
					"id": self.id
				}})
			return str(data[0]["_id"])
		#save the object and return the id
		object_id = collection.insert(
			{
				"category": self.category,
				"body": self.body,
				"updated": self.updated,
				"designer": self.designer,
				"created": self.created,
				"title": self.title,
				"user": self.user,
				"id": self.id,
			})
		return str(object_id)