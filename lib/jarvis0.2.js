var swig	= require('swig');
var fs		= require('fs');


function capitalize(string) {
    return string.charAt(0).toUpperCase() + string.slice(1);
}

var Jarvis = function(entitys,tasks){

  this.entitys = entitys;
  this.tasks = tasks.tasks;
  console.log(this.tasks);


};

Jarvis.prototype.parser = function(code){
	console.log(JSON.stringify(esprima.parse(code), null, 4));
}

Jarvis.prototype.createScripts = function(){

	//read project.json task
	//var tasks = (JSON.parse(fs.readFileSync(this.template.path + "tasks.json", 'utf8'))).tasks;
  var tasks = this.tasks;
	//read entitys
	var entitys = this.entitys;

  console.log("J A R V I S > G O  G E N E R A T O R <");
  console.log("J A R V I S > T E M P L A T E S:");

	tasks.forEach(function(task, index, array){

		//path templete file
		var pathTemplate = task["template"];


    console.log("J A R V I S > "+pathTemplate);

		if (task.type != "boot"){


			entitys.forEach(function(entity,index,array){

				//generate a string from template
        if (task.type != "api_android"){
          var outString = swig.renderFile(pathTemplate ,{
            "entidad"	: entity.name,
            "cols"	: entity.cols,
            "schema"	: entity.schema
          });
        }else if (task.type == "api_android"){
          console.log(pathTemplate);
          var outString = swig.renderFile(pathTemplate ,entity);
        }

				//parser file
				//console.log(JSON.stringify(esprima.parse(outString), null, 4));

				//write a file from string template
				if (task.type == "controller"){
					var outTmpFile = task.write +"/"+ capitalize(entity.name) + "s" + task.name_file +task.ext;
				}else if (task.type == "model"){
					var outTmpFile = task.write +"/"+ capitalize(entity.name) + task.name_file + task.ext;
				}else if (task.type == "api_android"){
          var outTmpFile = task.write +"/"+ capitalize(entity.name) + "s"+ task.name_file + task.ext;
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
