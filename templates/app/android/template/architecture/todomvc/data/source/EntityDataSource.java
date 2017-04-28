package com.inzpiral.drivin.app.model.source;

import android.support.annotation.NonNull;

import com.inzpiral.drivin.app.model.{{ entidad|capitalize }};

import java.util.List;

public interface {{ entidad|capitalize }}sDataSource {

    interface Load{{ entidad|capitalize }}sCallback {

        void on{{ entidad|capitalize }}sLoaded(List<{{ entidad|capitalize }}> {{ entidad }}s);

        void onDataNotAvailable();
    }

    interface Get{{ entidad|capitalize }}Callback{{ entidad|capitalize }}Callback {

        void on{{ entidad|capitalize }}Loaded({{ entidad|capitalize }} {{ entidad }});

        void onDataNotAvailable();
    }

    void get{{ entidad|capitalize }}s(@NonNull LoadTasksCallback callback);

    void get{{ entidad|capitalize }}(@NonNull String taskId, @NonNull GetTaskCallback callback);

    void refresh{{ entidad|capitalize }}s();
}
