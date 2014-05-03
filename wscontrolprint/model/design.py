#!/usr/bin/python
from bson import json_util
from bson.objectid import ObjectId
from basemodel  import BaseModel
class Design(BaseModel):
	def __init__(self):
		self._body=None
		self._category=None
		self._updated=None
		self._designer=None
		self._costunit=None
		self._created=None
		self._description=None
		self._title=None
		self._avatar=None
		self._sku=None
		self._identifier=None
		self._user=None

	@property
	def body(self):
		return self._body

	@property
	def category(self):
		return self._category

	@property
	def updated(self):
		return self._updated

	@property
	def designer(self):
		return self._designer

	@property
	def costunit(self):
		return self._costunit

	@property
	def created(self):
		return self._created

	@property
	def description(self):
		return self._description

	@property
	def title(self):
		return self._title

	@property
	def avatar(self):
		return self._avatar

	@property
	def sku(self):
		return self._sku

	@property
	def identifier(self):
		return self._identifier

	@property
	def user(self):
		return self._user

	@body.setter
	def body(self,value):
		self._body=value

	@category.setter
	def category(self,value):
		self._category=value

	@updated.setter
	def updated(self,value):
		self._updated=value

	@designer.setter
	def designer(self,value):
		self._designer=value

	@costunit.setter
	def costunit(self,value):
		self._costunit=value

	@created.setter
	def created(self,value):
		self._created=value

	@description.setter
	def description(self,value):
		self._description=value

	@title.setter
	def title(self,value):
		self._title=value

	@avatar.setter
	def avatar(self,value):
		self._avatar=value

	@sku.setter
	def sku(self,value):
		self._sku=value

	@identifier.setter
	def identifier(self,value):
		self._identifier=value

	@user.setter
	def user(self,value):
		self._user=value

	def CopyById(self,identifier,collection):
		data = collection.find({"_id":ObjectId(identifier)})
		if data.count() >= 1:
			self.body = data[0]["body"]
			self.category = data[0]["category"]
			self.updated = data[0]["updated"]
			self.designer = data[0]["designer"]
			self.costunit = data[0]["costunit"]
			self.created = data[0]["created"]
			self.title = data[0]["title"]
			self.avatar = data[0]["avatar"]
			self.user = data[0]["user"]
			self.sku = data[0]["sku"]
			self.identifier = str(data[0]["_id"])
			self.description = data[0]["description"]

		object_id = collection.insert(
			{
				"body": self.body,
				"category": self.category,
				"updated": self.updated,
				"designer": self.designer,
				"costunit": self.costunit,
				"created": self.created,
				"title": self.title,
				"avatar": self.avatar,
				"user": self.user,
				"sku": self.sku,
				"identifier": self.identifier,
				"description": self.description,
			})
		return str(object_id)


	def InitById(self,identifier,collection):
		data = collection.find({"_id":ObjectId(identifier)})
		if data.count() >= 1:
			self.body = data[0]["body"]
			self.category = data[0]["category"]
			self.updated = data[0]["updated"]
			self.designer = data[0]["designer"]
			self.costunit = data[0]["costunit"]
			self.created = data[0]["created"]
			self.title = data[0]["title"]
			self.avatar = data[0]["avatar"]
			self.user = data[0]["user"]
			self.sku = data[0]["sku"]
			self.identifier = str(data[0]["_id"])
			self.description = data[0]["description"]


	def Print(self):
		try:
			data = {
				"body": self.body,
				"category": self.category,
				"updated": self.updated,
				"designer": self.designer,
				"costunit": self.costunit,
				"created": self.created,
				"title": self.title,
				"avatar": self.avatar,
				"user": self.user,
				"sku": self.sku,
				"_id":ObjectId(self.identifier),
				"description": self.description,
			}
			return data
		except Exception, e:
			return self.ShowError("id: " + self.identifier + " not found")


	def Save(self,collection):
		data = collection.find({"sku" : self.sku})
		if data.count() >= 1:
			collection.update(
				{"_id" : data[0]["_id"]},
				{"$set" : {
					"body": self.body,
					"category": self.category,
					"updated": self.updated,
					"designer": self.designer,
					"costunit": self.costunit,
					"created": self.created,
					"title": self.title,
					"avatar": self.avatar,
					"user": self.user,
					"sku": self.sku,
					"identifier": self.identifier,
					"description": self.description
				}})
			return str(data[0]["_id"])
		#save the object and return the id
		object_id = collection.insert(
			{
				"body": self.body,
				"category": self.category,
				"updated": self.updated,
				"designer": self.designer,
				"costunit": self.costunit,
				"created": self.created,
				"title": self.title,
				"avatar": self.avatar,
				"user": self.user,
				"sku": self.sku,
				"identifier": self.identifier,
				"description": self.description,
			})
		return str(object_id)


