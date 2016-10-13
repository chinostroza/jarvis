var fs		= require('fs');
var config = require("../../config/config.js");

var TemplateRemote = function (){

}

TemplateRemote.prototype.findByName=function(name){
  //open templates.json
  var mTemplates = (JSON.parse(fs.readFileSync(config.app_path + "data/" + "templates_remote.json", 'utf8'))).templates;
  var mTemplate = null;

  mTemplates.forEach(function(template,index,array){
    if (template.name == name){
      mTemplate =  template;
    }
  });

  return mTemplate;
}

module.exports = TemplateRemote;
