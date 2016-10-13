//call Jarvis lib
var Jarvis	= require('./jarvis.js');

var ruta={
	name: "ruta",
	schema:[ 
			{"name":"id","type": "int" },
			{"name":"result_sumary_id","type": "int" },
			{"name":"vehicle_has_detail_id","type": "int" },
			{"name":"cluster","type": "int" },
			{"name":"total_items","type": "int" },
			{"name":"total_orders","type": "int" },
			{"name":"total_addresses","type": "int" },
			{"name":"total_distance","type": "int" },
			{"name":"total_time","type": "int" },
			{"name":"start_time","type": "String" },
			{"name":"load_factor_1","type": "float" },
			{"name":"load_factor_2","type": "float" },
			{"name":"load_factor_3","type": "float" },
			{"name":"beetrack_route_id","type": "int" },
			{"name":"beetrack_status","type": "int" },
			{"name":"code","type": "String" },
			{"name":"addresses","type": "Lugar[]" }
		  ]
}

template = {
	"title":"APP android model",
	"nameapp": "test",
	"path" : "templates/app/android/",
	"output_path": "tmp/app/test/",
	"dbname": "test",
	"port":3003,
	"entitys":[ruta]
};

mJarvis = new Jarvis(template);

mJarvis.go();