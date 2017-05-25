var JarvisFilter = function(){

}


JarvisFilter.prototype.capitalize = function (string){
	var str = string.charAt(0).toUpperCase() + string.slice(1);
	return str
}

JarvisFilter.prototype.run = function( cmd, str ){

	if (cmd == 'capitalize'){
		return this.capitalize( str )
	}else{
		console.log("filter not exits : ",cmd);
		return false;
	}
}

module.exports = JarvisFilter;