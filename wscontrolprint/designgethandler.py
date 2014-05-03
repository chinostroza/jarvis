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
		#validate access token
		if not self.ValidateToken():
			return
		identifier = self.get_argument("identifier", "")
		design=Design()
		design.InitById(identifier,self.db.designs)
		self.write(json_util.dumps(design.Print()))


