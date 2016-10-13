var SSH = require('simple-ssh');
var JarvisTemplates = require('jarvis.template/jarvis.template.js');

var JarvisServer = function(host,user,pass){
	this.host = host;
	this.user = user;
	this.pass = pass;
	this.ssh  = new SSH({
		host:host,
		user:user,
		pass:pass
	})
};

JarvisServer.prototype.addSite = function (name,port) {

	//generate a site file for nginx
	//must be add JarvisTemplate.findTemplate("nginx site file");
	var mJarvisTemplate = new JarvisTemplate();
	var mTemplate = mJarvisTemplate.findTemplate('nginx');
	var configSite = {
		"name":name,
		"port":port
	};

	mJarvisTemplate.
	var mJarvisCodeGeneration = new JarvisCodeGeneration(mTemplate,config);
	var file = mJarvisTemplate.generate();
	//Jarvis show a question for
	//new a validation variable

	this.ssh.exec('cat > /path/to/remote/file', {
   in: fs.readFileSync('/path/to/local/file')
	}).start();
	this.ssh.exec('echo "hello" | tee logfile.txt', {
    out: function(stdout) {
        console.log(stdout);
    }
	}).start();
};

module.exports = JarvisServer;
