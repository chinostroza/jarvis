import tornado.auth
import tornado.httpserver
import tornado.ioloop
import tornado.options
import tornado.web
from basehandler import BaseHandler
from model.design import Design
class DesignAddHandler(BaseHandler):
	def get(self):
		#validate access token
		if not self.ValidateToken():
			return
		design=Design()
		design.body=self.get_argument("body","")
		design.category=self.get_argument("category","")
		design.updated=self.get_argument("updated","")
		design.designer=self.get_argument("designer","")
		design.costunit=self.get_argument("costunit","")
		design.created=self.get_argument("created","")
		design.title=self.get_argument("title","")
		design.avatar=self.get_argument("avatar","")
		design.user=self.get_argument("user","")
		design.id=self.get_argument("id","")
		design.description=self.get_argument("description","")
		oid=design.Save(self.db.designs)
		self.write(oid)

