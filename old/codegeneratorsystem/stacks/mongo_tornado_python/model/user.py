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

'''

	Class User
	by @chinostroza

'''
class User(BaseModel):


	def __init__(self):
		self._identifier=None
		self._username=None
		self._email=None
		self._password=None
		self._name=None


	@property
	def identifier(self):

		return self._identifier


	@property
	def username(self):

		return self._username


	@property
	def email(self):

		return self._email


	@property
	def password(self):

		return self._password


	@property
	def name(self):

		return self._name


	@identifier.setter
	def identifier(self,value):

		self._identifier = value


	@username
	def username(self,value):

		self._username = value


	@email.setter
	def email(self,value):

		self._email = value


	@password.setter
	def password(self,value):

		self._password = value


	@name.setter
	def name(self,value):

		self._name = value

	def Save(self):
		
		url = self.wsurl()+"/user/save?token=" + self.token()
		url += "&username="+ self.username
		url += "&name="+ self.name
		url += "&email="+ self.email
		url += "&password="+ self.password
		return urllib.urlopen(url).read()


	def InitByEmail(self,email):
		
		url = self.wsurl()+"/user/get"
		url += "?token=" + self.token()
		url += "&email=" + email
		json_string = urllib.urlopen(url).read()
		data = json_util.loads(json_string)
		self.identifier=data["identifier"]
		self.username=data["username"]
		self.name=data["name"]
		self.email=data["email"]
		self.password=data["password"]

		return data

