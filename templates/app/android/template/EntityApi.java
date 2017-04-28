package com.inzpiral.drivin.app.network.apis;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inzpiral.drivin.app.model.Escenario;
import com.inzpiral.drivin.app.model.entities.DrivinAddress;
import com.inzpiral.drivin.app.network.JacksonAuthenticatedRequest;
import com.inzpiral.drivin.app.network.NetworkManager;
import com.inzpiral.drivin.app.network.apis.OrdersApi.OrdersResponse;
import com.inzpiral.drivin.app.tasks.TaskResponse;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by jose on 5/13/15.
 */
public class EscenariosApi extends AbstractApi<Void, EscenariosResponse> {

    private Context mContext;
    private int mOrganizacionId;
    private String mUrl;
    private boolean mUseLocalCache;
    private int mMethod;
    private Escenario mEscenario;

    public static TaskResponse<OrdersResponse> executeOrders(Context context, Route route) {
        OrdersApi ordersApi = new OrdersApi(context, route.getRouteId());
        ordersApi.setUseLocalCache(true);

        NetworkManager networkManager = NetworkManager.getNetworkManager(context);
        return networkManager.fetch(ordersApi);
    }

    public OrdersApi(Context context, int routeId) {
        mContext = context;
        mRouteId = routeId;
        mUrl = API.ORDER_LIST.getUrl(mContext, mRouteId);
        mMethod = Method.GET;
    }

    public OrdersApi(Context context, int routeId, String url, int method, Order order) {
        mContext = context;
        mRouteId = routeId;
        mUrl = url;
        mMethod = method;
        mOrder = order;
    }


    public void setUseLocalCache(boolean useLocalCache) {
        mUseLocalCache = useLocalCache;
    }

    public String getBody(OrdersRequest order){

        ObjectMapper mapper = new ObjectMapper();
        try {
            String body = mapper.writeValueAsString(order);
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
            OrdersRequest beta = new OrdersRequest(mOrder);
            body = getBody(beta);
        }

        JacksonAuthenticatedRequest request = new JacksonAuthenticatedRequest<>(
                mContext,
                mMethod,
                mUrl,
                OrdersResponse.class,
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
    public static class OrdersResponse {
        private String mName;
        private Order[] mOrders;

        @JsonProperty("name")
        public String getName() {
            return mName;
        }

        @JsonProperty("name")
        public void setName(String name) {
            mName = name;
        }

        @JsonProperty("orders")
        public Order[] getOrders() {
            return mOrders;
        }

        @JsonProperty("orders")
        public void setOrders(Order[] orders) {
            mOrders = orders;
        }
    }

    public static class OrdersRequest {
        private Order mEvents;

        public OrdersRequest(Order events) {
            mEvents = events;
        }

        @JsonProperty("order")
        public Order getEvents() {
            return mEvents;
        }
    }


}
