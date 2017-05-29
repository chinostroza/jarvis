const _ 	= require('lodash');

var JarvisFilter = function( filter ){

	try {

		this.operatorFunction = '?';
		this.operatorEqual = '=';
		this.operatorMore = '+';
		this.outObject = {};
		this.outString = '';

		if ( filter.type == 'object' ){

			this.outObject = this.filterObject( filter );

		} else if ( filter.type == 'string' ){

			this.outString = this.filterString( filter );
		}

	}catch(err) {
	    console.log( 'JarvisFilter error constructor ; ',  err.message );
	    return null;
	}
}

JarvisFilter.prototype.getString = function (){

	return this.outString;

}

JarvisFilter.prototype.getObject = function (){

	return this.outObject;

}


JarvisFilter.prototype.splitCmdParamToString = function ( strCmd ){

	try {


		if ( strCmd.indexOf(this.operatorFunction) != -1 ){

			var arrCmdStr = strCmd.split( this.operatorFunction );
			var cmd = arrCmdStr [ 1 ];
			var param = arrCmdStr [ 0 ]

			var outObj = { cmd:cmd, param:param };

			console.log( 'outObj' , outObj );
			return outObj
		}

	}catch(err) {
	    console.log( 'JarvisFilter error splitCmdParamToString : ',  err.message );
	}
}

JarvisFilter.prototype.splitCmdParamToObj = function ( strCmd ){


	try {

		if ( strCmd.indexOf(this.operatorFunction) != -1 ){

			var arrCmdStr = strCmd.split( this.operatorFunction );

			var main = arrCmdStr[ 0 ];

			var arrFunctionAndParams =  arrCmdStr [ 1 ].split( this.operatorEqual );

			var cmd = arrFunctionAndParams[ 0 ];
			var param = arrFunctionAndParams[ 1 ];

			var outObj = { cmd:cmd, param:param, main:main };

			return outObj

		}else{
			return null;
		}

	}catch(err) {
	    console.log( 'JarvisFilter error splitCmdParamToObj : ',  err.message );
	}

}

JarvisFilter.prototype.filterObject = function ( filter ){

	try {

		var objCmdParam = this.splitCmdParamToObj( filter.cmd );

		if ( objCmdParam.cmd == 'merge' ){


			var out = [];
			var a = _.get( filter.data, objCmdParam.main.toString());
			var b = _.get( filter.data, objCmdParam.param.toString() );

			var b_json = '{"'+ objCmdParam.param.toString() +'":'+JSON.stringify(b)+'}';

			//return c
			for (var i = 0 ; i < a.length ; i ++ ){
				out.push( this.merge( a[ i ] , JSON.parse( b_json ) ) )
			}

			console.log( 'out', out );
			return out;
		}

	}catch(err) {
	    console.log( 'JarvisFilter error filterObject : ',  err.message );
	}
}

JarvisFilter.prototype.filterString = function ( filter ){

	try {

		var stringCmdParam = this.splitCmdParamToString( filter.cmd );

	

		if ( stringCmdParam.cmd == 'capitalize' ){

			var arrString = stringCmdParam.param.split( this.operatorMore );

			var str = _.get(filter.data,arrString[ 0 ].toString());
			var moreStr = arrString[ 1 ];

			var outString = str + moreStr;
			// return c
			return this.capitalize( outString );
		}

	}catch(err) {
	    console.log( 'JarvisFilter error filterString : ',  err.message );
	}
}

JarvisFilter.prototype.capitalize = function ( string ){
	
	var str = string.charAt(0).toUpperCase() + string.slice(1);
	return str
}

JarvisFilter.prototype.merge = function( a, b ) {

	try {

		var c = {};
	    for (var attrname in a) { c[attrname] = a[attrname]; }
	    for (var attrname in b) { c[attrname] = b[attrname]; }
	    return c;

	}catch(err) {
	    console.log( 'JarvisFilter error merge : ',  err.message );
	}
}

module.exports = JarvisFilter;