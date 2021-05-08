package com.example.gismobile;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng palu = new LatLng(-0.933176, 119.866752);
        LatLng puskesmas = new LatLng(-0.932823, 119.864432);
        LatLng warung = new LatLng(-0.931403, 119.865999);

        int tinggi = 100;
        int lebar = 100;
        BitmapDrawable bitmapStart=(BitmapDrawable) getResources().getDrawable(R.drawable.home);
        BitmapDrawable bitmapDes=(BitmapDrawable) getResources().getDrawable(R.drawable.hospital);
        BitmapDrawable bitmapWar=(BitmapDrawable) getResources().getDrawable(R.drawable.resto);
        Bitmap s=bitmapStart.getBitmap();
        Bitmap d=bitmapDes.getBitmap();
        Bitmap w=bitmapWar.getBitmap();
        Bitmap markerStart=Bitmap.createScaledBitmap(s, lebar, tinggi, false);
        Bitmap markerWar=Bitmap.createScaledBitmap(w, lebar, tinggi, false);
        Bitmap markerDes=Bitmap.createScaledBitmap(d, lebar, tinggi, false);

        mMap.addMarker(new MarkerOptions().position(palu).title("Rumah")
        .snippet("Ini Adalah Rumah Saya")
        .icon(BitmapDescriptorFactory.fromBitmap(markerStart)));

        mMap.addMarker(new MarkerOptions().position(warung).title("Warung Coto Makassar")
                .snippet("Ini Adalah Warung Coto Makassar")
                .icon(BitmapDescriptorFactory.fromBitmap(markerWar)));

        mMap.addMarker(new MarkerOptions().position(puskesmas).title("Puskesmas Pembantu Perumnas Tinggede")
                .snippet("Ini Adalah Puskesmas Pembantu Perumnas Tinggede")
                .icon(BitmapDescriptorFactory.fromBitmap(markerDes)));

        mMap.addPolyline(new PolylineOptions().add(
                palu,
                new LatLng(-0.933176, 119.866752),
                new LatLng(-0.933205, 119.866796),
                new LatLng(-0.933292, 119.866736),
                new LatLng(-0.933096, 119.866457),
                new LatLng(-0.933359, 119.866252),
                new LatLng(-0.932879, 119.865675),
                new LatLng(-0.932889, 119.865263),
                new LatLng(-0.932959, 119.864489),
                new LatLng(-0.932831, 119.864500),
                new LatLng(-0.932823, 119.864432),
                puskesmas
                )   .width (15)
                    .color(Color.MAGENTA)
                );

        mMap.addPolyline(new PolylineOptions().add(
                palu,
                new LatLng(-0.933176, 119.866752),
                new LatLng(-0.933205, 119.866796),
                new LatLng(-0.933292, 119.866736),
                new LatLng(-0.933096, 119.866457),
                new LatLng(-0.932787, 119.866681),
                new LatLng(-0.932641, 119.866657),
                new LatLng(-0.932492, 119.866645),
                new LatLng(-0.932494, 119.866322),
                new LatLng(-0.932518, 119.865991),
                new LatLng(-0.931728, 119.865941),
                new LatLng(-0.931369, 119.865878),
                new LatLng(-0.931325, 119.865930),
                new LatLng(-0.931318, 119.865995),
                new LatLng(-0.931403, 119.865999),
                warung
                )   .width (15)
                        .color(Color.DKGRAY)
        );

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(palu,14.5f));
    }
}