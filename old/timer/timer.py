import time
import threading
import sys
import pyglet

class Timer(threading.Thread):
	def __init__(self,seconds):
		self.runTime=seconds
		threading.Thread.__init__(self)
	def run(self):
		time.sleep(self.runTime)
		song=pyglet.media.load('badtothebone.ogg')
		song.play()
		pyglet.app.run()
		#badtothebone.ogg

t=Timer(float(sys.argv[1]))
t.start()