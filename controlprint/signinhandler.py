import tornado.auth
import tornado.httpserver
import tornado.ioloop
import tornado.options
import tornado.web
from basehandler import BaseHandler
from model.user import User
from bson import json_util
import json

class SignInHandler(BaseHandler):
	def get(self):
		self.render("signin.html",msj="")

	def post(self):
		email = self.get_argument("email","")
		password = self.get_argument("password","")

		userModel = User()
		user = userModel.InitById(email)
		if user["password"] == password:
			self.set_secure_cookie("user", json.dumps(user, sort_keys=True, indent=4, default=json_util.default))
			self.redirect( self.get_argument("next", "/") )
		else:
			self.render("signin.html",msj="your name or password is wrong")