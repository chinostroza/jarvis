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

module.exports = Project;