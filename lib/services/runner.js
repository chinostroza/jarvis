var swig			= require('swig');
var fs				= require('fs');
var swig			= require('swig');
var fs				= require('fs');
var path 			= require('path');
var JarvisTemplate 	= require('../jarvisTemplate');
var JarvisFilter    = require('../jarvisFilter');
var JarvisFiles     = require('../jarvisFiles');
const _ 			= require('lodash');

var Runner = function( params ){

	this.template 	= params.template;
	this.config 	= params.config;
	this.filter 	= params.filter;
	this.key 		= params.key;
	this.ext		= params.ext;
	this.destination= params.destination;
}

Runner.prototype.createScripts = function(){

	var mTemplate 		= new JarvisTemplate();
	var mFile 			= new JarvisFile();
	var filter_objs 	= mTemplate.get( this.config , this.filter );

	for(var i = 0 ; i < filter_objs.length ; i++ ){
		//generate string with code
		var outString = swig.renderFile(
			this.template,
			filter_objs [ i ]
		);

		var mFiles 		= new JarvisFiles();
		var path_file 	= mFiles.getPath( filter_objs [ i ] , this.key );

		mFiles.write( path_file, outString)

	}
}

module.exports = Runner;