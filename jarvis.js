var swig	= require('swig');
var fs		= require('fs');
var util	= require('./lib/util.js');




var Jarvis = function(template){

	this.template = template;
};

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
					"campos"	: entity.cols,
					"schema"	: entity.schema
				});

				//write a file from string template
				if (task.type == "controller"){
					var outTmpFile = task.write +"/"+ entity.name + "s.js"
				}else if (task.type == "model"){
					var outTmpFile = task.write +"/"+ entity.name + ".js"
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

	    		console.log(task.name + " ok!");
			});//end write file
		}//end if(task.type)
	});//end tasks.forEach()
}

Jarvis.prototype.go = function(){
	this.createScripts();
}

var order={
	name: "order",
	schema:[ 
			{"name":"id","type": "Number" },
			{"name":"route_id","type": "Number" },
			{"name":"order_id","type": "Number" },
			{"name":"code","type": "String" },
			{"name":"status","type": "Number" },
			{"name":"position","type": "Number" },
			{"name":"created_ad","type": "Date" },
			{"name":"updated_ad","type": "Date" }
		  ]
}

var item={
	name: "item",
	schema:[ 
			{"name":"id","type": "Number" },
			{"name":"order_id","type": "Number" },
			{"name":"code","type": "String" },
			{"name":"title","type": "String" },
			{"name":"quantity","type": "Number" },
			{"name":"status","type": "Number" },
			{"name":"created_ad","type": "Date" },
			{"name":"updated_ad","type": "Date" }
		  ]
}

template = {
	"title":"API nodejs_mongoose",
	"nameapp": "test",
	"path" : "templates/api/nodejs_mongoose/",
	"output_path": "tmp/api/test2/",
	"dbname": "test",
	"port":3003,
	"entitys":[order,item]
};

//TODO change a of 

mJarvis = new Jarvis(template);

mJarvis.go();
