#!/usr/bin/python
import tornado.auth
import tornado.httpserver
import tornado.ioloop
import tornado.options
import tornado.web
import urllib
import urllib2
from basehandler import BaseHandler
from bson import json_util
from model.basemodel  import BaseModel
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

	def getList(self):
		
		url = self.wsurl()+"/checkout/list?token="+ self.token() + "&items=100"
		content = urllib2.urlopen(url).read()
		data = json_util.loads(content)
		self.identifier = data
		return data

	def Save(self):

		url = self.wsurl()+"/checkout/add?token=" + self.token()
		url +="&comment="+ self.comment
		url +="&formapago="+ self.formapago
		url +="&identifier="+ self.identifier
		url +="&firstname="+ self.firstname
		url +="&city="+ self.city
		url +="&regionstate="+ self.regionstate
		url +="&lastname="+ self.lastname
		url +="&telephone="+ self.telephone
		url +="&postcode="+ self.postcode
		url +="&address="+ self.address
		url +="&country="+ self.country
		url +="&email="+ self.email
		url +="&cart="+ self.cart
		url +="&userid="+ self.userid
		return urllib.urlopen(url).read()


	def InitById(self,identifier):

		url = self.wsurl()+"/checkout/get"
		url += "?token=" + self.token()
		url += "&identifier=" + identifier
		json_string = urllib.urlopen(url).read()
		data = json_util.loads(json_string)
		self.comment=data["comment"]
		self.formapago=data["formapago"]
		self.identifier=str(data["_id"])
		self.firstname=data["firstname"]
		self.city=data["city"]
		self.regionstate=data["regionstate"]
		self.lastname=data["lastname"]
		self.telephone=data["telephone"]
		self.postcode=data["postcode"]
		self.address=data["address"]
		self.country=data["country"]
		self.email=data["email"]
		self.cart=data["cart"]
		self.userid=data["userid"]
		return data

	def jsonInitByUserId(self,userid):

		url = self.wsurl() + "/checkout/get"
		url += "?token=" + self.token()
		url += "&userid=" + userid
		return urllib.urlopen(url).read()

	def InitByUserId(self,userid):

		url = self.wsurl() + "/checkout/get"
		url += "?token=" + self.token()
		url += "&userid=" + userid
		json_string = urllib.urlopen(url).read()
		data = json_util.loads(json_string)
		self.comment=data["comment"]
		self.formapago=data["formapago"]
		self.identifier=str(data["_id"])
		self.firstname=data["firstname"]
		self.city=data["city"]
		self.regionstate=data["regionstate"]
		self.lastname=data["lastname"]
		self.telephone=data["telephone"]
		self.postcode=data["postcode"]
		self.address=data["address"]
		self.country=data["country"]
		self.email=data["email"]
		self.cart=data["cart"]
		self.userid=data["userid"]
		return data

