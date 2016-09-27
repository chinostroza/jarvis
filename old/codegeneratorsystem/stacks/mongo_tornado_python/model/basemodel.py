#!/usr/bin/python
# -*- coding: UTF-8 -*-

import tornado.auth
import tornado.httpserver
import tornado.ioloop
import tornado.options
import tornado.web

from basehandler import BaseHandler
from globals import token
from globals import webservice_url

class BaseModel(object):

	def token(self):
		return token

	def wsurl(self):
		return webservice_url