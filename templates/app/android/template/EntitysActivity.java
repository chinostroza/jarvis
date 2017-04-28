package com.inzpiral.drivin.app;

import android.*;
import android.Manifest;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.inzpiral.drivin.app.dialogs.AlertDialogFragment;
import com.inzpiral.drivin.app.dialogs.AlertDialogFragment.AlertDialogListener;
import com.inzpiral.drivin.app.OfflineActivity;
import com.inzpiral.drivin.app.fragments.OrdersFragment;
import com.inzpiral.drivin.app.fragments.OrdersMapFragment;
import com.inzpiral.drivin.app.fragments.MapFragmentSinLugar;
import com.inzpiral.drivin.app.fragments.RoutesFragment;
import com.inzpiral.drivin.app.fragments.RoutesFragment.RoutesListener;
import com.inzpiral.drivin.app.model.Order;
import com.inzpiral.drivin.app.model.Route;
import com.inzpiral.drivin.app.model.Vehicle;
import com.inzpiral.drivin.app.session.SessionCache;
import com.inzpiral.drivin.app.session.SessionManager;
import com.inzpiral.drivin.app.utils.DrivinErrorManager;
import com.inzpiral.drivin.app.utils.Preconditions;

import java.util.ArrayList;

/**
 * Created by jose on 5/9/15.
 */
public class RoutesActivity extends AppCompatActivity implements RoutesListener, AlertDialogListener {
    private RoutesFragment mRoutesFragment;

    private Vehicle mVehicle;
    private ArrayList<Route> mRouteList;
    private OrdersMapFragment mOrdersMapFragment;
    private MapFragmentSinLugar mMapFragmentSinLugar;

    private static final int REQUEST_CODE_PERMISSIONS = 201;
    private static final int REQUEST_CODE_DIALOG_ACCOUNT_DELETED = 202;

    public static Intent getIntent(Context context, Vehicle vehicle, ArrayList<Route> routes) {
        Intent intent = new Intent(context, RoutesActivity.class);
        intent.putExtra(RoutesFragment.KEY_VEHICLE, (Parcelable) vehicle);
        intent.putParcelableArrayListExtra(RoutesFragment.KEY_ROUTES, routes);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routes);

        if (savedInstanceState == null) {
            mVehicle = getIntent().getParcelableExtra(RoutesFragment.KEY_VEHICLE);
            mRouteList = getIntent().getParcelableArrayListExtra(RoutesFragment.KEY_ROUTES);
        } else {
            mVehicle = savedInstanceState.getParcelable(RoutesFragment.KEY_VEHICLE);
            mRouteList = savedInstanceState.getParcelableArrayList(RoutesFragment.KEY_ROUTES);
        }

        mRoutesFragment = (RoutesFragment) getFragmentManager().findFragmentByTag(RoutesFragment.TAG);
        if (mRoutesFragment == null) {
            mRoutesFragment = new RoutesFragment();
            Bundle arguments = new Bundle();
            arguments.putParcelable(RoutesFragment.KEY_VEHICLE, mVehicle);
            arguments.putParcelableArrayList(RoutesFragment.KEY_ROUTES, mRouteList);
            mRoutesFragment.setArguments(arguments);

            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.layout, mRoutesFragment, RoutesFragment.TAG);
            fragmentTransaction.commit();
        }

        mRoutesFragment.setListener(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        LinearLayout layoutToolBarMapIcon = (LinearLayout) findViewById(R.id.linear_layout_map);
        layoutToolBarMapIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Context context = getApplicationContext();

                DrivinErrorManager.Status status = Preconditions.checkTrackingPreconditions(context);
                if (status == DrivinErrorManager.Status.OK) {

                    // mMapFragmentSinLugar = new MapFragmentSinLugar();
                    mOrdersMapFragment = new OrdersMapFragment();

                    mOrdersMapFragment = OrdersMapFragment.getFragment(null, null);

                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

                    fragmentTransaction.replace(R.id.layout, mOrdersMapFragment, OrdersMapFragment.TAG);

                    fragmentTransaction.commit();
                }else{

                    if (status == DrivinErrorManager.Status.PERMISSIONS_DENIED) {
                        ActivityCompat.requestPermissions(RoutesActivity.this,
                                new String[]{ Manifest.permission.ACCESS_FINE_LOCATION },
                                REQUEST_CODE_PERMISSIONS);
                    } else if (status == DrivinErrorManager.Status.GPS_DISABLED) {
                        AlertDialogFragment alertDialogFragment = AlertDialogFragment.getAlertDialog(RoutesActivity.this,
                                0,
                                getString(R.string.dialog_title_warning),
                                getString(R.string.dialog_alert_gps_not_enabled_message));
                        alertDialogFragment.show(getFragmentManager(), AlertDialogFragment.TAG);
                    } else if (status == DrivinErrorManager.Status.ACCOUNT_DELETED) {
                        AlertDialogFragment alertDialogFragment = AlertDialogFragment.getAlertDialog(RoutesActivity.this,
                                REQUEST_CODE_DIALOG_ACCOUNT_DELETED,
                                getString(R.string.dialog_title_warning),
                                getString(R.string.dialog_alert_missing_account));
                        alertDialogFragment.show(getFragmentManager(), AlertDialogFragment.TAG);
                    }
                }
            }
        });
        LinearLayout layoutToolBarOnIcon = (LinearLayout) findViewById(R.id.linear_layout_on);
        layoutToolBarOnIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(RoutesActivity.this, OfflineActivity.class);
                RoutesActivity.this.startActivity(myIntent);
            }
        });
        /*
        TextView txtTruck = (TextView) findViewById(R.id.txt_truck);
        txtTruck.setText(mVehicle.getLicensePlate());
        */
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRoutesFragment.setListener(null);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(RoutesFragment.KEY_VEHICLE, mVehicle);
        outState.putParcelableArrayList(RoutesFragment.KEY_ROUTES, mRouteList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_routes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.action_refresh) {
            mRoutesFragment.refresh();
            return true;
        } else if (itemId == R.id.action_change_vehicle) {
            changeVehicle();
            return true;
        }  else if (itemId == R.id.action_logout) {
            logout();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void changeVehicle() {
        SessionCache sessionCache = SessionCache.getCache(this);
        sessionCache.setActiveVehicle(null);

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(mVehicle);

        Intent intent = VehiclesActivity.getIntent(this, vehicles);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    private void logout() {
        SessionManager.logout(this);

        Intent intent = LoginActivity.getIntent(this);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @Override
    public void onRouteSelected(Route route, ArrayList<Order> orders) {
        SessionCache sessionCache = SessionCache.getCache(this);
        sessionCache.setActiveRoute(route);
        sessionCache.setOrderList(orders);

        Intent intent = OrdersActivity.getIntent(this, mVehicle, route, orders);

        startActivity(intent);
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        mRoutesFragment.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onAlertDialogDismiss(int requestCode) {
        mRoutesFragment.onAlertDialogDismiss(requestCode);
    }
}
