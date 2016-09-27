exports.getColsString = function (objectData){

	var colsString = objectData["data"].map(function(elem) {
  		return elem.colName;
	}).join(",");
	
	return colsString;
};

exports.getValuesString = function (objectData){

	var valuesString = objectData["data"].map(function(elem) {
  		return "+data["+elem.colName+"]+";
	}).join(",");

	return valuesString;
}