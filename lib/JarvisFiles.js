var JarvisFilter = require('./jarvisFilter');
var fs				= require('fs');
var path 			= require('path');


var JarvisFiles = function( params ){

	var filterParams = {

		data	: params.obj, 
		cmd		: params.filterString, 
		type	: "string"

	};

	var mJarvisFilter 	= new JarvisFilter( filterParams );
	
	this.fileNameBody = mJarvisFilter.getString();

	console.log('this.fileNameBody',this.fileNameBody);
	this.fileNameExt 	= params.ext;
	this.destination 	= params.destination;
	this.data		 	= params.data;
	
}

JarvisFiles.prototype.write = function( outString ){

	try {

    	var path_file = '';
		var fileName  = this.fileNameBody + '.' + this.fileNameExt;

		if ( this.destination != '' ){
			if (!fs.existsSync(this.destination)){
			    fs.mkdirSync(this.destination);
			}
			path_file = path.join( this.destination, fileName );
		}else{
			path_file = fileName;
		}

		if ( path_file != '' ){

			fs.writeFile( path_file , this.data , function(err) {
				if(err) {
					return console.log(err);
				}
			});

			console.log( " file generate :" + path_file );
		}else{
			console.log( " error en path to file generator:", path_file );
		}
	}
	catch(err) {
	    console.log( 'JarvisFiles error write ; ',  err.message );
	}

}

module.exports = JarvisFiles;