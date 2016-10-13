'use strict';
var JarvisServer = require("./jarvis.server.js");

var mJarvisServer = new JarvisServer('{{domain}}','{{username}}','{{password}}');
mJarvisServer.addSite();
