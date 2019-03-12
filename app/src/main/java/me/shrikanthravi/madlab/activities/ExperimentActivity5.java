package me.shrikanthravi.madlab.activities;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import me.shrikanthravi.madlab.R;

public class ExperimentActivity5 extends AppCompatActivity {

    TextView bmeTV;
    TextView chemTV;
    TextView civilTV;
    TextView cseTV;
    TextView eceTV;
    TextView eeeTV;
    TextView itTV;
    TextView mechTV;
    DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment5);

        //Initialization
        init();

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String bmePercent = dataSnapshot.child("BME").getValue().toString();
                String chemPercent = dataSnapshot.child("CHEM").getValue().toString();
                String civilPercent = dataSnapshot.child("CIVIL").getValue().toString();
                String csePercent = dataSnapshot.child("CSE").getValue().toString();
                String ecePercent = dataSnapshot.child("ECE").getValue().toString();
                String eeePercent = dataSnapshot.child("EEE").getValue().toString();
                String itPercent = dataSnapshot.child("IT").getValue().toString();
                String mechPercent = dataSnapshot.child("MECH").getValue().toString();
                bmeTV.setText(bmePercent);
                chemTV.setText(chemPercent);
                civilTV.setText(civilPercent);
                cseTV.setText(csePercent);
                eceTV.setText(ecePercent);
                eeeTV.setText(eeePercent);
                itTV.setText(itPercent);
                mechTV.setText(mechPercent);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void init(){
        //Hiding action bar that displays app name
        if(getSupportActionBar()!=null) {
            getSupportActionBar().hide();
        }

        mDatabase = FirebaseDatabase.getInstance().getReference().child("sycon");
        //Linking xml views with java
        bmeTV = findViewById(R.id.bmeTV);
        chemTV = findViewById(R.id.chemTV);
        civilTV = findViewById(R.id.civilTV);
        cseTV = findViewById(R.id.cseTV);
        eceTV = findViewById(R.id.eceTV);
        eeeTV = findViewById(R.id.eeeTV);
        itTV = findViewById(R.id.itTV);
        mechTV = findViewById(R.id.mechTV);

    }
}
