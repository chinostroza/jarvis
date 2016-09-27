/* Create table */

/*create table mysql*/

CREATE TABLE {{ name }}
(
	{% spaceless %}
		{% for  campo in schema %}
			{% if loop.last %}
				{{ campo.name }} {{ campo.type }}
			{% else %}
				{{ campo.name }} {{ campo.type }},
			{% endif %}
		{% endfor %}
		{% endspaceless %}
);