import tornado.auth
import tornado.httpserver
import tornado.ioloop
import tornado.options
import tornado.web
from basehandler import BaseHandler
from model.checkout import Checkout
from bson import json_util
class CheckOutGetHandler(BaseHandler):
	def get(self):
		userid = self.get_argument("userid","")
		json = self.get_argument("json","False")

		checkout=Checkout()
		
		if json == "True":
			self.write(checkout.jsonInitByUserId(userid))
		else:
			print checkout.InitByUserId(userid)
			self.render("checkout/get.html",checkout=checkout.InitByUserId(userid))