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

	def getList(self):
		url = self.wsurl()+"/design/list?token="+ self.token() + "&items=100"
		content = urllib2.urlopen(url).read()
		data = json_util.loads(content)
		self.identifier = data
		return data

