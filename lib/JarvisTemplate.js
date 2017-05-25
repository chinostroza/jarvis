var yaml 	= require('js-yaml');
var fs		= require('fs');
const _ 	= require('lodash');
var JarvisTemplate = function(){}

JarvisTemplate.prototype.typeFile = function (filename){
	var fileNameSplit = filename.split('.');
	var ext = fileNameSplit[1];
	return ext;
}

JarvisTemplate.prototype.read = function (path){

	var path_file = path;
	var filename = path.replace(/^.*[\\\/]/, '');
	var ext = this.typeFile(filename);
	var obj = {}

	if (ext == "json"){
		obj = JSON.parse(fs.readFileSync(path_file, 'utf8'));
	}else if (ext == "yml"){
		obj  = yaml.load(fs.readFileSync(path_file, {encoding: 'utf-8'}));
	}

	return obj;
}

JarvisTemplate.prototype.get = function ( path, filter){

	var obj = this.read(path);

	var filterObject = _.get( obj, filter.toString() );

	return filterObject
	
}

module.exports = JarvisTemplate;