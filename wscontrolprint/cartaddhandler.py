import tornado.auth
import tornado.httpserver
import tornado.ioloop
import tornado.options
import tornado.web
from basehandler import BaseHandler
from model.cart import Cart
from bson import json_util
class CartAddHandler(BaseHandler):
	def get(self):
		#validate access token
		if not self.ValidateToken():
			return
		cart=Cart()
		cart.date=self.get_argument("date","")
		cart.items=self.get_argument("items","")
		cart.total=self.get_argument("total","")
		cart.userid=self.get_argument("userid","")
		cart.identifier=self.get_argument("identifier","")
		oid=cart.Save(self.db.carts)
		self.write(oid)

