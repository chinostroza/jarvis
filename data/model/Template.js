var Template = function(name){
  this.name = name;
}


Template.prototype.setName = function (name){
  this.name = name
}

Template.prototype.getName = function (){
  return this.name;
}


module.exports = Template;
