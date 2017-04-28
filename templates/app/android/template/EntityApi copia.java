package com.inzpiral.drivin.app.network.apis;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inzpiral.drivin.app.model.{{ name|capitalize }};
import com.inzpiral.drivin.app.model.entities.DrivinAddress;
import com.inzpiral.drivin.app.network.JacksonAuthenticatedRequest;
import com.inzpiral.drivin.app.network.NetworkManager;
import com.inzpiral.drivin.app.network.apis.{{ name|capitalize }}sApi.{{ name|capitalize }}sResponse;
import com.inzpiral.drivin.app.tasks.TaskResponse;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by jose on 5/13/15.
 */
public class {{ name|capitalize }}sApi extends AbstractApi<Void, {{ name|capitalize }}sResponse> {

    private Context mContext;
    private {{ request.params[0].type }} {{ request.params[0].name }};
    private String mUrl;
    private boolean mUseLocalCache;
    private int mMethod;
    private {{ name|capitalize }} m{{ name|capitalize }};

    public static TaskResponse<{{ name|capitalize }}sResponse> execute{{ name|capitalize }}s(Context context, {{ request.params[0].type }} {{ request.params[0].name }}) {
        {{ name|capitalize }}sApi {{ name}}sApi = new {{ name|capitalize }}sApi(context, route.getRouteId());
        {{ name}}sApi.setUseLocalCache(true);

        NetworkManager networkManager = NetworkManager.getNetworkManager(context);
        return networkManager.fetch({{ name}}sApi);
    }

    public {{ name|capitalize }}sApi(Context context, int routeId) {
        mContext = context;
        mRouteId = routeId;
        mUrl = API.{{ name|upper }}_LIST.getUrl(mContext, {{ request.params[0].name }});
        mMethod = Method.GET;
    }

    public {{ name|capitalize }}sApi(Context context, {{ request.params[0].type }} {{ request.params[0].name }}, String url, int method, {{ name|capitalize }} {{ name}}) {
        mContext = context;
        mRouteId = routeId;
        mUrl = url;
        mMethod = method;
        m{{ name|capitalize }} = {{ name}};
    }


    public void setUseLocalCache(boolean useLocalCache) {
        mUseLocalCache = useLocalCache;
    }

    public String getBody({{ name|capitalize }}sRequest {{ name}}){

        ObjectMapper mapper = new ObjectMapper();
        try {
            String body = mapper.writeValueAsString({{ name}});
            // Log.i("tag", body);
            return body;
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    @Override
    public Request buildRequest() {
        String body = null;
        if(mMethod == Method.PUT) {
            {{ name|capitalize }}sRequest beta = new {{ name|capitalize }}sRequest(m{{ name|capitalize }});
            body = getBody(beta);
        }

        JacksonAuthenticatedRequest request = new JacksonAuthenticatedRequest<>(
                mContext,
                mMethod,
                mUrl,
                {{ name|capitalize }}sResponse.class,
                body,
                getListener(),
                getErrorListener());

        //if (mUseLocalCache) {
        // request.forceLocalCache();
        //}

        return request;
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class {{ name|capitalize }}sResponse {
        private {{ name|capitalize }}[] m{{ name|capitalize }}s;

        @JsonProperty("{{ name }}s")
        public {{ name|capitalize }}[] get{{ name|capitalize }}s() {
            return m{{ name|capitalize }}s;
        }

        @JsonProperty("{{ name }}s")
        public void set{{ name|capitalize }}s({{ name|capitalize }}[] {{ name}}s) {
            m{{ name|capitalize }}s = {{ name}}s;
        }
    }

    public static class {{ name|capitalize }}sRequest {
        private {{ name|capitalize }} mEvents;

        public {{ name|capitalize }}sRequest({{ name|capitalize }} events) {
            mEvents = events;
        }

        @JsonProperty("{{ name }}")
        public {{ name|capitalize }} getEvents() {
            return mEvents;
        }
    }


}
