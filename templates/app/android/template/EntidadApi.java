package com.inzpiral.drivin.app.network.apis;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inzpiral.drivin.app.model.Orden;
import com.inzpiral.drivin.app.model.Order;
import com.inzpiral.drivin.app.model.Vehicle;
import com.inzpiral.drivin.app.model.Route;
import com.inzpiral.drivin.app.network.JacksonAuthenticatedRequest;
import com.inzpiral.drivin.app.network.NetworkManager;
import com.inzpiral.drivin.app.tasks.TaskResponse;

/**
 * Created by carloshinostrozadroguett on 13-09-16.
 */
public class {{ entidad|capitalize}}Api extends AbstractApi<Void,{{ entidad|capitalize }}Api.{{ entidad|capitalize }}Response> {
    
    private Context mContext;
    private int mRouteId;
    private String mUrl;
    private boolean mUseLocalCache;
    private int mMethod;
    private Order mOrder;
    private Orden mOrden;

    public static TaskResponse<OrdenesResponse> executeOrdenes(Context context, Order order){
        OrdenesApi ordenesApi = new OrdenesApi(context, order.getRouteId());
        ordenesApi.setUseLocalCache(true);

        NetworkManager networkManager = NetworkManager.getNetworkManager(context);
        return networkManager.fetch(ordenesApi);

    }

    public OrdenesApi(Context context, int routeId) {
        mContext = context;
        mRouteId = routeId;
        //mUrl = API.ORDEN_LIST.getUrl(mContext, routeId);
        mUrl = "http://104.131.55.74:3003/api/orders/route/48710";
        mMethod = Method.GET;
    }

    public OrdenesApi (Context context, int vehicleId,int routeId,String url,int method, Order order){
        mContext = context;
        mRouteId = routeId;
        mUrl = url;
        mMethod = method;
        mOrder = order;
    }

    public void setUseLocalCache(boolean useLocalCache) {
        mUseLocalCache = useLocalCache;
    }

    public String getBody(OrdenesRequest orden){

        ObjectMapper mapper = new ObjectMapper();
        try {
            String body = mapper.writeValueAsString(orden);
             Log.i("tag", body);
            return body;
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    @Override
    public Request buildRequest(){
        String body = null;
        if ( mMethod == Method.PUT ){
            OrdenesRequest beta = new OrdenesRequest(mOrden);
            body = getBody(beta);
        }


        JacksonAuthenticatedRequest request = new JacksonAuthenticatedRequest<>(
                mContext,
                mMethod,
                mUrl,
                OrdenesResponse.class,
                body,
                getListener(),
                getErrorListener());

        return request;
    }



    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OrdenesResponse {
        private String mName;
        private Orden[] mOrdenes;

        @JsonProperty("name")
        public String getName() {
            return mName;
        }

        @JsonProperty("name")
        public void setName(String name) {
            mName = name;
        }

        @JsonProperty("orders")
        public Orden[] getOrdenes() {
            return mOrdenes;
        }

        @JsonProperty("orders")
        public void setOrdenes(Orden[] ordenes) {
            mOrdenes = ordenes;
        }
    }

    public static class OrdenesRequest {
        private Orden mEvents;

        public OrdenesRequest(Orden events) {
            mEvents = events;
        }

        @JsonProperty("order")
        public Orden getEvents() {
            return mEvents;
        }
    }
}
