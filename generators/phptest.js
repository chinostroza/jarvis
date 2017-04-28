var parser = require('php-parser');
var traverse = require('traverse');

var code = require('fs').readFileSync(__dirname + '/test1.php').toString();
//console.log(code);

var AST = parser.parseCode(code);

console.log(AST);

var tokens = parser.tokenGetAll(code);
//console.log(tokens);

/*

traverse(AST[1][0]).forEach(function (x) {
	console.log(x);
 
});
*/
/*
var func = AST[1][0];

var method =   func[5].methods[0];
// the result
console.log( '\nAST : ', method);
// the class code :
console.log( '\nPHP : >' + code.substring( method[1][2], method[2][2]) + '<' );
// the class AST
console.log( '\nMETHOD : ', method[3]);
*/

