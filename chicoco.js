//call Jarvis lib
var Jarvis	= require('./jarvis.js');


//TODO: agrupar las entidades en un unico objeto
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
	"title":"API CHICOCO",
	"nameapp": "test",
	"path" : "templates/web/chicoco/",
	"output_path": "tmp/web/test/",
	"entitys":[order,item]
};

//TODO change a of 

mJarvis = new Jarvis(template);

mJarvis.go();