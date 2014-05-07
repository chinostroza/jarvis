import tornado.auth
import tornado.httpserver
import tornado.ioloop
import tornado.options
import tornado.web
from basehandler import BaseHandler
from model.user import User
from bson import json_util
import json

class SignUpHandler(BaseHandler):
	def get(self):
		self.render("signup.html")

	def post(self):
		user = User()
		user.name=self.get_argument("name","")
		user.email=self.get_argument("email","")
		user.password=self.get_argument("password","")
		user.Save()

		userobj=dict({
			"name":user.name,
			"email":user.email
			})

		self.set_secure_cookie("user", json.dumps(userobj, sort_keys=True, indent=4, default=json_util.default))
		my_url = (self.request.protocol + "://" + self.request.host + "/")
		self.redirect(my_url)