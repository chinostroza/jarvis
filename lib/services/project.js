var fs				= require('fs');
var path 			= require('path');


var Project = function(type,name,path){
	this.type = type;
	this.name = name;
	this.path = path;
}
Project.prototype.setType = function( type ){
	this.type = type
}

Project.prototype.getType = function(){
	return this.type
}

Project.prototype.setName = function( name ){
	this.name = name
}

Project.prototype.getName = function(){
	return this.name
}

Project.prototype.setPath = function( path ){
	this.path = path
}

Project.prototype.getPath = function(){
	return this.path
}

Project.prototype.run = function(){
	try{
		
		console.log(__dirname)
	
	} catch(err) {
    	console.log( 'jarvis > Error in Project : ',  err);
	}

}

module.exports = Project;