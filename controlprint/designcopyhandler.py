import tornado.auth
import tornado.httpserver
import tornado.ioloop
import tornado.options
import tornado.web
from basehandler import BaseHandler
from model.design import Design
class DesignCopyHandler(BaseHandler):
	def get(self,identifier):
		design=Design()
		self.render("design/copy.html",design=design.CopyById(identifier))