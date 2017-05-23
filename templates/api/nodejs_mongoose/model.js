exports = module.exports = function(app, mongoose) {

	var {{ entidad }}Schema = new mongoose.Schema({
		{% spaceless %}
		{% for  campo in schema %}
			{% if loop.last %}
				{{ campo.name }} : { type:{{ campo.type }}}
			{% else %}
				{{ campo.name }} : { type:{{ campo.type }}},
			{% endif %}
		{% endfor %}
		{% endspaceless %}
	});

	mongoose.model('{{ entidad|capitalize}}', {{ entidad }}Schema);

};