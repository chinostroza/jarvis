import tornado.auth
import tornado.httpserver
import tornado.ioloop
import tornado.options
import tornado.web
from basehandler import BaseHandler
from model.user import User
class UserAddHandler(BaseHandler):
	def get(self):
		user=User()
		self.render("user/add.html",user=user)

	def post(self):
		user=User()
		user.username=self.get_argument("username","")
		user.password=self.get_argument("password","")
		user.avatar=self.get_argument("avatar","")
		user.firstname=self.get_argument("firstname","")
		user.lastname=self.get_argument("lastname","")
		user.identifier=self.get_argument("identifier","")
		user.email=self.get_argument("email","")
		user.Save()


