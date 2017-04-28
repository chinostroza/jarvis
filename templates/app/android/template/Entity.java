package com.inzpiral.drivin.app.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.VisibleForTesting;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Carlos 2016
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class {{ entidad | capitalize }} implements Parcelable, Serializable {
	{% spaceless %}
	{% for  campo in schema %}
	{% if campo.type == 'ArrayList' %}
		private {{ campo.type }}<{{ campo.childname| capitalize }}> m{{ campo.name| capitalize }};
	{% else %}
	{% if campo.type == 'Object' %}
		private {{ campo.childname|capitalize }} m{{ campo.name| capitalize }};
	{% else %}
		private {{ campo.type }} m{{ campo.name| capitalize }};
	{% endif %}

	{% endif %}
	{% endfor %}
	{% endspaceless %}
	// Default constructor required for Jackson compatibility
	public {{ entidad|capitalize }}(
	{% spaceless %}
	{% for  campo in schema %}
	{% if campo.type == 'ArrayList' %}
	{{ campo.type }}<{{ campo.childname| capitalize }}> {{ campo.name }}
	{% else %}
	{% if campo.type == 'Object' %}
	{{ campo.childname|capitalize }} {{ campo.name }}
	{% else %}
	{{ campo.type }} {{ campo.name }},
	{% endif %}
	{% endif %}
	{% endfor %}){
	{% endspaceless %}
	}

	public {{ entidad|capitalize }}(Parcel in){
		{% spaceless %}
		{% for  campo in schema %}
		{% if campo.type == 'ArrayList' %}
		m{{ campo.name| capitalize }} = in.readArrayList(null);
		{% else %}
		{% if campo.type == 'Object' %}
		m{{ campo.childname| capitalize }} = ({{ campo.childname| capitalize }}) in.readParcelable({{ campo.childname| capitalize }}.class.getClassLoader());
		{% else %}
		m{{ campo.name| capitalize }} = in.read{{ campo.type|capitalize }}();
		{% endif %}
		{% endif %}
		{% endfor %}
		{% endspaceless %}
	}
	{% spaceless %}
	{% for  campo in schema %}
	 @JsonProperty("{{ campo.name }}")
	 {% if campo.type == 'Object' %}
	 public {{ campo.childname|capitalize }} get{{ campo.name|capitalize }}() {
	 {% else %}
	 {% if campo.type == 'ArrayList' %}
	 public {{ campo.type }}<{{ campo.childname|capitalize }}> get{{ campo.name|capitalize }}() {
	 {% else %}
	 public {{ campo.type }} get{{ campo.name|capitalize }}() {
	 {% endif %}
	 {% endif %}
        return m{{ campo.name|capitalize }};
    }

    @JsonProperty("{{ campo.name }}")
		{% if campo.type == 'Object' %}
  	public void set{{ campo.name|capitalize }}({{ campo.childname|capitalize }} {{ campo.name }}) {
		{% else %}
		{% if campo.type == 'ArrayList' %}
		public void set{{ campo.name|capitalize }}(ArrayList<{{ campo.childname|capitalize }}> {{ campo.name }}) {
		{% else %}
		public void set{{ campo.name|capitalize }}({{ campo.type }} {{ campo.name }}) {
		{% endif %}
		{% endif %}
        m{{ campo.name|capitalize }} = {{ campo.name }};
    }
    {% endfor %}
		{% endspaceless %}

	public static final Parcelable.Creator<{{ entidad|capitalize }}> CREATOR
            = new Parcelable.Creator<{{ entidad|capitalize }}>() {
        public {{ entidad|capitalize }} createFromParcel(Parcel in) {
            return new {{ entidad|capitalize }}(in);
        }

        public {{ entidad|capitalize }}[] newArray(int size) {
            return new {{ entidad|capitalize }}[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
		{% spaceless %}
    {% for  campo in schema %}
    {% if campo.type == 'ArrayList' %}
		dest.writeList(m{{ campo.name|capitalize }});
		{% else %}
		{% if campo.type == 'Object' %}
		dest.writeParcelable(m{{ campo.childname|capitalize }}, flags);
		{% else %}
		dest.write{{ campo.type|capitalize }}(m{{ campo.name|capitalize }});
		{% endif %}
		{% endif %}
		{% endfor %}
		{% endspaceless %}
    }
}
