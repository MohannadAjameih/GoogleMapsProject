package com.example.googlemapsproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;


public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        // Set initial camera position and zoom level
        LatLng initialLatLng = new LatLng(37.7749, -122.4194); // San Francisco coordinates
        float initialZoom = 12.0f; // Zoom level (0.0 - 21.0)
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(initialLatLng, initialZoom));

        // Define a specific range using LatLngBounds
        LatLngBounds.Builder boundsBuilder = new LatLngBounds.Builder();
        LatLng southwest = new LatLng(37.70, -123.00); // Southwest corner of the range
        LatLng northeast = new LatLng(37.85, -122.25); // Northeast corner of the range
        boundsBuilder.include(southwest);
        boundsBuilder.include(northeast);
        LatLngBounds bounds = boundsBuilder.build();


        // Define a specific circumference using CircleOptions
        LatLng center = new LatLng(37.75, -122.45); // Center of the circle
        double radius = 5000; // Radius in meters (e.g., 5 kilometers)
        CircleOptions circleOptions = new CircleOptions()
                .center(center)
                .radius(radius)
                .strokeColor(Color.RED) // Set the stroke color of the circle to red
                .strokeWidth(5); // Set the stroke width of the circle to 5 pixels

        // Add the circle to the map
        Circle circle = googleMap.addCircle(circleOptions);


        // Restrict the map's visible region to the defined range
        googleMap.setLatLngBoundsForCameraTarget(bounds);

        // Check if a LatLng falls within the defined range
       // LatLng markerLatLng = new LatLng(37.8, -122.4); // Example LatLng for the marker
       // if (bounds.contains(markerLatLng)) {
            // Add a red marker at the markerLatLng
        //    MarkerOptions markerOptions = new MarkerOptions()
         //           .position(markerLatLng)
         //           .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
         //   googleMap.addMarker(markerOptions);
        //}

    }
}
