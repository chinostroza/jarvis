var swig	= require('swig');


var Render = function(template,object){
	this.template = template;
	this.obj= object;
}

Render.prototype.createScripts = function(){

	var outString = swig.renderFile(
		this.template,
		this.obj
	);
	//filters
	outString = outString.replace(/&lt;/g,"<").replace(/&gt;/g,">");

	//write scripts file
	return outString;
}

module.exports = Render;
