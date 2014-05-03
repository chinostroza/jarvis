import tornado.auth
import tornado.httpserver
import tornado.ioloop
import tornado.options
import tornado.web
from basehandler import BaseHandler
from model.user import User
class UserListHandler(BaseHandler):
	def get(self):
		user=User()
		self.render("user/list.html",user=user.getList())

