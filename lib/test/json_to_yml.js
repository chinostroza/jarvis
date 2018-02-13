
const path = require('path');
const fs = require('fs');

const ReadTemplate = require('../readTemplate');
const objToConfig = require('../objToConfig');
const Render = require('../Render');


var args = process.argv;
var json = args[2];
var template = args[3];

var nameClass = path.basename( args[2] );

mTemplate = new ReadTemplate();

mObjToConfig = new objToConfig( mTemplate.read( json ) );

mObjToConfig.setNameClass(nameClass.replace(".json",""))

var obj = mTemplate.getObjFromYmlString( mObjToConfig.getConfigYml()  );


mRender = new Render(template,obj);
var outString = mRender.createScripts();


//write scripts file
fs.writeFile(nameClass.replace(".json",".java"), outString, function(err) {
  if(err) {
    return console.log(err);
  }
});
