var swig	= require('swig');
var fs		= require('fs');

var Jarvis = function(template){

	this.template = template;
};

Jarvis.prototype.parser = function(code){
	console.log(JSON.stringify(esprima.parse(code), null, 4));
}

Jarvis.prototype.createScripts = function(){

	//read project.json task
	var tasks = (JSON.parse(fs.readFileSync(this.template.path + "tasks.json", 'utf8'))).tasks;
	//read entitys
	var entitys = this.template.entitys

	tasks.forEach(function(task, index, array){

		//path templete file
		var pathTemplate = this.template.path + "template/" + task["template"];

		if (task.type != "boot"){

			entitys.forEach(function(entity,index,array){

				//generate a string from template
				var outString = swig.renderFile(pathTemplate ,{
					"entidad"	: entity.name,
					"cols"	: entity.cols,
					"schema"	: entity.schema
				});

				//parser file
				//console.log(JSON.stringify(esprima.parse(outString), null, 4));

				//write a file from string template
				if (task.type == "controller"){
					var outTmpFile = task.write +"/"+ entity.name + "s" + task.name_file +task.ext;
				}else if (task.type == "model"){
					var outTmpFile = task.write +"/"+ entity.name + task.name_file + task.ext;
				}
				//if directory exits
				if (!fs.existsSync(task.write)){
	    			fs.mkdirSync(task.write);
				}

				//write file
				fs.writeFile(outTmpFile, outString , function(err) {
		    		if(err) {
		        		return console.log(err);
		    		}

	    			console.log(task.name + " ok!");
				});//end write file

			});//end entitys.forEach()
		}else if (task.type == "boot"){
			var controllers = [];
			var models		= [];
			var port		= this.template.port;
			var nameapp		= this.template.nameapp;
			var dbname		= this.template.dbname;
			entitys.forEach(function(entity,index,array){
				models.push(entity.name);
 				controllers.push(entity.name);
			});

			var outString = swig.renderFile(pathTemplate ,{
					"dbname"	: dbname,
					"nameapp"	: nameapp,
					"port"		: port,
					"models"	: models,
					"controllers":controllers
				});

			var outTmpFile = task.write +"/api.js"
							//if directory exits
			if (!fs.existsSync(task.write)){
	    		fs.mkdirSync(task.write);
			}

			//write file
			fs.writeFile(outTmpFile, outString , function(err) {

		    	if(err) {
		        	return console.log(err);
		    	}

	    		console.log(task.name + " ok! file :" + outTmpFile);
			});//end write file
		}//end if(task.type)
	});//end tasks.forEach()
}

Jarvis.prototype.go = function(){
	this.createScripts();
}

module.exports = Jarvis;
