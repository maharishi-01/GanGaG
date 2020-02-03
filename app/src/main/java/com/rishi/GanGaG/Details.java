package com.rishi.GanGaG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.security.PublicKey;

public class Details extends AppCompatActivity implements OnMapReadyCallback{
private TextView mname,mlocation,mspecific,mabout;
public DatabaseReference reference;
public String location;
    GoogleMap googleMap;
    MapFragment mapFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        mname=findViewById(R.id.name);
        mlocation=findViewById(R.id.location);
        mspecific=findViewById(R.id.specific);
        mabout=findViewById(R.id.about);
        reference=FirebaseDatabase.getInstance().getReference().child("Gahts");
        location=getIntent().getStringExtra("sLocation");

        getUserData();

        GeocodingLocation locationAddress = new GeocodingLocation();
        locationAddress.getAddressFromLocation(location,
                getApplicationContext(), new GeocoderHandler());

        Toast.makeText(Details.this,""+GeocodingLocation.lat,Toast.LENGTH_SHORT).show();
        mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    private void getUserData() {
        mname.setText(getIntent().getStringExtra("sName"));
        mlocation.setText(location);
        mabout.setText(getIntent().getStringExtra("sAbout"));
        mspecific.setText(getIntent().getStringExtra("sSpecific"));
        Toast.makeText(Details.this,""+GeocodingLocation.lat,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onMapReady(GoogleMap gMap) {
        googleMap = gMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        try {
            googleMap.setMyLocationEnabled(true);
        } catch (SecurityException se) {

        }

        //Edit the following as per you needs
        googleMap.setTrafficEnabled(true);
        googleMap.setIndoorEnabled(true);
        googleMap.setBuildingsEnabled(true);
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        //

        LatLng placeLocation = new LatLng(GeocodingLocation.lat,GeocodingLocation.llog); //Make them global
        Marker placeMarker = googleMap.addMarker(new MarkerOptions().position(placeLocation)
                .title(location));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(placeLocation));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(10), 1000, null);
    }

    private class GeocoderHandler extends Handler {
        @Override
        public void handleMessage(Message message) {
            String locationAddress;
            switch (message.what) {
                case 1:
                    Bundle bundle = message.getData();
                    locationAddress = bundle.getString("address");
                    break;
                default:
                    locationAddress = null;
            }
           // Toast.makeText(Details.this,""+GeocodingLocation.lat,Toast.LENGTH_SHORT).show();
        }
    }
}
