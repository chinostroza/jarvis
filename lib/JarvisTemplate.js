var yaml 	= require('js-yaml');
var fs		= require('fs');
const _ 	= require('lodash');
var JarvisFilter = require('./jarvisFilter');

var JarvisTemplate = function(){}

JarvisTemplate.prototype.typeFile = function (filename){
	
	try{

		var fileNameSplit = filename.split('.');
		var ext = fileNameSplit[1];
		return ext;

	} catch(err) {

	    console.log( 'JarvisTemplate typeFile to get : ', err.message );
	    return null;

	}	
}

JarvisTemplate.prototype.read = function (path){

	try{

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

	} catch(err) {

	    console.log( 'JarvisTemplate read to get : ', err.message );
	    return null;

	}	
}

JarvisTemplate.prototype.get = function ( path, cmd ){

	try{

		var obj = this.read(path);

		var filterParams = { data:obj, cmd:cmd, type:"object" };

		var mJarvisFilter = new JarvisFilter( filterParams );

		var filterObject = mJarvisFilter.getObject();

		return filterObject;

	} catch(err) {

	    console.log( 'JarvisTemplate error to get : ', err.message );
	    return null;

	}	
}

module.exports = JarvisTemplate;