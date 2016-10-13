var fs		= require('fs');
var recast = require("recast");

code = fs.readFileSync("tmp/api/test3/api.js", 'utf8');
/*
var code = [
    "function add(a, b) {",
    "  return a +",
    "    // Weird formatting, huh?",
    "    b;",
    "}",
    "function del(a) {",
    "  return a +",
    "    // Weird formatting, huh?",
    "    b;",
    "}"
].join("\n");
*/

var codeAdd = [
				"var item_controller2 = require('./controllers/items');"
				].join("\n");

var ast = recast.parse(code);


var astAdd = recast.parse(codeAdd);

var body = ast.program.body;

console.log(body);

/*

var ast = recast.parse(code);

ast.program.body.push(2, 0, astAdd);

var output = recast.print(ast).code;

console.log(output);

*/

/*

var contObj = ast.program.body.length;

for (i = 0 ; i < contObj;i++){

	var add = ast.program.body[i];

	console.log(add);
}

console.log(contObj);
*/

/*
// Make sure it's a FunctionDeclaration (optional).
var n = recast.types.namedTypes;
n.FunctionDeclaration.assert(add);

// If you choose to use recast.builders to construct new AST nodes, all builder
// arguments will be dynamically type-checked against the Mozilla Parser API.
var b = recast.types.builders;

// This kind of manipulation should seem familiar if you've used Esprima or the
// Mozilla Parser API before.
ast.program.body[0] = b.variableDeclaration("var", [
    b.variableDeclarator(add.id, b.functionExpression(
        null, // Anonymize the function expression.
        add.params,
        add.body
    ))
]);

// Just for fun, because addition is commutative:
add.params.push(add.params.shift());

var output = recast.print(ast).code;

console.log(output);
*/