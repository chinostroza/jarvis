import tornado.auth
import tornado.httpserver
import tornado.ioloop
import tornado.options
import tornado.web
from basehandler import BaseHandler
from model.user import User
from bson import json_util
class UserGetHandler(BaseHandler):
	def get(self):
		#validate access token
		if not self.ValidateToken():
			return
		email = self.get_argument("email", "")
		user=User()
		user.InitById(email,self.db.users)
		self.write(json_util.dumps(user.Print()))


