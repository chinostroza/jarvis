var swig	= require('swig');
var fs		= require('fs');

var Entity = require('./services/entity');
var Generator = require('./services/generator');
var RunTasks  = require('./services/runtasks');
var ReadTemplate = require('./readTemplate');

var args = process.argv

var command = "";

if (args.length == 2){
	command = "help"
}else if (args.length > 2 ){
	command = args[2]
}

if (command == 'generator'){

	if (args.length == 6){

		var templatePath = args[3];
		var jsonPathToTemplate = args[4];
		var scriptOutPath = args[5];

		mGenerator = new Generator(templatePath,jsonPathToTemplate,scriptOutPath);
		mGenerator.createScripts();

	}else{
		console.log("Error en el número de argumentos");
	}
}else if (command == 'entity'){
		if (args.length == 6){

		var json = args[3];
		var template = args[4];
		var ext = args[5];

		mEntity = new Entity(json,template,ext);
		mEntity.run();

	}else{
		console.log("Error en el número de argumentos");
	}

}else if (command == 'readtemplate'){

	var templatePath = args[3];
	mTemplate = new ReadTemplate();
	obj = mTemplate.read(templatePath);
	console.log(obj);
}else if (command == 'runtasks'){

	mRunTask = new RunTasks(args);
	mRunTask.readTask();

}else if (command == 'help'){
	console.log("");
	console.log(" Commands : ");
	console.log("");
	console.log(" jarvis entity json template ext");
	console.log(" jarvis generator template_path config_file|json|yml out_path_file");
	console.log(" jarvis readtemplate template_path");
	console.log(" jarvis runtasks");
}else{
	console.log('no existe el commando');
}
