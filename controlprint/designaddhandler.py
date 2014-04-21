import tornado.auth
import tornado.httpserver
import tornado.ioloop
import tornado.options
import tornado.web
from basehandler import BaseHandler
from model.design import Design
class DesignAddHandler(BaseHandler):
	def get(self):
		design=Design()
		self.render("design/add.html",design=design)

	def post(self):
		design=Design()
		design.category=self.get_argument("category","")
		design.body=self.get_argument("body","")
		design.updated=self.get_argument("updated","")
		design.designer=self.get_argument("designer","")
		design.created=self.get_argument("created","")
		design.title=self.get_argument("title","")
		design.user=self.get_argument("user","")
		design.id=self.get_argument("id","")
		design.save()
		self.redirect("/design?dn=t")

