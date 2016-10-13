package com.inzpiral.drivin.app.model.source.local;

import android.provider.BaseColumns;

/**
 * The contract used for the db to save the {{ entidad }}s locally.
 */
public final class {{ entidad|capitalize}}sPersistenceContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private {{ entidad|capitalize}}sPersistenceContract() {}

    /* Inner class that defines the table contents */
    public static abstract class {{ entidad|capitalize}}Entry implements BaseColumns {
        public static final String TABLE_NAME = "{{ entidad }}";
        {% spaceless %}
	      {% for  campo in schema %}
        public static final String COLUMN_NAME_{{ campo.name | upper }} = "{{ campo.name }}";
        {% endfor %}
    }
}
