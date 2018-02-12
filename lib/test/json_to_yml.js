var ReadTemplate = require('../readTemplate');

function isInt(n){
    return Number(n) === n && n % 1 === 0;
}

function isFloat(n){
    return Number(n) === n && n % 1 !== 0;
}

var args = process.argv;



var pathTemplate = args[2];


mTemplate = new ReadTemplate();
var objectToTemplate = mTemplate.read(pathTemplate);

/*
properties:
  - name: userToken
    type: String
  - name: errors
    type: ArrayList<String>
  - name: success
    type: boolean
  - name: status
    type: String
  - name: firstName
    type: String
  - name: lastName
    type: String
  - name: userType
    type: String
*/
var out = "properties:\n";

for(var propertyName in objectToTemplate) {
   // propertyName is what you want
   // you can get the value like this: myObject[propertyName]
   out += "  - name: " + propertyName + "\n";

   if (typeof(objectToTemplate[propertyName]) == "object"){
   	out += "    type: " + propertyName.replace(/\b\w/g, function(l){ return l.toUpperCase() }) + "\n";
   }else if (typeof(objectToTemplate[propertyName]) == "number"){
   	if(isInt(objectToTemplate[propertyName])){
   		out += "    type: int"  + "\n";
   	}else{
   		out += "    type: float" +  "\n";
   	}	
   }else{
    out += "    type: " + typeof(objectToTemplate[propertyName]) + "\n";
   }
   
}
console.log(out);


