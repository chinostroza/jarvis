//call Jarvis lib
var Jarvis	= require('./jarvis.js');

var producto = {
	name :"producto",
	method:[
		{ "name":"acceptProducto",
		  "type":"update",
			"values":["id"],
			"where":["id"]
		},
		{
			"name":"rejectProducto",
			"type":"update",
			"values":["id"],
			"where":["id"]
		}
	],
	schema:[
			{"name":"id"				,"type":"int","isprimary":"1"},
			{"name":"description"		,"type":"String"},
			{"name":"code"				,"type":"String"},
			{"name":"units"				,"type":"int"},
			{"name":"delivered_units"	,"type":"int"},
			{"name":"units_1"			,"type":"int"},
			{"name":"units_2"			,"type":"int"},
			{"name":"units_3"			,"type":"int"},
			{"name":"status_id","type":"int"}
		]
}

var orden = {
	name:"orden",
	schema:[
		{"name":"id"			,"type":"int"},
		{"name":"code"			,"type":"String"},
		{"name":"units_1"		,"type":"int"},
		{"name":"units_2"		,"type":"int"},
		{"name":"units_3"		,"type":"int"},
		{"name":"service_time"	,"type":"int"},
		{"name":"status_id","type":"int"},
		{"name":"productos"		,"type":"ArrayList","childname":"producto"}
	]

}

var resultado={
	name:"resultado",
	schema:[
		{"name":"id"					,"type":"String"},
		{"name":"position"				,"type":"int"},
		{"name":"delivery_time"			,"type":"int"},
		{"name":"delivery_time_human"	,"type":"String"},
		{"name":"orden"					,"type":"Object","childname":"orden"}
	]
}

var lugar={
	name:"lugar",
	schema:[
			{"name":"type"			,"type":"String"},
			{"name":"id"			,"type":"int"},
			{"name":"code"			,"type":"String"},
			{"name":"address_1"		,"type":"int"},
			{"name":"address_2"		,"type":"int"},
			{"name":"lat"			,"type":"float"},
			{"name":"lng"			,"type":"float"},
			{"name":"name"			,"type":"String"},
			{"name":"reload_time"	,"type":"int"},
			{"name":"position"		,"type":"int"},
			{"name":"delivery_time"	,"type":"int"},
			{"name":"resultados"	,"type":"ArrayList", "childname":"resultado"}
		]
}

var ruta={
	name: "ruta",
	schema:[
			{"name":"id","type": "int"},
			{"name":"description","type":"String"},
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
			{"name":"lugares","type": "ArrayList","childname": "lugar"}
		  ]
}


var escenario = {
	name:"escenario",
	schema : [
				{"name":"id","type":"int"},
				{"name":"scenario_state_id","type":"int"},
				{"name":"token","type":"String"},
				{"name":"schema_id","type":"int"},
				{"name":"deposit_id","type":"int"},
				{"name":"description","type":"String"},
				{"name":"start_time","type":"String"},
				{"name":"end_time","type":"String"},
				{"name":"deploy_date","type":"String"},
				{"name":"return_trip","type":"boolean"},
				{"name":"multiple_trips","type":"String"},
				{"name":"reload_time","type":"int"},
				{"name":"service_time","type":"int"},
				{"name":"message","type":"String"},
				{"name":"fleet_name","type":"String"},
				{"name":"percentage","type":"String"},
				{"name":"reoptimization","type":"int"},
				{"name":"grouped","type":"boolean"},
				{"name":"is_simulation","type":"boolean"},
				{"name":"active","type":"boolean"},
				{"name":"created_at","type":"String"},
				{"name":"updated_at","type":"String"}
	]
}
/*
ruta by vehicul
orden by rutaid
*/
template = {
	"title":"APP android model",
	"nameapp": "test",
	"path" : "templates/app/android/",
	"output_path": "tmp/app/drivin2/",
	"dbname": "test",
	"port":3003,
	"entitys":[ruta,lugar,resultado,orden,producto,escenario]
};

mJarvis = new Jarvis(template);

mJarvis.go();