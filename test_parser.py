import ast
import pprint
from greentreesnakes.astpp import parseprint
path = "controlprint/model/cart.py"
tree = ast.parse(open(path).read())
print tree
parseprint(tree)
'''
class FuncLister(ast.NodeVisitor):
	def visit_FunctionDef(self, node):
		print(node.name)
		self.generic_visit(node)
	def visit_ClassDef(self, node):
		for x in node.body:
			for y in x.body:
				self.visit_FunctionDef(y)
		self.generic_visit(node)

FuncLister().visit(tree)
'''


#leer una clase  ok
#modificar el codigo
#tormar la clase applicartion de tornado y agregar una nueva url
