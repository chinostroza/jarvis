import os
import shutil, errno

class FileGenerator:

	def pwd(self):
		return os.getcwd()
	
	def createFile(self,nameFile):
		open(nameFile, 'a').close()

	def createListFile(self,path,listFile):
		for x in listFile:
			self.createFile(path+'/'+x)

	def createDirectory(self,nameDirectory):
		if not os.path.exists(nameDirectory):
			os.makedirs(nameDirectory)

	def createListDirectory(self,path,listDirectory):
		for x in listDirectory:
			self.createDirectory(path+x)
			
	def stringToFile(self,pathfile,string):
		text_file = open(pathfile, "w")
		text_file.write(string)
		text_file.close()

	def copyanything(self,src, dst):
		if not os.path.exists(dst):
			try:
				shutil.copytree(src, dst)
			except OSError as exc: # python >2.5
				if exc.errno == errno.ENOTDIR:
					shutil.copy(src, dst)
				else: raise