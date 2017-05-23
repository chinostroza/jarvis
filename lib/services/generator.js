var swig	= require('swig');
var fs		= require('fs');
var swig	= require('swig');
var fs		= require('fs');
var path 	= require('path');
var ReadTemplate = require('../readTemplate');


var Generator = function(templatePath,jsonPathToTemplate,scriptOutPath){
	this.templatePath = templatePath;
	this.jsonPathToTemplate = jsonPathToTemplate;
	this.scriptOutPath = scriptOutPath;
}

Generator.prototype.createScripts = function(){

	//json to object
	//var pathTemplate = path.join(__dirname, '..', this.jsonPathToTemplate);
	
	var pathTemplate = this.jsonPathToTemplate;
	mTemplate = new ReadTemplate();
	var objectToTemplate = mTemplate.read(pathTemplate);
	//var objectToTemplate = JSON.parse(fs.readFileSync(pathTemplate, 'utf8'));

	//generate string with code
	var outString = swig.renderFile(
		this.templatePath,
		objectToTemplate
	);

	//write scripts file
	fs.writeFile(this.scriptOutPath, outString , function(err) {
		if(err) {
			return console.log(err);
		}
	});

	console.log(" file generate :" + this.scriptOutPath);

}

module.exports = Generator;