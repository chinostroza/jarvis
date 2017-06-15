var Project = require('../../lib/services/project')

var type = 'android-base';
var name = 'hola';
var path = '~/hola';

var mProject = new  Project( type, name , path);
mProject.run()