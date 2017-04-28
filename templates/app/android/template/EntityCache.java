package com.inzpiral.drivin.app.session;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.maps.model.LatLng;
import com.inzpiral.drivin.app.model.Scenario;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by jose on 2/24/16.
 */
public class ScenarioCache extends AbstractCache {
    private static final String PREFERENCES = "started_scenarios.preferences";
    private static final String ROUTE_CACHE_FOLDER = "scenarios";
    private static final String ROUTE_PATH_FORMAT = "scenario_%d.cache";

    private static ScenarioCache sCache;

    public static synchronized ScenarioCache getCache(Context context) {
        if (sCache == null) {
            sCache = new ScenarioCache(context);
        }
        return sCache;
    }

    private Context mContext;
    private SharedPreferences mSharedPreferences;

    public ScenarioCache(Context context) {
        mContext = context;
        mSharedPreferences = context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
    }

    @Nullable
    public CopyOnWriteArrayList<CopyOnWriteArrayList<SerializableLatLng>> getScenarioPoints(@NonNull Scenario scenario) {
        File file = getScenarioCacheFile(scenario);
        if (file.exists()) {
            return (CopyOnWriteArrayList<CopyOnWriteArrayList<SerializableLatLng>>) load(getScenarioCacheFile(scenario));
        } else {
            return null;
        }
    }

    public void setScenarioPoints(@NonNull Scenario scenario, CopyOnWriteArrayList<CopyOnWriteArrayList<SerializableLatLng>> scenarioPoints) {
        save(scenarioPoints, getScenarioCacheFile(scenario));
    }

    public void setScenarioTimer(Scenario scenario, long timer) {
        mSharedPreferences.edit().putLong(scenario.getName(), timer).apply();
    }

    public long getScenarioTimer(Scenario scenario) {
        return mSharedPreferences.getLong(scenario.getName(), 0);
    }

    public boolean isScenarioStarted(Scenario scenario) {
        return mSharedPreferences.contains(scenario.getName());
    }

    private File getScenarioCacheFile(Scenario scenario) {
        String fileName = String.format(Locale.US, ROUTE_PATH_FORMAT, scenario.getScenarioId());
        File scenariosFileFolder = new File(mContext.getFilesDir(), ROUTE_CACHE_FOLDER);
        scenariosFileFolder.mkdirs();
        return new File(scenariosFileFolder, fileName);
    }

    /**
     * Clears the cache of all scenarios not listed in the supplied scenario list. Useful for releasing disk space when
     * updating the scenario list.
     *
     * @param scenarioList
     */
    public void clearCacheOfScenariosNotInList(List<Scenario> scenarioList) {
        File scenariosFileFolder = new File(mContext.getFilesDir(), ROUTE_CACHE_FOLDER);
        File[] scenarioFiles = scenariosFileFolder.listFiles();
        if (scenarioFiles != null) {
            for (File file : scenarioFiles) {
                boolean flag = false;
                for (Scenario scenario : scenarioList) {
                    String fileName = String.format(Locale.US, ROUTE_PATH_FORMAT, scenario.getScenarioId());
                    if (file.getName().equals(fileName)) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    file.delete();
                }
            }
        }

        // todo: clear the shared preferences too
    }

    public static class SerializableLatLng implements Serializable, Parcelable {
        private double mLatitude;
        private double mLongitude;

        public SerializableLatLng(double latitude, double longitude) {
            mLatitude = latitude;
            mLongitude = longitude;
        }

        public SerializableLatLng(LatLng latLng) {
            mLatitude = latLng.latitude;
            mLongitude = latLng.longitude;
        }

        protected SerializableLatLng(Parcel in) {
            mLatitude = in.readDouble();
            mLongitude = in.readDouble();
        }

        public static final Creator<SerializableLatLng> CREATOR = new Creator<SerializableLatLng>() {
            @Override
            public SerializableLatLng createFromParcel(Parcel in) {
                return new SerializableLatLng(in);
            }

            @Override
            public SerializableLatLng[] newArray(int size) {
                return new SerializableLatLng[size];
            }
        };

        public double getLatitude() {
            return mLatitude;
        }

        public double getLongitude() {
            return mLongitude;
        }

        public LatLng getLatLng() {
            return new LatLng(mLatitude, mLongitude);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeDouble(mLatitude);
            dest.writeDouble(mLongitude);
        }
    }
}
