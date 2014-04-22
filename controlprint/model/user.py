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
class User(BaseModel):
	def __init__(self):
		self._username=None
		self._firstname=None
		self._lastname=None
		self._id=None
		self._avatar=None
		self._password=None
		self._email=None

	@property
	def username(self):
		return self._username

	@property
	def firstname(self):
		return self._firstname

	@property
	def lastname(self):
		return self._lastname

	@property
	def id(self):
		return self._id

	@property
	def avatar(self):
		return self._avatar

	@property
	def password(self):
		return self._password

	@property
	def email(self):
		return self._email

	@username.setter
	def username(self,value):
		self._username=value

	@firstname.setter
	def firstname(self,value):
		self._firstname=value

	@lastname.setter
	def lastname(self,value):
		self._lastname=value

	@id.setter
	def id(self,value):
		self._id=value

	@avatar.setter
	def avatar(self,value):
		self._avatar=value

	@password.setter
	def password(self,value):
		self._password=value

	@email.setter
	def email(self,value):
		self._email=value

	def getList(self):
		url = self.wsurl()+"/user/list?token="+ self.token() + "&items=100"
		content = urllib2.urlopen(url).read()
		data = json_util.loads(content)
		self.identifier = data
		return data

	def Save(self):
		url = self.wsurl()+"/user/add?token=" + self.token()
		url +="&username="+ self.username
		url +="&avatar="+ self.avatar
		url +="&firstname="+ self.firstname
		url +="&lastname="+ self.lastname
		url +="&password="+ self.password
		url +="&email="+ self.email
		url +="&id="+ self.id
		return urllib.urlopen(url).read()


