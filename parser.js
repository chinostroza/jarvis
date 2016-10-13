var fs		= require('fs');
/*
var escope = require('escope');
*/
var esprima = require('esprima');
//var estraverse = require('estraverse');
//var esrefactor = require('esrefactor');
//var traverse = require('traverse');
var escodegen = require('escodegen');

code = fs.readFileSync("tmp/api/test3/api.js", 'utf8');

var ast = esprima.parse(code);


var newControllerAst = esprima.parse("var item_controller2 = require('./controllers/items');");


console.log(JSON.stringify(newControllerAst.body[0],null,4) );


ast.body.splice(13,0,newControllerAst.body[0]);

var codeGen = escodegen.generate(ast);

console.log(codeGen);


/*
fs.writeFile("arbol.body.data", JSON.stringify(body,null,4) , function(err) {
                
    if(err) {
        return console.log(err);
    }
});
*/

/*
var scrubbed = traverse(tree).map(function (node) {
    console.log(node.type);
    //if (this.circular) this.remove()
});
*/
/*
var appUseObj = tree.callExpression("test.route");

var nodes = appUseObj.nodes


console.log("objetos:"+nodes.length);

var node  = nodes[nodes.length - 1];

console.log(node.arguments);

node.append('var a = 1;' + tree.verbatim('ANYTHING'));

console.log(tree.toString());
*/


/*
var scopeManager = escope.analyze(ast);
var currentScope = scopeManager.acquire(ast);




var ctx = new esrefactor.Context(code);

var id = ctx.identify(667);
var code = ctx.rename(id, 'longi_controller');
console.log(code);
*/