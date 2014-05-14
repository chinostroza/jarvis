import tornado.auth
import tornado.httpserver
import tornado.ioloop
import tornado.options
import tornado.web
from basehandler import BaseHandler
from model.checkout import Checkout
from model.user import User
from bson import json_util
class CheckOutGetHandler(BaseHandler):
	def get(self):

		myUser = User()
		user_cookie=self.get_current_user()
		user = myUser.InitById(user_cookie["email"])

		json = self.get_argument("json","False")

		checkout=Checkout()
		
		if json == "True":
			self.write(checkout.getOrdersByUserId(str(user["identifier"])))
		else:
			jsonCheckOut=checkout.getOrdersByUserId(str(user["identifier"]))
			myProducts = []
			for x in jsonCheckOut:
				jsonCart = json_util.loads(x["cart"])
				myProducts.append(jsonCart["products"])
			self.render("checkout/get.html",products=myProducts)