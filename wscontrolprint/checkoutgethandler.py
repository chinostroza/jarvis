import tornado.auth
import tornado.httpserver
import tornado.ioloop
import tornado.options
import tornado.web
from basehandler import BaseHandler
from model.checkout import Checkout
from bson import json_util
class CheckoutGetHandler(BaseHandler):
	def get(self):
		#validate access token
		if not self.ValidateToken():
			return
		userid = self.get_argument("userid", "")
		checkout = Checkout()
		checkout.InitByUserId(userid,self.db.checkouts)
		self.write(json_util.dumps(checkout.Print()))