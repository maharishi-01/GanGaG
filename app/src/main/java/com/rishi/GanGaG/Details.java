package com.rishi.GanGaG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.security.PublicKey;

public class Details extends AppCompatActivity{
private MapView mapView;
private TextView mname,mlocation,mspecific,mabout;
public DatabaseReference reference;
public String location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        mapView=findViewById(R.id.mapView);
        mname=findViewById(R.id.name);
        mlocation=findViewById(R.id.location);
        mspecific=findViewById(R.id.specific);
        mabout=findViewById(R.id.about);
        reference=FirebaseDatabase.getInstance().getReference().child("Gahts");
        location=getIntent().getStringExtra("sLocation");

        getUserData();
    }

    private void getUserData() {
        mname.setText(getIntent().getStringExtra("sName"));
        mlocation.setText(location);
        mabout.setText(getIntent().getStringExtra("sAbout"));
        mspecific.setText(getIntent().getStringExtra("sSpecific"));

    }
}
