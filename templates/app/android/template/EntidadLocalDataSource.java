

package com.inzpiral.drivin.app.model.source.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.inzpiral.drivin.app.model.{{ entidad | capitalize }};
import com.inzpiral.drivin.app.model.{{ entidad | capitalize }}sDataSource;
import com.inzpiral.drivin.app.model.source.local.{{ entidad | capitalize }}sPersistenceContract.{{ entidad | capitalize }}Entry;
import com.inzpiral.drivin.app.model.source.{{ entidad | capitalize }}sDataSource;

import java.util.ArrayList;
import java.util.List;

import static io.intercom.com.google.gson.internal.$Gson$Preconditions.checkNotNull;


/**
 * Concrete implementation of a data source as a db.
 */
public class {{ entidad | capitalize }}sLocalDataSource implements {{ entidad | capitalize }}sDataSource {

    private static {{ entidad | capitalize }}sLocalDataSource INSTANCE;

    private {{ entidad | capitalize }}sDbHelper mDbHelper;

    // Prevent direct instantiation.
    private {{ entidad | capitalize }}sLocalDataSource(@NonNull Context context) {
        checkNotNull(context);
        mDbHelper = new {{ entidad | capitalize }}sDbHelper(context);
    }

    public static {{ entidad | capitalize }}sLocalDataSource getInstance(@NonNull Context context) {
        if (INSTANCE == null) {
            INSTANCE = new TasksLocalDataSource(context);
        }
        return INSTANCE;
    }

    /**
     * Note: {@link LoadTasksCallback#onDataNotAvailable()} is fired if the database doesn't exist
     * or the table is empty.
     */
    @Override
    public void get{{ entidad | capitalize }}s(@NonNull Load{{ entidad | capitalize }}sCallback callback) {
        List<{{ entidad | capitalize }}> {{ entidad }}s = new ArrayList<{{ entidad | capitalize }}>();
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {
                {% for  campo in schema %}
                {{ entidad | capitalize }}Entry.COLUMN_NAME_{{ campo.name | upper }},
                {% endfor %}
        };

        Cursor c = db.query(
                {{ entidad }}Entry.TABLE_NAME, projection, null, null, null, null, null);

        if (c != null && c.getCount() > 0) {
            while (c.moveToNext()) {
                {% for  campo in schema %}
                {{ campo.type }} {{ campo.name }} = c.getString(c.getColumnIndexOrThrow({{ entidad|capitalize }}Entry.COLUMN_NAME_{{ campo.name|upper }}));
                {% endfor %}
                {{entidad|capitalize}} {{entidad}} = new {{entidad|capitalize}}(
                {% for  campo in schema %}
                {{ campo.name }},
                {% endfor %}
                 );
                {{entidad}}s.add({{entidad}});
            }
        }
        if (c != null) {
            c.close();
        }

        db.close();

        if ({{entidad}}s.isEmpty()) {
            // This will be called if the table is new or just empty.
            callback.onDataNotAvailable();
        } else {
            callback.on{{entidad|capitalize}}sLoaded({{entidad}}s);
        }

    }

    /**
     * Note: {@link GetTaskCallback#onDataNotAvailable()} is fired if the {@link Task} isn't
     * found.
     */
    @Override
    public void get{{entidad|capitalize}}(@NonNull String {{entidad}}Id, @NonNull GetTaskCallback callback) {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {
                {% for  campo in schema %}
                {{entidad|capitalize}}Entry.COLUMN_NAME_{{entidad|upper}},
                {% endfor %}
        };

        String selection = {{entidad|capitalize}}Entry.COLUMN_NAME_ENTRY_ID + " LIKE ?";
        String[] selectionArgs = { {{ entidad }}Id };

        Cursor c = db.query(
                {{entidad|capitalize}}Entry.TABLE_NAME, projection, selection, selectionArgs, null, null, null);

        {{entidad|capitalize}} {{entidad}} = null;

        if (c != null && c.getCount() > 0) {
            c.moveToFirst();
            {% for  campo in schema %}
            String itemId = c.getString(c.getColumnIndexOrThrow(TaskEntry.COLUMN_NAME_ENTRY_ID));
            {{ campo.type }} {{ campo.name }} = c.getString(c.getColumnIndexOrThrow({{entidad|capitalize}}Entry.COLUMN_NAME_{{campo.name|upper}}));
            {% endfor %}
            task = new Task(title, description, itemId, completed);
            {{entidad }} = new {{entidad|capitalize}}(
            {% for  campo in schema %}{{ campo.name }}{% endfor %},
            );
        }
        if (c != null) {
            c.close();
        }

        db.close();

        if ({{entidad}} != null) {
            callback.on{{entidad|capitalize}}Loaded({{entidad}});
        } else {
            callback.onDataNotAvailable();
        }
    }
}
