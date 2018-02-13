var objToConfig = function(obj){
  this.obj = obj;
  this.nameClass = '';
  this.nameAuthor = '';
  this.nameApp = '';
  this.namePackage = '';
  this.nameAuthorEmail = '';
}

objToConfig.prototype.isInt = function (n){
    return Number(n) === n && n % 1 === 0;
}

objToConfig.prototype.isFloat = function (n){
    return Number(n) === n && n % 1 !== 0;
}

objToConfig.prototype.setNameAuthor = function (nameAuthor){
  this.nameAuthor = nameAuthor;
}

objToConfig.prototype.setNameAuthorEmail = function (nameAuthorEmail){
  this.nameAuthorEmail = nameAuthorEmail;
}

objToConfig.prototype.setNameApp = function (nameApp){
  this.nameApp = nameApp;
}

objToConfig.prototype.setNamePackage = function (namePackage){
  this.namePackage = namePackage;
}

objToConfig.prototype.setNameClass = function (nameClass){
  this.nameClass = nameClass;
}

objToConfig.prototype.getHeader = function (){
/*
---
author:
  name: Carlos Hinostroza Droguett
  email: c@zea.cl
app:
  name : Car
  package: com.car.model
*/

  var out = "---\n";
  out += "author:\n";
  out += "  name: " + this.nameAuthor + "\n";
  out += "  email: " + this.nameAuthorEmail + "\n";
  out += "app:\n";
  out += "  name: " + this.nameApp + "\n";
  out += "  package: " + this.namePackage + "\n";
  return out;
}


objToConfig.prototype.getEntity = function (){
  /*
  entity:
    name_class: Car
  */
  var out = "entity:\n";
  out += "  name_class: " + this.nameClass + "\n";
  return out;
}

objToConfig.prototype.getProperties = function (){


  var out = "properties:\n";

  for(var propertyName in this.obj) {

     out += "  - name: " + propertyName + "\n";

     if (typeof(this.obj[propertyName]) == "object"){
      out += "    type: " + propertyName.replace(/\b\w/g, function(l){ return l.toUpperCase() }) + "\n";
     }else if (typeof(this.obj[propertyName]) == "number"){
      if(this.isInt(this.obj[propertyName])){
        out += "    type: int"  + "\n";
      }else{
        out += "    type: float" +  "\n";
      } 
     }else{
      out += "    type: " + typeof(this.obj[propertyName]) + "\n";
     }
     
  }
    return out;
}

objToConfig.prototype.getConfigYml = function (){
  var out = "";
  out += this.getHeader();
  out += this.getEntity();
  out += this.getProperties();
  return out;
}

module.exports = objToConfig;