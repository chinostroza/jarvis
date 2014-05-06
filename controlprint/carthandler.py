'''
carthandler.py
'''
import tornado.auth
import tornado.httpserver
import tornado.ioloop
import tornado.options
import tornado.web
from basehandler import BaseHandler
from model.cart import Cart
class CartHandler(BaseHandler):
	def get(self):
		self.render("cart/home.html")