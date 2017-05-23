//File: controllers/{{ entidad }}s.js
var mongoose = require('mongoose');
var {{ entidad|capitalize }}  = mongoose.model('{{ entidad|capitalize }}');

//GET - Return all {{ entidad }}s in the DB
exports.findAll{{ entidad|capitalize }}s = function(req, res) {
	{{ entidad|capitalize }}.find(function(err, {{ entidad }}s) {
    if(err) res.send(500, err.message);

    console.log('GET /{{ entidad }}s')
		res.status(200).jsonp({{ entidad }}s);
	});
};

//GET - Return a {{ entidad|capitalize }} with specified ID
exports.findById = function(req, res) {
	{{ entidad|capitalize }}.findById(req.params.id, function(err, {{ entidad }}) {
    if(err) return res.send(500, err.message);

    console.log('GET /{{ entidad }}/' + req.params.id);
		res.status(200).jsonp({{ entidad }});
	});
};

//POST - Insert a new {{ entidad }} in the DB
exports.add{{ entidad|capitalize }} = function(req, res) {
	console.log('POST');
	console.log(req.body);

	var {{ entidad }} = new {{ entidad|capitalize }} ({
		{% spaceless %}
		{% for  campo in schema %}
			{% if loop.last %}
				{{ campo.name }} : req.body.{{ campo.name }}
			{% else %}
				{{ campo.name }} : req.body.{{ campo.name }},
			{% endif %}
		{% endfor %}
		{% endspaceless %}
	});

	{{ entidad }}.save(function(err, {{ entidad }}) {
		if(err) return res.send(500, err.message);
    res.status(200).jsonp({{ entidad }});
	});
};

//PUT - Update a register already exists
exports.update{{ entidad|capitalize }} = function(req, res) {
	{{ entidad|capitalize }}.findById(req.params.id, function(err, {{ entidad }}) {
		{% spaceless %}
		{% for  campo in schema %}
			{{ entidad }}.{{ campo.name }} = req.body.{{ campo.name }};
		{% endfor %}
		{% endspaceless %}

		{{ entidad }}.save(function(err) {
			if(err) return res.send(500, err.message);
      res.status(200).jsonp({{ entidad }});
		});
	});
};

//DELETE - Delete a {{ entidad|capitalize }} with specified ID
exports.delete{{ entidad|capitalize }} = function(req, res) {
	{{ entidad|capitalize }}.findById(req.params.id, function(err, {{ entidad }}) {
		{{ entidad }}.remove(function(err) {
			if(err) return res.send(500, err.message);
      res.status(200);
		})
	});
};