#!/usr/bin/python
import os.path
import pymongo
import tornado.httpserver
import tornado.ioloop
import tornado.web
from designlisthandler import DesignListHandler
from designaddhandler import DesignAddHandler
from userlisthandler import UserListHandler
from useraddhandler import UserAddHandler
from tornado.options import define,options
define("port", default=9999, help="run on the given port", type=int)
class Application(tornado.web.Application):
	def __init__(self):
		settings = dict(
			blog_title=u"ControlPrint",
			template_path=os.path.join(os.path.dirname(__file__), "templates"),
			static_path=os.path.join(os.path.dirname(__file__), "static"),
			xsrf_cookies=True,
			cookie_secret="12oETzKXQAGaYdkL5gEmGeJJFuYh7EQnp2XdTP1o",
			login_url="/auth/login",
			debug=True)

		handlers=[
			(r"/design/list",DesignListHandler),
			(r"/design/add",DesignAddHandler),
			(r"/user/list",UserListHandler),
			(r"/user/add",UserAddHandler)
		]

		tornado.web.Application.__init__(self, handlers, **settings)

		''' configure database '''
		connection  = pymongo.Connection("localhost", 27017)
		self.db     = connection.controlprint


def main():
	tornado.options.parse_command_line()
	http_server = tornado.httpserver.HTTPServer(Application())
	http_server.listen(options.port)
	tornado.ioloop.IOLoop.instance().start()

if __name__ == "__main__":
	main()