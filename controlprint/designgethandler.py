import tornado.auth
import tornado.httpserver
import tornado.ioloop
import tornado.options
import tornado.web
from basehandler import BaseHandler
from model.design import Design
from bson import json_util
class DesignGetHandler(BaseHandler):
	def get(self):
		identifier = self.get_argument("identifier","")
		json = self.get_argument("json","False")

		design=Design()
		
		if json == "True":
			self.write(design.jsonInitById(identifier))
		else:
			
			self.render("design/get.html",design=design.InitById(identifier))

