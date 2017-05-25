//File: controllers/{{ name }}s.js
var mongoose = require('mongoose');
var {{ name|capitalize }}  = mongoose.model('{{ name|capitalize }}');

//GET - Return all {{ name }}s in the DB
exports.findAll{{ name|capitalize }}s = function(req, res) {
	{{ name|capitalize }}.find(function(err, {{ name }}s) {
    if(err) res.send(500, err.message);

    console.log('GET /{{ name }}s')
		res.status(200).jsonp({{ name }}s);
	});
};

//GET - Return a {{ name|capitalize }} with specified ID
exports.findById = function(req, res) {
	{{ name|capitalize }}.findById(req.params.id, function(err, {{ name }}) {
    if(err) return res.send(500, err.message);

    console.log('GET /{{ name }}/' + req.params.id);
		res.status(200).jsonp({{ name }});
	});
};

//POST - Insert a new {{ name }} in the DB
exports.add{{ name|capitalize }} = function(req, res) {
	console.log('POST');
	console.log(req.body);

	var {{ name }} = new {{ name|capitalize }} ({

		{% for  property in properties %}
			{% if loop.last %}
				{{ property.name }} : req.body.{{ property.name }}
			{% else %}
				{{ property.name }} : req.body.{{ property.name }},
			{% endif %}
		{% endfor %}

	});

	{{ name }}.save(function(err, {{ name }}) {
		if(err) return res.send(500, err.message);
    res.status(200).jsonp({{ name }});
	});
};

//PUT - Update a register already exists
exports.update{{ name|capitalize }} = function(req, res) {
	{{ name|capitalize }}.findById(req.params.id, function(err, {{ name }}) {

		{% for  property in properties %}
			{{ name }}.{{ property.name }} = req.body.{{ property.name }};
		{% endfor %}


		{{ name }}.save(function(err) {
			if(err) return res.send(500, err.message);
      res.status(200).jsonp({{ name }});
		});
	});
};

//DELETE - Delete a {{ name|capitalize }} with specified ID
exports.delete{{ name|capitalize }} = function(req, res) {
	{{ name|capitalize }}.findById(req.params.id, function(err, {{ name }}) {
		{{ name }}.remove(function(err) {
			if(err) return res.send(500, err.message);
      res.status(200);
		})
	});
};