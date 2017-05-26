var swig			= require('swig');
var fs				= require('fs');
var swig			= require('swig');
var fs				= require('fs');
var path 			= require('path');
var JarvisTemplate 	= require('../jarvisTemplate');
var JarvisFilter    = require('../jarvisFilter');
var JarvisFiles     = require('../jarvisFiles');
const _ 			= require('lodash');
/*
	Runner class
	The mision of class command is generate a list of files
	from a objects filter of config files
	@param params type objects 
*/
var Runner = function( params ){

	//template file path
	this.template 	= params.template;
	//app config path
	this.config 	= params.config;
	//key of object to get of config json or yaml
	this.filter 	= params.filter;
	//key objecto what contains name of files to generate
	this.key 		= params.key;
	// future extension of files to generate
	this.ext		= params.ext;
	//directory of files generated
	this.destination= params.destination;
}

Runner.prototype.createScripts = function(){

	try {

		var mTemplate 		= new JarvisTemplate();
		//template filter class
		var filter_objs 	= mTemplate.get( this.config , this.filter );

		console.log("OBJECTO FILTRADO:",filter_objs);

		for( var i = 0 ; i < filter_objs.length ; i++ ){
			//generate string with code
			var outString = swig.renderFile (

				this.template,
				filter_objs [ i ]

			);
			//files filter class
			var params = {

				obj 			: filter_objs [ i ] ,
				filterString 	: this.key,
				data 			: outString,
				destination 	: this.destination,
				ext 			: this.ex

			}

			var mFiles 	= new JarvisFiles( params );
			mFiles.write();

		}
	
	} catch(err) {
	    console.log( 'Command Runner error to create Scripts : ', err.message );
	}
	
}
module.exports = Runner;