var TemplateLocal = require("./local/TemplateLocal.js");
var TemplateRemote = require("./remote/TemplateRemote.js");

var TemplateRepository = function (){
  //get Local templates
  var mTemplateLocal = new TemplateLocal();
  this.localTemplate = mTemplateLocal;
  this.templates = mTemplateLocal.findAll();
}

TemplateRepository.prototype.findAll = function(){

  return this.templates;
}

TemplateRepository.prototype.findByName = function (name){
  //validate if the templates is not in Local storage
  //find name template
  var mTemplate = this.localTemplate.findByName(name);

  if (mTemplate){
    return mTemplate;
  } else {
    //call remote template
    var mTemplateRemote = new TemplateRemote();
    return mTemplateRemote.findByName(name);
  }
}

module.exports = TemplateRepository;
