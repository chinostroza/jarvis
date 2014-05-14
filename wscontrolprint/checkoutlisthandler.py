import tornado.auth
import tornado.httpserver
import tornado.ioloop
import tornado.options
import tornado.web
from basehandler import BaseHandler
from model.checkout import Checkout
from bson import json_util
class CheckoutListHandler(BaseHandler):
	def get(self):
		#validate access token
		if not self.ValidateToken():
			return
		current_page 	= "1"
		items_per_page 	= "10"
		checkout=Checkout()
		userid = self.get_argument("identifier","")
		self.write(checkout.GetListByUserId(userid,self.db.checkouts))