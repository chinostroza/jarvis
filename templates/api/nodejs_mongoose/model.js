exports = module.exports = function(app, mongoose) {

	var {{ name }}Schema = new mongoose.Schema({
		{% for  property in properties %}
			{% if loop.last %}
				{{ property.name }} : { type:{{ property.type }}}
			{% else %}
				{{ property.name }} : { type:{{ property.type }}},
			{% endif %}
		{% endfor %}
	});

	mongoose.model('{{ name|capitalize}}', {{ name }}Schema);

};