import tornado.auth
import tornado.httpserver
import tornado.ioloop
import tornado.options
import tornado.web
from basehandler import BaseHandler
from model.design import Design
class DesignListHandler(BaseHandler):
	def get(self):
		design=Design()
		self.render("design/list.html",design=design.getList())

