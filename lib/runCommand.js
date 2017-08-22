var spawn = require('child_process').spawn;

var RunCommand = function(){}

RunCommand.prototype.run = function(pathScript,param){

  const command = spawn(pathScript,param);

  command.stdout.on('data', (data) => {

    console.log(`${data}`);
  });

  command.stderr.on('data', (data) => {
    console.log(`${data}`);
  });

  command.on('close', (code) => {
    if (parseInt(code) == 0){
      console.log('server.runCommand > fin code ->',parseInt(code));
    }else{
      console.log('server.runCommand > error code ->',parseInt(code));
    }

  });

}

module.exports = RunCommand;
