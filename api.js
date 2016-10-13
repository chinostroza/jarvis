//call Jarvis lib
var Jarvis	= require('./jarvis.js');

var hashtag={
	name:"hashtag",
	schema:[
		{"name":"id","type":"Number"},
		{"name":"text","type":"String"},
		{"name":"date","type":"String"}
	]
}

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

var photo = {
	name:"photo",
	schema:[
		{"name":"id","type":"Number"},
		{"name":"hashtag_id","type":"Number"},
		{"name":"height","type":"Number"},
		{"name":"width","type":"Number"},
		{"name":"rgb_red","type":"Number"},
		{"name":"rgb_green","type":"Number"},
		{"name":"rgb_blue","type":"Number"}
	]
}



template = {
	"title":"API nodejs_mongoose",
	"nameapp": "recuerdos",
	"path" : "templates/api/nodejs_mongoose/",
	"output_path": "tmp/api/recuerdos/",
	"dbname": "recuerdos",
	"port":8080,
	"entitys":[hashtag,user,photo]
};

//TODO change a of

mJarvis = new Jarvis(template);

mJarvis.go();
