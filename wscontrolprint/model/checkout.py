#!/usr/bin/python
from bson import json_util
from bson.objectid import ObjectId
from basemodel  import BaseModel
class Checkout(BaseModel):
	def __init__(self):
		self._comment=None
		self._formapago=None
		self._firstname=None
		self._city=None
		self._regionstate=None
		self._lastname=None
		self._telephone=None
		self._country=None
		self._postcode=None
		self._address=None
		self._identifier=None
		self._email=None
		self._cart=None
		self._userid=None

	@property
	def comment(self):
		return self._comment

	@property
	def formapago(self):
		return self._formapago

	@property
	def firstname(self):
		return self._firstname

	@property
	def city(self):
		return self._city

	@property
	def regionstate(self):
		return self._regionstate

	@property
	def lastname(self):
		return self._lastname

	@property
	def telephone(self):
		return self._telephone

	@property
	def country(self):
		return self._country

	@property
	def postcode(self):
		return self._postcode

	@property
	def address(self):
		return self._address

	@property
	def identifier(self):
		return self._identifier

	@property
	def email(self):
		return self._email

	@property
	def cart(self):
		return self._cart

	@property
	def userid(self):
		return self._userid

	@comment.setter
	def comment(self,value):
		self._comment=value

	@formapago.setter
	def formapago(self,value):
		self._formapago=value

	@firstname.setter
	def firstname(self,value):
		self._firstname=value

	@city.setter
	def city(self,value):
		self._city=value

	@regionstate.setter
	def regionstate(self,value):
		self._regionstate=value

	@lastname.setter
	def lastname(self,value):
		self._lastname=value

	@telephone.setter
	def telephone(self,value):
		self._telephone=value

	@country.setter
	def country(self,value):
		self._country=value

	@postcode.setter
	def postcode(self,value):
		self._postcode=value

	@address.setter
	def address(self,value):
		self._address=value

	@identifier.setter
	def identifier(self,value):
		self._identifier=value

	@email.setter
	def email(self,value):
		self._email=value

	@cart.setter
	def cart(self,value):
		self._cart=value

	@userid.setter
	def userid(self,value):
		self._userid=value

	def GetListByUserId(self,userid,collection):
		data	= str(json_util.dumps(collection.find({"userid":userid})))
		return data

	def InitByUserId(self,userid,collection):
		data = collection.find({"userid":userid})
		if data.count() >= 1:
			self.comment = data[0]["comment"]
			self.formapago = data[0]["formapago"]
			self.identifier = str(data[0]["_id"])
			self.firstname = data[0]["firstname"]
			self.city = data[0]["city"]
			self.regionstate = data[0]["regionstate"]
			self.lastname = data[0]["lastname"]
			self.telephone = data[0]["telephone"]
			self.postcode = data[0]["postcode"]
			self.address = data[0]["address"]
			self.country = data[0]["country"]
			self.email = data[0]["email"]
			self.cart = data[0]["cart"]
			self.userid = data[0]["userid"]

	def InitById(self,identifier,collection):
		data = collection.find({"_id":ObjectId(identifier)})
		if data.count() >= 1:
			self.comment = data[0]["comment"]
			self.formapago = data[0]["formapago"]
			self.identifier = str(data[0]["_id"])
			self.firstname = data[0]["firstname"]
			self.city = data[0]["city"]
			self.regionstate = data[0]["regionstate"]
			self.lastname = data[0]["lastname"]
			self.telephone = data[0]["telephone"]
			self.postcode = data[0]["postcode"]
			self.address = data[0]["address"]
			self.country = data[0]["country"]
			self.email = data[0]["email"]
			self.cart = data[0]["cart"]
			self.userid = data[0]["userid"]

	def Print(self):
		try:
			data = {
				"comment": self.comment,
				"formapago": self.formapago,
				"_id":ObjectId(self.identifier),
				"firstname": self.firstname,
				"city": self.city,
				"regionstate": self.regionstate,
				"lastname": self.lastname,
				"telephone": self.telephone,
				"postcode": self.postcode,
				"address": self.address,
				"country": self.country,
				"email": self.email,
				"cart": self.cart,
				"userid":self.userid
			}
			return data
		except Exception, e:
			return self.ShowError("id: " + self.identifier + " not found")


	def Save(self,collection):
		'''
		data = collection.find({"identifier" : self.identifier})
		if data.count() >= 1:
			collection.update(
				{"_id" : data[0]["_id"]},
				{"$set" : {
					"comment": self.comment,
					"formapago": self.formapago,
					"identifier": self.identifier,
					"firstname": self.firstname,
					"city": self.city,
					"regionstate": self.regionstate,
					"lastname": self.lastname,
					"telephone": self.telephone,
					"postcode": self.postcode,
					"address": self.address,
					"country": self.country,
					"email": self.email,
					"cart": self.cart,
					"userid": self.userid
				}})
			return str(data[0]["_id"])
		'''
		#save the object and return the id
		object_id = collection.insert(
			{
				"comment": self.comment,
				"formapago": self.formapago,
				"identifier": self.identifier,
				"firstname": self.firstname,
				"city": self.city,
				"regionstate": self.regionstate,
				"lastname": self.lastname,
				"telephone": self.telephone,
				"postcode": self.postcode,
				"address": self.address,
				"country": self.country,
				"email": self.email,
				"cart": self.cart,
				"userid": self.userid
			})
		return str(object_id)


