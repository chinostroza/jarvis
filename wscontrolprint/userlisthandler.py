import tornado.auth
import tornado.httpserver
import tornado.ioloop
import tornado.options
import tornado.web
from basehandler import BaseHandler
from model.user import User
from bson import json_util
class UserListHandler(BaseHandler):
	def get(self):
		#validate access token
		if not self.ValidateToken():
			return
		current_page 	= "1"
		items_per_page 	= "10"
		user=User()
		try:
			current_page 	= int(self.TryGetParam("page", "1"))
			items_per_page 	= int(self.TryGetParam("items", "10"))
		except Exception, e:
			print str(e)
		self.write(user.GetList(current_page, items_per_page, self.db.users))


