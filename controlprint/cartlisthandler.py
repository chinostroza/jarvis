import tornado.auth
import tornado.httpserver
import tornado.ioloop
import tornado.options
import tornado.web
from basehandler import BaseHandler
from model.cart import Cart
class CartListHandler(BaseHandler):
	def get(self):
		cart=Cart()
		self.render("cart/list.html",cart=cart.getList())

