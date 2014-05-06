'''
checkouthandler.py
'''
import tornado.auth
import tornado.httpserver
import tornado.ioloop
import tornado.options
import tornado.web
from basehandler import BaseHandler
from model.cart import Cart
class CheckoutHandler(BaseHandler):
	def get(self):
		self.render("checkout/home.html")