package com.example.louisagabriella.googlemapsapi_gettingstartmaps;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap m_map;
    boolean mapReady = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMap = (Button) findViewById(R.id.btnMap);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady) m_map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            }
        });

        Button btnSatelite = (Button) findViewById(R.id.btnSatelite);
        btnSatelite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady) m_map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            }
        });

        Button btnHybrid = (Button) findViewById(R.id.btnHybrid);
        btnHybrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady) m_map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
        });

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap map) {
        mapReady = true;
        m_map = map;
        LatLng um = new LatLng(-7.961388, 112.617452);
        CameraPosition target = CameraPosition.builder().target(um).zoom(14).build();
        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }
}
