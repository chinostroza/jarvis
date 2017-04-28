
var item = {
	name :"item",
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
		{"name":"reason_id","type":"int"},
		{"name":"order_status_id","type":"int"},
		{"name":"items"		,"type":"ArrayList","childname":"item"}
	]

}

var result={
	name:"result",
	schema:[
		{"name":"id"					,"type":"String"},
		{"name":"position"				,"type":"int"},
		{"name":"delivery_time"			,"type":"int"},
		{"name":"delivery_time_human"	,"type":"String"},
		{"name":"order"					,"type":"Object","childname":"order"}
	]
}

var address={
	name:"address",
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
			{"name":"results"	,"type":"ArrayList", "childname":"result"}
		]
}

var reason={
	name :"reason",
	schema:[
		{"name":"id","type":"int"},
		{"name":"description","type":"String"}
	]
}

var route={
	name: "route",
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
			{"name":"addresses","type": "ArrayList","childname": "address"}
		  ]
}


var scenarios = {
	"name":"scenario",
  "request":{
    "params":[
      {"name":"organization_id","type":"int"}
    ],
    "body":{},
    "url":"",
    "method":""
  },
  "response":{
    "scenarios": [
      {
        "id": 6343,
        "scenario_state_id": 12,
        "token": "b3b132af-f859-499e-80fc-6d8228c7f673",
        "schema_id": 83,
        "deposit_id": 94,
        "description": "Otero Items",
        "start_time": "2000-01-01T08:30:00.000Z",
        "end_time": "2000-01-01T14:30:00.000Z",
        "deploy_date": "2017-10-06",
        "return_trip": true,
        "multiple_trips": false,
        "reload_time": 0,
        "service_time": 10,
        "message": "Start|End",
        "fleet_name": "Driv.in",
        "percentage": "98.0",
        "reoptimization": 0,
        "grouped": true,
        "is_simulation": null,
        "active": true,
        "created_at": "2016-10-05T18:26:29.000Z",
        "updated_at": "2016-10-05T18:27:43.000Z"
        }
    ]
  },
	"schema" : [
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

var tasks ={
  	"name":"ANDROID  tasks",
  	"tasks":[
			/*
  				{
  					"name":"Task Api android APP file Generator",
  					"type":"api_android",
  					"template":"EntityApi.java",
  					"name_file":"Api",
  					"write":"tmp/",
  					"ext":".java"
  				},*/
          {
            "name":"Task Model Parcelable android APP file Generator",
            "type":"model",
            "template":"Entity.java",
            "name_file":"",
            "write":"tmp/",
            "ext":".java"
          }
  			]
  };

var Jarvis	= require('./jarvis.js');



mJarvis = new Jarvis([reason],tasks);

mJarvis.go();
