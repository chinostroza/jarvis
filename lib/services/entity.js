
const path = require('path');
const fs = require('fs');

const ReadTemplate = require('../readTemplate');
const objToConfig = require('../objToConfig');
const Render = require('../Render');

var Entity = function(json,template,ext){
	this.json = json;
	this.template = template;
	this.ext = ext;
}

Entity.prototype.run = function(){

	var json = this.json;
	var template = this.template;

	var nameClass = path.basename( this.json );

	mTemplate = new ReadTemplate();

	mObjToConfig = new objToConfig( mTemplate.read( json ) );

	mObjToConfig.setNameClass(nameClass.replace(".json",""))

	var obj = mTemplate.getObjFromYmlString( mObjToConfig.getConfigYml()  );


	mRender = new Render(template,obj);
	var outString = mRender.createScripts();


	var outFile = nameClass.replace(".json",this.ext)
	//write scripts file
	fs.writeFile(outFile, outString, function(err) {
	  if(err) {
	    return console.log(err);
	  }
	});
	
	console.log(" file generate :" + outFile);

}

module.exports = Entity;