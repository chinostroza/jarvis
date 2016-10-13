<?php

class {{ entidad|capitalize }} {
{% for  campo in schema %}
	private ${{ campo.name }};			
{% endfor %}

{% for  campo in schema %}
	public function set{{ campo.name|capitalize  }}(${{ campo.name }}){
		$this->{{ campo.name }} = ${{ campo.name }};
	}

	public function get{{ campo.name|capitalize }}(){
		return $this->{{ campo.name }};
	}			
{% endfor %}
}