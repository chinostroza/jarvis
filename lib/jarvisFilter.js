const _ 	= require('lodash');

var JarvisFilter = function( filter ){

	try {

		this.operatorFunction = '?';
		this.operatorEqual = '=';

		if ( filter.type == 'object' ){

			return this.filterObject( filter );

		} else if ( filter.type == 'string' ){

			return this.filterString( filter );
		}

	}catch(err) {
	    console.log( 'JarvisFilter error constructor ; ',  err.message );
	    return null;
	}
}

JarvisFilter.prototype.splitCmdParamToString = function ( strCmd ){

	if ( strCmd.indexOf(this.operatorFunction) != -1 ){

		var arrCmdStr = strCmd.split( this.operatorFunction );
		var cmd = arrCmdStr [ 1 ];
		var param = arrCmdStr [ 0 ]

		var outObj = { cmd:cmd, param:param };
		return outObj
	}
}

JarvisFilter.prototype.splitCmdParamToObj = function ( strCmd ){


	try {

		if ( strCmd.indexOf(this.operatorFunction) != -1 ){

			var arrCmdStr = strCmd.split( this.operatorFunction );

			var arrFunctionAndParams =  arrCmdStr [ 1 ].split( this.operatorEqual );

			var cmd = arrFunctionAndParams[ 0 ];
			var param = arrFunctionAndParams[ 0 ];

			var outObj = {cmd:cmd,param:param};

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

			var a = filter.data;
			var b = _get( filter.data, objCmdParam.param.toString() );
			//return c
			return this.merge( a , b );
		}

	}catch(err) {
	    console.log( 'JarvisFilter error filterObject : ',  err.message );
	}
}

JarvisFilter.prototype.filterString = function ( filter ){

	var stringCmdParam = this.splitCmdParamToString( filter.cmd );

	if ( stringCmdParam.cmd == 'capitalize' ){

		var arrString = stringCmdParam.param.split( this.operatorMore );

		var str = arrString[ 0 ];
		var moreStr = arrString[ 1 ];

		var outString = str + moreStr;

		// return c
		return this.capitalize( outString );
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