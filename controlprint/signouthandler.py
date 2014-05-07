import tornado.auth
import tornado.httpserver
import tornado.ioloop
import tornado.options
import tornado.web
from basehandler import BaseHandler

class SignOutHandler(BaseHandler):
	def get(self):
		self.clear_cookie("user")
		self.redirect("/")