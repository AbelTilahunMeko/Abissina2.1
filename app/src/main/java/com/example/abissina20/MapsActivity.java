package com.example.abissina20;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {


    private GoogleMap mMap;
    public void buttonClicked(View v){
        switch (v.getId()){
            case R.id.normalView:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;
            case R.id.satelliteView:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;
            case R.id.hybrid:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID );
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


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
        MarkerOptions lali = new MarkerOptions()
                .title("Laibela")
                .position(new LatLng(12.0309, 39.0476))
                .snippet("Location 12.0309 N, 39.0476 E");
        MarkerOptions gonder = new MarkerOptions()
                .title("Gonder")
                .position(new LatLng(12.6030, 37.4521))
                .snippet("Loaction 12.6030 N, 37.4521 E");
        MarkerOptions axum = new MarkerOptions()
                .title("Axum")
                .position(new LatLng(14.1340, 38.7473))
                .snippet("Loaction 14.1340 N, 38.7473 E");
        MarkerOptions semen = new MarkerOptions()
                .title("Simien Mountains")
                .position(new LatLng(13.3064, 38.2641))
                .snippet("Loaction 13.3064 N , 38.2641E");
        MarkerOptions hahra = new MarkerOptions()
                .title("Harar City")
                .position(new LatLng(9.3126, 42.1227))
                .snippet("L8oacation 9.3126° N, 42.1227 E");
        MarkerOptions hawassa = new MarkerOptions()
                .title("Hawassa City")
                .position(new LatLng(7.0504, 38.4955))
                .snippet("Location 7.0504 N, 38.4955 E");
        MarkerOptions diredawa = new MarkerOptions()
                .title("Dire Dawa City")
                .position(new LatLng(9.6009, 41.8501))
                .snippet("Location 9.6009° N, 41.8501°");
        MarkerOptions bahirDar = new MarkerOptions()
                .title("Bahir Dar City")
                .position(new LatLng(11.5742, 37.3614))
                .snippet("Location 9.6009° N, 41.8501°");
        MarkerOptions jimma = new MarkerOptions()
                .title("Jimma City")
                .position(new LatLng(7.6739, 36.8358))
                .snippet("Loaction 7.6739 N, 36.8358 E");


        // Add a marker in Sydney and move the camera
        LatLng addisAbaba = new LatLng(8.9806, 38.7578);
        mMap.addMarker(new MarkerOptions().
                position(addisAbaba).
                title("Addis Ababa").
                snippet("Capital City Of Ethiopia, Located at Longtuide 8.9806 and Latitude 38.7578"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(addisAbaba));
        mMap.addMarker(lali);
        mMap.addMarker(gonder);
        mMap.addMarker(semen);
        mMap.addMarker(axum);
        mMap.addMarker(hahra);
        mMap.addMarker(bahirDar);
        mMap.addMarker(hawassa);
        mMap.addMarker(diredawa);
        mMap.addMarker(jimma);


    }
}
