import tornado.auth
import tornado.httpserver
import tornado.ioloop
import tornado.options
import tornado.web
from basehandler import BaseHandler
from model.user import User
from bson import json_util
class UserAddHandler(BaseHandler):
	def get(self):
		#validate access token
		if not self.ValidateToken():
			return
		user=User()
		user.name=self.get_argument("name","")
		user.email=self.get_argument("email","")
		user.password=self.get_argument("password","")

		oid=user.Save(self.db.users)
		self.write(oid)

