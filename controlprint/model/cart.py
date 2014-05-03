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
class Cart(BaseModel):
	def __init__(self):
		self._date=None
		self._items=None
		self._total=None
		self._userid=None
		self._identifier=None

	@property
	def date(self):
		return self._date

	@property
	def items(self):
		return self._items

	@property
	def total(self):
		return self._total

	@property
	def userid(self):
		return self._userid

	@property
	def identifier(self):
		return self._identifier

	@date.setter
	def date(self,value):
		self._date=value

	@items.setter
	def items(self,value):
		self._items=value

	@total.setter
	def total(self,value):
		self._total=value

	@userid.setter
	def userid(self,value):
		self._userid=value

	@identifier.setter
	def identifier(self,value):
		self._identifier=value

	def getList(self):
		url = self.wsurl()+"/cart/list?token="+ self.token() + "&items=100"
		content = urllib2.urlopen(url).read()
		data = json_util.loads(content)
		self.identifier = data
		return data

	def Save(self):
		url = self.wsurl()+"/cart/add?token=" + self.token()
		url +="&date="+ self.date
		#aca deberia se debria enviar un json
		url +="&items="+ self.items
		url +="&total="+ self.total
		url +="&userid="+ self.userid
		url +="&identifier="+ self.identifier
		return urllib.urlopen(url).read()


	def InitById(self,identifier):
		url = self.wsurl()+"/cart/get"
		url += "?token=" + self.token()
		url += "&identifier=" + identifier
		json_string = urllib.urlopen(url).read()
		data = json_util.loads(json_string)
		self.date=data["date"]
		self.items=data["items"]
		self.total=data["total"]
		self.userid=data["userid"]
		self.identifier=str(data["_id"])
		return data

