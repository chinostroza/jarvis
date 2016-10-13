var TemplateRepository = require("../../data/TemplateRepository.js");

var JarvisCodeGeneration = function(){
	this.template = null;
};

JarvisCodeGeneration.prototype.findTemplateByName = function (name){

	var mTemplateRepository = new TemplateRepository();
	this.template = mTemplateRepository.findByName(name);
	return this.template;
}

JarvisCodeGeneration.prototype.getTemplate = function(){
	return this.template;
};

JarvisCodeGeneration.prototype.getInTemplate = function (){
	var mTemplate = this.getTemplate();
	return mTemplate.in;
}

module.exports = JarvisCodeGeneration;
