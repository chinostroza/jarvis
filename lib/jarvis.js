/*

JARVIS BOOT

*/

var swig			= require( 'swig' );
var fs				= require( 'fs' );
var Generator 		= require( './services/generator' );
var Runner    		= require( './services/runner' );
var Project    		= require( './services/project' );
var JarvisTemplate 	= require( './jarvisTemplate' );

var args = process.argv

var command = "";

try {

	//jarvis new project android
    
	if ( args.length == 2 ){

		command = "help";

	}else if ( args.length > 2 ){

		command = args[2];

	}

	if ( command == 'generator' ){

		if ( args.length == 6 ){

			var templatePath = args[ 3 ];
			var jsonPathToTemplate = args[ 4 ];
			var scriptOutPath = args[ 5 ];

			mGenerator = new Generator( templatePath, jsonPathToTemplate, scriptOutPath );
			mGenerator.createScripts();

		}else{

			console.log( "Wrong number of arguments" );

		}

	}else if ( command == 'readtemplate' ){

		var templatePath = args[ 3 ];
		mTemplate = new JarvisTemplate();
		obj = mTemplate.read( templatePath );
		console.log( obj );

	}else if ( command == 'runner' ){
		
		if ( args.length > 7 ){

			var templatePath 			= args[ 3 ];
			var configPath	 			= args[ 4 ];
			var filterObject 			= args[ 5 ];
			var objectKeyFileNameOut 	= args[ 6 ];
			var extFiles 				= args[ 7 ];
			var destination 			= '';

			if ( args.length == 9 ){
				var destination = args[ 8 ];
			}

			var params = {

				template 	: templatePath,
				config 		: configPath,
				filter 		: filterObject,
				key 		: objectKeyFileNameOut,
				ext 		: extFiles,
				destination : destination
			}
			
			mRunner = new Runner( params );
			mRunner.createScripts();
			
		}else{

			console.log( "Wrong number of arguments" );
			console.log("");
			console.log( "jarvis runner template_path config_file iterable_object object_key_file_out" );

		}
	}else if (command == 'help'){

		console.log( "" );
		console.log( "Commands : " );
		console.log( "" );
		console.log( "jarvis generator template_path config_file|json|yml out_path_file" );
		console.log( "jarvis create project type name path" );
		console.log( "jarvis readtemplate template_path" );
		console.log( "jarvis runner template_path config_file|json|yml iterable_object_key key_object_filename ext_files directory_output_files" );

	}else if ( command == 'create'){


		//project
		var newType = args[ 3 ];
		if ( newType == "project" ) {

			var typeProject = args[ 4 ];
			var nameProject = args[ 5 ];
			var pathProject = args[ 6 ];

			if ( args.length == 7 ){
				mProject = new Project( typeProject, nameProject, pathProject )
				mProject.run()
			}else{
				throw "Number arguments error !!!"
			}

		}

	}else{

		console.log( 'command not exists' );

	}
} catch(err) {
    console.log( 'jarvis > Error in jarvis boot : ',  err);
}