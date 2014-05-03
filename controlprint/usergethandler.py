import tornado.auth
import tornado.httpserver
import tornado.ioloop
import tornado.options
import tornado.web
from basehandler import BaseHandler
from model.user import User
class UserGetHandler(BaseHandler):
	def get(self,identifier):
		user=User()
		self.render("user/get.html",user=user.InitById(identifier))

