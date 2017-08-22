var fs = require('fs');
var RunCommand = require('../runCommand');
var path = require('path');
var shell = require('shelljs');


var RunTasks = function(args){
  this.args = args;
}

RunTasks.prototype.readTask = function(){

  if ( this.args.length == 4){

      var arr_file_path = path.join(__dirname).split(path.sep);
      var JARVIS_PATH = '';
      for (var i = 0 ; i< arr_file_path.length - 2 ; i++){
        JARVIS_PATH += arr_file_path[i]+'/';
      }

      JARVIS_PATH += path.join('bin','jarvis');

      var TASKS_PATH = this.args[3];

      if (fs.existsSync(TASKS_PATH)){
        console.log( 'Jarvis > tasks file path, ',TASKS_PATH );
        if(fs.existsSync(JARVIS_PATH)){
          console.log( 'Jarvis > jarvis command path, ',JARVIS_PATH );
          if(fs.existsSync(TASKS_PATH)) {
            fs.readFile(TASKS_PATH, 'utf8', function (err,data) {
              if (err) {
                return console.log(err);
              }
              var obj_data = JSON.parse(data);
              mRunCommand = new RunCommand();
              for(var i=0; i < obj_data.length; i++ ){
                console.log("Jarvis > Task name: ",obj_data[i].name_task);

                var validTask = function(task){

                    if (task.command != 'generator'){
                      console.log('Jarvis > command not found , ',task.template_path);
                      return false;
                    }else if (!fs.existsSync(task.template_path)){
                      console.log('Jarvis > template not exists , ',task.template_path);
                      return false;
                    }else if(!fs.existsSync(task.config_file)){
                      console.log('Jarvis > config file not exists , ',task.config_file);
                      return false;
                    }else{
                      return true;
                    }
                }
                var arr_out_path = path.join(obj_data[i].out_file_path).split(path.sep);
                var OUT_PATH = ''
                for (var j = 0 ; j < arr_out_path.length -1 ; j++ ){
                  OUT_PATH += arr_out_path[j] + path.sep
                }
                if (!fs.existsSync(OUT_PATH)){
                  shell.mkdir('-p', OUT_PATH);
                }else{
                  console.log('Jarvis > out path exists , ',OUT_PATH);
                }

                if (validTask(obj_data[i])){
                  mRunCommand.run(JARVIS_PATH,[
                    obj_data[i].command,
                    obj_data[i].template_path,
                    obj_data[i].config_file,
                    obj_data[i].out_file_path
                  ]);
                }else{
                  console.log("Jarvis > Validate Task Error");
                }
              }
            });
          }else{
            console.log('Jarvis > file tasks not exists');
          }
        }else{
          console.log('Jarvis > jarvis command not found');
        }
      }else{
        console.log("Jarvis > Tasks file not exists");
      }
  }else{
    console.log('Jarvis > Error in numbers of arguments');
    console.log('Jarvis > Example: jarvis runtasks tasks.json');
  }
}
module.exports = RunTasks;
