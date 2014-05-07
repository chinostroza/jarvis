#!/usr/bin/python
from bson import json_util
from bson.objectid import ObjectId
from basemodel  import BaseModel

class User(BaseModel):
	def __init__(self):
		self._identifier=None
		self._name=None
		self._email=None
		self._password=None

	
	@property
	def identifier(self):
		return self._identifier

	@property
	def name(self):
		return self._name

	@property
	def email(self):
		return self._email

	@property
	def password(self):
		return self._password

	@identifier.setter
	def identifier(self,value):
		self._identifier = value

	@name.setter
	def name(self,value):
		self._name=value

	@email.setter
	def email(self,value):
		self._email=value

	@password.setter
	def password(self,value):
		self._password=value

	def InitById(self,email,collection):
		data = collection.find({"email":email})
		if data.count() >= 1:
			self.identifier = data[0]["_id"]
			self.name = data[0]["name"]
			self.email = data[0]["email"]
			self.password = data[0]["password"]

	def Print(self):
		try:
			data = {
				"identifier":self.identifier,
				"name": self.name,
				"email": self.email,
				"password": self.password
			}
			return data
		except Exception, e:
			return "id: " + self.email + " not found"

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