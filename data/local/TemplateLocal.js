var fs		= require('fs');
var config = require("../../config/config.js");

var TemplateLocal = function (){
  this.templates=null;
}

TemplateLocal.prototype.findAll = function(){
  //open templates.json
  var templates = (JSON.parse(fs.readFileSync(config.app_path + "data/" + "templates.json", 'utf8'))).templates;
  this.templates = templates;
  return this.templates;
}

TemplateLocal.prototype.getTemplates = function (){
  return this.templates;
}

TemplateLocal.prototype.findByName=function(name){
  var mTemplates = this.getTemplates();
  var mTemplate = null;

  mTemplates.forEach(function(template,index,array){
    if (template.name == name){
      mTemplate =  template;
    }
  });

  return mTemplate;
}

module.exports = TemplateLocal;
