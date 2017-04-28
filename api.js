//call Jarvis lib
var Jarvis	= require('./jarvis2.js');

var user = {
	name:"user",
	schema:[
		{"name":"id","type":"Number"},
		{"name":"username","type":"String"},
		{"name":"password","type":"String"},
		{"name":"name","type":"String"},
		{"name":"lastname","type":"String"}
	]
}

var box = {
	name:"box",
	schema:[
		{"name":"id","type":"Number"},
		{"name":"height","type":"Number"},
		{"name":"width","type":"Number"},
		{"name":"x","type":"Number"},
		{"name":"y","type":"Number"},
		{"name":"z","type":"Number"}
	]
}



template = {
	"title":"API nodejs_mongoose",
	"nameapp": "allisbox",
	"path" : "templates/api/nodejs_mongoose/",
	"output_path": "tmp/api/allisbox/",
	"dbname": "allisbox",
	"port":3002,
	"entitys":[user,box]
};

//TODO change a of

mJarvis = new Jarvis(template);

mJarvis.go();
