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
		design.body=self.get_argument("body","")
		design.category=self.get_argument("category","")
		design.updated=self.get_argument("updated","")
		design.designer=self.get_argument("designer","")
		design.costunit=self.get_argument("costunit","")
		design.created=self.get_argument("created","")
		design.title=self.get_argument("title","")
		design.avatar=self.get_argument("avatar","")
		design.user=self.get_argument("user","")
		design.sku=self.get_argument("sku","")
		design.identifier=self.get_argument("identifier","")
		design.description=self.get_argument("description","")
		design.Save()


