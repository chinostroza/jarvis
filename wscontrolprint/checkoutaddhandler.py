import tornado.auth
import tornado.httpserver
import tornado.ioloop
import tornado.options
import tornado.web
from basehandler import BaseHandler
from model.checkout import Checkout
from bson import json_util
class CheckoutAddHandler(BaseHandler):
	def get(self):
		#validate access token
		if not self.ValidateToken():
			return
		checkout=Checkout()
		checkout.comment=self.get_argument("comment","")
		checkout.formapago=self.get_argument("formapago","")
		checkout.identifier=self.get_argument("identifier","")
		checkout.firstname=self.get_argument("firstname","")
		checkout.city=self.get_argument("city","")
		checkout.regionstate=self.get_argument("regionstate","")
		checkout.lastname=self.get_argument("lastname","")
		checkout.telephone=self.get_argument("telephone","")
		checkout.postcode=self.get_argument("postcode","")
		checkout.address=self.get_argument("address","")
		checkout.country=self.get_argument("country","")
		checkout.email=self.get_argument("email","")
		checkout.cart=self.get_argument("cart","")
		checkout.userid=self.get_argument("userid","")
		oid=checkout.Save(self.db.checkouts)
		self.write(oid)

