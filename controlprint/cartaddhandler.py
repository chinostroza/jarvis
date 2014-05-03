import tornado.auth
import tornado.httpserver
import tornado.ioloop
import tornado.options
import tornado.web
from basehandler import BaseHandler
from model.cart import Cart
class CartAddHandler(BaseHandler):
	def get(self):
		cart=Cart()
		self.render("cart/add.html",cart=cart)

	def post(self):
		cart=Cart()
		cart.date=self.get_argument("date","")
		cart.items=self.get_argument("items","")
		cart.total=self.get_argument("total","")
		cart.userid=self.get_argument("userid","")
		cart.identifier=self.get_argument("identifier","")
		cart.Save()


