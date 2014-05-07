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
		self._name=None
		self._email=None
		self._password=None

	@property
	def name(self):
		return self._name

	@property
	def password(self):
		return self._password

	@property
	def email(self):
		return self._email

	@name.setter
	def name(self,value):
		self._name=value

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
		url +="&name="+ self.name
		url +="&email="+ self.email
		url +="&password="+ self.password
		return urllib.urlopen(url).read()

	def InitById(self,email):
		url = self.wsurl()+"/user/get"
		url += "?token=" + self.token()
		url += "&email=" + email
		json_string = urllib.urlopen(url).read()
		data = json_util.loads(json_string)
		self.name=data["username"]
		self.password=data["password"]
		self.email=data["email"]
		
		return data

