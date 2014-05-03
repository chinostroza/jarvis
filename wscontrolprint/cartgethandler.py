import tornado.auth
import tornado.httpserver
import tornado.ioloop
import tornado.options
import tornado.web
from basehandler import BaseHandler
from model.cart import Cart
from bson import json_util
class CartGetHandler(BaseHandler):
	def get(self):
		#validate access token
		if not self.ValidateToken():
			return
		identifier = self.get_argument("identifier", "")
		cart=Cart()
		cart.InitById(identifier,self.db.carts)
		self.write(json_util.dumps(cart.Print()))


