package com.inzpiral.drivin.app.model.source.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class {{ entidad|capitalize }}sDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "{{ entidad|capitalize }}s.db";

    private static final String TEXT_TYPE = " TEXT";

    private static final String BOOLEAN_TYPE = " INTEGER";

    private static final String INTEGER_TYPE = " INTEGER";

    private static final String COMMA_SEP = ",";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + {{ entidad|capitalize }}sPersistenceContract.{{ entidad|capitalize }}Entry.TABLE_NAME + " (" +
                    {% spaceless %}
                    {% for  campo in schema %}
                    {% if loop.first %}
                      {{ entidad|capitalize }}sPersistenceContract.{{ entidad|capitalize }}Entry._ID + TEXT_TYPE + " PRIMARY KEY," +
                    {% else %}
                    {% if campo.type=="int"%}
                    {{ entidad|capitalize }}sPersistenceContract.{{ entidad|capitalize }}Entry.COLUMN_NAME_{{campo.name|upper}} + INTEGER_TYPE + COMMA_SEP +
                    {% else %}
                    {{ entidad|capitalize }}sPersistenceContract.{{ entidad|capitalize }}Entry.COLUMN_NAME_{{campo.name|upper}} + TEXT_TYPE + COMMA_SEP +
                    {% endif %}
                    {% endif %}
                    {% endfor %}
                    {% endspaceless %}
                    " )";

    public {{ entidad|capitalize }}sDbHelper(Context context){ super(context, DATABASE_NAME, null, DATABASE_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase db) { db.execSQL(SQL_CREATE_ENTRIES); }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Not required
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Not required
    }
}
