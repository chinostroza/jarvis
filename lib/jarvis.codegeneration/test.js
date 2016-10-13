var JarvisCodeGeneration = require("./jarvis.codegeneration.js");
const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
  prompt: 'JARVIS> '
});

rl.prompt('JARVIS> ');

var state = null;

rl.on('line', (line) => {

  switch(line.trim()) {
    case 'generate a site':
      console.log('What is the name of the template!');
      state = "LISTENNAMETEMPLATE";
      break;
    case 'state':
      console.log(' State of Jarvis > ' + state);
      break;
    default:
      if (state == "LISTENNAMETEMPLATE"){
        console.log(` find template : '${line.trim()}'`);
        mJarvisCodeGeneration = new JarvisCodeGeneration();
        console.log("Result:")
        console.log(mJarvisCodeGeneration.findTemplateByName(line.trim()));
        console.log(mJarvisCodeGeneration.getInTemplate());
        state = null;
      }else{
        console.log(`Say what? I might have heard? '${line.trim()}'`);
      };
      break;
  }
  rl.prompt('JARVIS> ');
}).on('close', () => {
  console.log('Have a great day!');
  process.exit(0);
});

/*



console.log(mJarvisCodeGeneration.findTemplateByName("nginx site"));

*/
