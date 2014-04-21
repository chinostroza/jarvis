import tornado.auth
import tornado.httpserver
import tornado.ioloop
import tornado.options
import tornado.web
from basehandler import BaseHandler
from model.design import Design
class DesignListHandler(BaseHandler):
	def get(self):
		#validate access token
		if not self.ValidateToken():
			return
		current_page 	= "1"
		items_per_page 	= "10"
		design=Design()
		try:
			current_page 	= int(self.TryGetParam("page", "1"))
			items_per_page 	= int(self.TryGetParam("items", "10"))
		except Exception, e:
			print str(e)
		self.write(design.GetList(current_page, items_per_page, self.db.designs))


