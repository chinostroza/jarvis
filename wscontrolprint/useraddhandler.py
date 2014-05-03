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
		user.username=self.get_argument("username","")
		user.password=self.get_argument("password","")
		user.avatar=self.get_argument("avatar","")
		user.firstname=self.get_argument("firstname","")
		user.lastname=self.get_argument("lastname","")
		user.identifier=self.get_argument("identifier","")
		user.email=self.get_argument("email","")
		oid=user.Save(self.db.users)
		self.write(oid)

