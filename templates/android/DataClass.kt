package cl.watched.movies.data.remote.model;

import com.google.gson.annotations.SerializedName

data class {{ entity.name_class }} (

    {% for property in properties %}
    @SerializedName("{{ property.name }}")
    val {{ property.name }} : {{ property.type|capitalize }},
    {% endfor %}
)