package com.example.dionysus.splashfraghawkqr;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.BindView;
import butterknife.OnClick;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    SupportMapFragment mapFragment;
    Handler handler = new Handler();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map2);
        mapFragment.getMapAsync(this);


        handler.postDelayed(DelayRun,5000);

    }

    private Runnable DelayRun = new Runnable() {
        @Override
        public void run() {
            Intent i = new Intent(MapsActivity.this,MainActivity.class);
            startActivity(i);
            finish();
        }
    };

//    @OnClick(R.id.map_back)
//    public void setMap_back(){
//
//        BaseFragment.startFrag(R.id.container,new ParentFragment(),getFragmentManager());
//        Log.i("map_back","SS");
////        Intent i = new Intent(this,MainActivity.class);
////        startActivity(i);
//    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMinZoomPreference(16.0f);
        mMap.setMaxZoomPreference(16.0f);


        LatLng sydney = new LatLng(-34, 151);

        // Add a marker in Sydney and move the camera

        sydney = new LatLng(22.477061, 114.046398);


        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in XXX"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
