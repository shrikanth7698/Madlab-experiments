package me.shrikanthravi.madlab.activities;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import me.shrikanthravi.madlab.R;

public class ExperimentActivity2 extends AppCompatActivity {

    //Global
    TextView countTV;
    FloatingActionButton addFab;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment2);

        //Initialization
        init();

        //Listener for floating action button
        addFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                countTV.setText("You clicked the floating action button "+String.valueOf(count)+" times");
            }
        });


    }

    public void init(){
        //Hiding action bar that displays app name
        if(getSupportActionBar()!=null) {
            getSupportActionBar().hide();
        }

        //Linking xml views with java
        countTV = findViewById(R.id.countTV);
        addFab = findViewById(R.id.addFab);

    }
}
