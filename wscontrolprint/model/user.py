#!/usr/bin/python
from bson import json_util
from bson.objectid import ObjectId
from basemodel  import BaseModel
class User(BaseModel):
	def __init__(self):
		self._username=None
		self._password=None
		self._firstname=None
		self._lastname=None
		self._avatar=None
		self._identifier=None
		self._email=None

	@property
	def username(self):
		return self._username

	@property
	def password(self):
		return self._password

	@property
	def firstname(self):
		return self._firstname

	@property
	def lastname(self):
		return self._lastname

	@property
	def avatar(self):
		return self._avatar

	@property
	def identifier(self):
		return self._identifier

	@property
	def email(self):
		return self._email

	@username.setter
	def username(self,value):
		self._username=value

	@password.setter
	def password(self,value):
		self._password=value

	@firstname.setter
	def firstname(self,value):
		self._firstname=value

	@lastname.setter
	def lastname(self,value):
		self._lastname=value

	@avatar.setter
	def avatar(self,value):
		self._avatar=value

	@identifier.setter
	def identifier(self,value):
		self._identifier=value

	@email.setter
	def email(self,value):
		self._email=value

	def InitById(self,identifier,collection):
		data = collection.find({"_id":ObjectId(identifier)})
		if data.count() >= 1:
			self.username = data[0]["username"]
			self.password = data[0]["password"]
			self.avatar = data[0]["avatar"]
			self.firstname = data[0]["firstname"]
			self.lastname = data[0]["lastname"]
			self.identifier = str(data[0]["_id"])
			self.email = data[0]["email"]


	def Print(self):
		try:
			data = {
				"username": self.username,
				"password": self.password,
				"avatar": self.avatar,
				"firstname": self.firstname,
				"lastname": self.lastname,
				"_id":ObjectId(self.identifier),
				"email": self.email,
			}
			return data
		except Exception, e:
			return self.ShowError("id: " + self.identifier + " not found")


	def Save(self,collection):
		data = collection.find({"username" : self.username})
		if data.count() >= 1:
			collection.update(
				{"_id" : data[0]["_id"]},
				{"$set" : {
					"username": self.username,
					"password": self.password,
					"avatar": self.avatar,
					"firstname": self.firstname,
					"lastname": self.lastname,
					"identifier": self.identifier,
					"email": self.email
				}})
			return str(data[0]["_id"])
		#save the object and return the id
		object_id = collection.insert(
			{
				"username": self.username,
				"password": self.password,
				"avatar": self.avatar,
				"firstname": self.firstname,
				"lastname": self.lastname,
				"identifier": self.identifier,
				"email": self.email,
			})
		return str(object_id)


