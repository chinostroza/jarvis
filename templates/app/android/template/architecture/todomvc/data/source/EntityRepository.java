package com.inzpiral.drivin.app.model.source.local;

import static com.google.common.base.Preconditions.checkNotNull;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.android.architecture.blueprints.todoapp.data.Task;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Concrete implementation to load tasks from the data sources into a cache.
 * <p>
 * For simplicity, this implements a dumb synchronisation between locally persisted data and data
 * obtained from the server, by using the remote data source only if the local database doesn't
 * exist or is empty.
 */
public class {{ entidad|capitalize }}sRepository implements {{ entidad|capitalize }}sDataSource {

    private static {{ entidad|capitalize }}sRepository INSTANCE = null;

    private final {{ entidad|capitalize }}sDataSource m{{ entidad|capitalize }}sRemoteDataSource;

    private final {{ entidad|capitalize }}sDataSource m{{ entidad|capitalize }}sLocalDataSource;

    /**
     * This variable has package local visibility so it can be accessed from tests.
     */
    Map<String, {{ entidad|capitalize }}> mCached{{ entidad|capitalize }}s;

    /**
     * Marks the cache as invalid, to force an update the next time data is requested. This variable
     * has package local visibility so it can be accessed from tests.
     */
    boolean mCacheIsDirty = false;

    // Prevent direct instantiation.
    private {{ entidad|capitalize }}sRepository(@NonNull {{ entidad|capitalize }}sDataSource {{ entidad }}sRemoteDataSource,
                            @NonNull {{ entidad|capitalize }}sDataSource {{ entidad }}sLocalDataSource) {
        m{{ entidad|capitalize }}sRemoteDataSource = checkNotNull({{ entidad|capitalize }}RemoteDataSource);
        m{{ entidad|capitalize }}sLocalDataSource = checkNotNull({{ entidad }}sLocalDataSource);
    }

    /**
     * Returns the single instance of this class, creating it if necessary.
     *
     * @param tasksRemoteDataSource the backend data source
     * @param tasksLocalDataSource  the device storage data source
     * @return the {@link TasksRepository} instance
     */
    public static {{ entidad|capitalize }}sRepository getInstance({{ entidad|capitalize }}sDataSource tasksRemoteDataSource,
                                              {{ entidad|capitalize }}sDataSource {{ entidad }}sLocalDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new {{ entidad|capitalize }}sRepository({{ entidad }}sRemoteDataSource, {{ entidad }}sLocalDataSource);
        }
        return INSTANCE;
    }

    /**
     * Used to force {@link #getInstance(TasksDataSource, TasksDataSource)} to create a new instance
     * next time it's called.
     */
    public static void destroyInstance() {
        INSTANCE = null;
    }

    /**
     * Gets {{ entidad }}s from cache, local data source (SQLite) or remote data source, whichever is
     * available first.
     * <p>
     * Note: {@link Load{{ entidad|capitalize }}sCallBack#onDataNotAvailable()} is fired if all data sources fail to
     * get the data.
     */
    @Override
    public void get{{ entidad|capitalize }}s(@NonNull final Load{{ entidad|capitalize }}sCallBack callback) {
        checkNotNull(callback);

        // Respond immediately with cache if available and not dirty
        if (mCached{{ entidad|capitalize }}s != null && !mCacheIsDirty) {
            callback.on{{ entidad|capitalize }}sLoaded(new ArrayList<>(mCached{{ entidad|capitalize }}s.values()));
            return;
        }

        if (mCacheIsDirty) {
            // If the cache is dirty we need to fetch new data from the network.
            get{{ entidad|capitalize }}sFromRemoteDataSource(callback);
        } else {
            // Query the local storage if available. If not, query the network.
            m{{ entidad|capitalize }}sLocalDataSource.get{{ entidad|capitalize }}s(new Load{{ entidad|capitalize }}sCallback() {
                @Override
                public void on{{ entidad|capitalize }}sLoaded(List<{{ entidad|capitalize }}> {{ entidad }}s) {
                    refreshCache({{ entidad}}s);
                    callback.on{{ entidad|capitalize }}sLoaded(new ArrayList<>(mCached{{ entidad|capitalize }}s.values()));
                }

                @Override
                public void onDataNotAvailable() {
                    get{{ entidad|capitalize }}sFromRemoteDataSource(callback);
                }
            });
        }
    }

    @Override
    public void save{{ entidad|capitalize }}(@NonNull {{ entidad|capitalize }} {{ entidad }}) {
        checkNotNull(task);
        m{{ entidad|capitalize }}sRemoteDataSource.save{{ entidad|capitalize }}({{ entidad }});
        m{{ entidad|capitalize }}sLocalDataSource.save{{ entidad|capitalize }}({{ entidad }});

        // Do in memory cache update to keep the app UI up to date
        if (mCached{{ entidad|capitalize }}s == null) {
            mCached{{ entidad|capitalize }}s = new LinkedHashMap<>();
        }
        mCached{{ entidad|capitalize }}s.put({{ entidad }}.getId(), {{ entidad }});
    }

    @Override
    public void complete{{ entidad|capitalize }}(@NonNull {{ entidad|capitalize }} {{ entidad }}) {
        checkNotNull(task);
        m{{ entidad|capitalize }}sRemoteDataSource.complete{{ entidad|capitalize }}({{ entidad }});
        m{{ entidad|capitalize }}sLocalDataSource.complete{{ entidad|capitalize }}({{ entidad }});

        {{ entidad|capitalize }} completed{{ entidad|capitalize }} = new {{ entidad|capitalize }}({{ entidad }}.getTitle(), {{ entidad }}.getDescription(), {{ entidad}}.getId(), true);

        // Do in memory cache update to keep the app UI up to date
        if (mCached{{ entidad|capitalize }}s == null) {
            mCached{{ entidad|capitalize }}s = new LinkedHashMap<>();
        }
        mCached{{ entidad|capitalize }}s.put({{ entidad|capitalize }}.getId(), completed{{ entidad|capitalize }});
    }

    @Override
    public void complete{{ entidad|capitalize }}(@NonNull String {{ entidad}}Id) {
        checkNotNull(taskId);
        completeTask(getTaskWithId(taskId));
    }

    @Override
    public void activateTask(@NonNull Task task) {
        checkNotNull(task);
        mTasksRemoteDataSource.activateTask(task);
        mTasksLocalDataSource.activateTask(task);

        Task activeTask = new Task(task.getTitle(), task.getDescription(), task.getId());

        // Do in memory cache update to keep the app UI up to date
        if (mCachedTasks == null) {
            mCachedTasks = new LinkedHashMap<>();
        }
        mCachedTasks.put(task.getId(), activeTask);
    }

    @Override
    public void activateTask(@NonNull String taskId) {
        checkNotNull(taskId);
        activateTask(getTaskWithId(taskId));
    }

    @Override
    public void clearCompletedTasks() {
        mTasksRemoteDataSource.clearCompletedTasks();
        mTasksLocalDataSource.clearCompletedTasks();

        // Do in memory cache update to keep the app UI up to date
        if (mCachedTasks == null) {
            mCachedTasks = new LinkedHashMap<>();
        }
        Iterator<Map.Entry<String, Task>> it = mCachedTasks.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Task> entry = it.next();
            if (entry.getValue().isCompleted()) {
                it.remove();
            }
        }
    }

    /**
     * Gets tasks from local data source (sqlite) unless the table is new or empty. In that case it
     * uses the network data source. This is done to simplify the sample.
     * <p>
     * Note: {@link LoadTasksCallback#onDataNotAvailable()} is fired if both data sources fail to
     * get the data.
     */
    @Override
    public void getTask(@NonNull final String taskId, @NonNull final GetTaskCallback callback) {
        checkNotNull(taskId);
        checkNotNull(callback);

        Task cachedTask = getTaskWithId(taskId);

        // Respond immediately with cache if available
        if (cachedTask != null) {
            callback.onTaskLoaded(cachedTask);
            return;
        }

        // Load from server/persisted if needed.

        // Is the task in the local data source? If not, query the network.
        mTasksLocalDataSource.getTask(taskId, new GetTaskCallback() {
            @Override
            public void onTaskLoaded(Task task) {
                callback.onTaskLoaded(task);
            }

            @Override
            public void onDataNotAvailable() {
                mTasksRemoteDataSource.getTask(taskId, new GetTaskCallback() {
                    @Override
                    public void onTaskLoaded(Task task) {
                        callback.onTaskLoaded(task);
                    }

                    @Override
                    public void onDataNotAvailable() {
                        callback.onDataNotAvailable();
                    }
                });
            }
        });
    }

    @Override
    public void refreshTasks() {
        mCacheIsDirty = true;
    }

    @Override
    public void deleteAllTasks() {
        mTasksRemoteDataSource.deleteAllTasks();
        mTasksLocalDataSource.deleteAllTasks();

        if (mCachedTasks == null) {
            mCachedTasks = new LinkedHashMap<>();
        }
        mCachedTasks.clear();
    }

    @Override
    public void deleteTask(@NonNull String taskId) {
        mTasksRemoteDataSource.deleteTask(checkNotNull(taskId));
        mTasksLocalDataSource.deleteTask(checkNotNull(taskId));

        mCachedTasks.remove(taskId);
    }

    private void getTasksFromRemoteDataSource(@NonNull final LoadTasksCallback callback) {
        mTasksRemoteDataSource.getTasks(new LoadTasksCallback() {
            @Override
            public void onTasksLoaded(List<Task> tasks) {
                refreshCache(tasks);
                refreshLocalDataSource(tasks);
                callback.onTasksLoaded(new ArrayList<>(mCachedTasks.values()));
            }

            @Override
            public void onDataNotAvailable() {
                callback.onDataNotAvailable();
            }
        });
    }

    private void refreshCache(List<Task> tasks) {
        if (mCachedTasks == null) {
            mCachedTasks = new LinkedHashMap<>();
        }
        mCachedTasks.clear();
        for (Task task : tasks) {
            mCachedTasks.put(task.getId(), task);
        }
        mCacheIsDirty = false;
    }

    private void refreshLocalDataSource(List<Task> tasks) {
        mTasksLocalDataSource.deleteAllTasks();
        for (Task task : tasks) {
            mTasksLocalDataSource.saveTask(task);
        }
    }

    @Nullable
    private Task getTaskWithId(@NonNull String id) {
        checkNotNull(id);
        if (mCachedTasks == null || mCachedTasks.isEmpty()) {
            return null;
        } else {
            return mCachedTasks.get(id);
        }
    }
}
