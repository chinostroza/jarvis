#!/usr/bin/python
from bson import json_util
from bson.objectid import ObjectId
from basemodel  import BaseModel

class User(BaseModel):
	def __init__(self):
		self._name=None
		self._email=None
		self._password=None

	@property
	def name(self):
		return self._name

	@property
	def email(self):
		return self._email

	@property
	def password(self):
		return self._password

	@name.setter
	def name(self,value):
		self._name=value

	@email.setter
	def email(self,value):
		self._email=value

	@password.setter
	def password(self,value):
		self._password=value

	def InitById(self,identifier,collection):
		data = collection.find({"_id":ObjectId(identifier)})
		if data.count() >= 1:
			self.name = data[0]["username"]
			self.email = data[0]["email"]
			self.password = data[0]["password"]

	def Print(self):
		try:
			data = {
				"name": self.username,
				"email": self.email,
				"password": self.password,
				"_id":ObjectId(self.identifier),
				
			}
			return data
		except Exception, e:
			return self.ShowError("id: " + self.identifier + " not found")

	def Save(self,collection):
		data = collection.find({"email" : self.email})
		if data.count() >= 1:
			collection.update(
				{"_id" : data[0]["_id"]},
				{"$set" : {
					"name": self.name,
					"email": self.email,
					"password": self.password
				}})
			return str(data[0]["_id"])
		#save the object and return the id
		object_id = collection.insert(
			{
				"name": self.name,
				"email": self.email,
				"password": self.password
			})
		return str(object_id)