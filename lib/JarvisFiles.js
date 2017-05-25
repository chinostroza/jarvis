var JarvisFiles = function(){}


JarvisFiles.prototype.getPath = function ( obj, key ){
	
		if (this.key.indexOf(op_func) != -1){
			var arrKey = this.key.split(op_func);
			this.key = arrKey[ 0 ];
			var cmd = arrKey[ 1 ];
			
			is_filter = true;
		}

		
		if (this.key.indexOf(op_more) != -1){
			var arrKey = this.key.split(op_more);
			lastString =arrKey[ 1 ];
			this.key = arrKey[ 0 ];
		}

		//write scripts file
		var file = _.get( filter_objs [ i ] , this.key.toString() );

		var fileName = file + lastString + "." + this.ext;

		
		if (is_filter == true){

			mFilter = new Filter();
			fileName = mFilter.run(cmd, fileName.toString())

		}else{
			fileName = fileName.toString();
		}
		
		var path_file = fileName;

		if (this.destination != ''){
			if (!fs.existsSync(this.destination)){
		    	fs.mkdirSync(this.destination);
			}
			var path_file = path.join( this.destination, fileName );
		}
	
}

JarvisFiles.prototype.write = function(path,outString){

		fs.writeFile( path , outString , function(err) {
			if(err) {
				return console.log(err);
			}
		});

		console.log(" file generate :" + fileName );
}

module.exports = JarvisFiles;