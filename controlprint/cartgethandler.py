import tornado.auth
import tornado.httpserver
import tornado.ioloop
import tornado.options
import tornado.web
from basehandler import BaseHandler
from model.cart import Cart
class CartGetHandler(BaseHandler):
	def get(self,identifier):
		cart=Cart()
		self.render("cart/get.html",cart=cart.InitById(identifier))

