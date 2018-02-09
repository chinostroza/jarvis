var yaml 	= require('js-yaml');
var fs		= require('fs');
var ReadTemplate = function(){}



ReadTemplate.prototype.typeFile = function (filename){
	var fileNameSplit = filename.split('.');
	var ext = fileNameSplit[1];
	return ext;
}

ReadTemplate.prototype.read = function (path){
	console.log(path);
	var path_file = path;
	var filename = path.replace(/^.*[\\\/]/, '');
	var ext = this.typeFile(filename);
	var obj = {}

	if (ext == "json"){
		obj = JSON.parse(fs.readFileSync(path_file, 'utf8'));
	}else if (ext == "yml"){

		console.log(path_file);
		obj  = yaml.load(fs.readFileSync(path_file, {encoding: 'utf-8'}));
	}

	return obj;
}

module.exports = ReadTemplate;