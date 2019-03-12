package me.shrikanthravi.madlab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import me.shrikanthravi.madlab.activities.ExperimentActivity1;
import me.shrikanthravi.madlab.activities.ExperimentActivity10;
import me.shrikanthravi.madlab.activities.ExperimentActivity11;
import me.shrikanthravi.madlab.activities.ExperimentActivity2;
import me.shrikanthravi.madlab.activities.ExperimentActivity3;
import me.shrikanthravi.madlab.activities.ExperimentActivity4;
import me.shrikanthravi.madlab.activities.ExperimentActivity5;
import me.shrikanthravi.madlab.activities.ExperimentActivity6;
import me.shrikanthravi.madlab.activities.ExperimentActivity7;
import me.shrikanthravi.madlab.activities.ExperimentActivity8;
import me.shrikanthravi.madlab.activities.ExperimentActivity9;
import me.shrikanthravi.madlab.adapters.ExperimentsAdapter;
import me.shrikanthravi.madlab.data.models.Experiment;

public class HomeActivity extends AppCompatActivity {

    //Global init
    RecyclerView experimentsRV;
    List<Experiment> experimentList = new ArrayList<>();
    ExperimentsAdapter adapter;
    LinearLayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Changing action bar title
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setTitle("MAD lab experiments");
        }

        //Initialization
        init();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

    }

    public void init(){
        experimentsRV = findViewById(R.id.experimentsRV);
        adapter = new ExperimentsAdapter(
                experimentList,
                getApplicationContext(),
                new ExperimentsAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(Experiment item, int pos) {
                        viewCode(pos+1);
                    }
                },
                new ExperimentsAdapter.OnViewCodeClickListener() {
                    @Override
                    public void onViewCodeClick(Experiment item, int pos) {
                        //viewCode(pos+1);
                    }
                },
                new ExperimentsAdapter.OnRunAppClickListener() {
                    @Override
                    public void onRunAppClick(Experiment item, int pos) {
                        runApp(pos+1);
                    }
                });
        layoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        experimentsRV.setLayoutManager(layoutManager);
        experimentsRV.setAdapter(adapter);
        populateExperiments();

    }

    public void populateExperiments(){
        experimentList.add(new Experiment("1","Develop an application that uses GUI components, Font and Colors."));
        experimentList.add(new Experiment("2","Develop an application that uses Layout Managers and event listeners."));
        experimentList.add(new Experiment("3","Develop a native calculator application."));
        experimentList.add(new Experiment("4", "Write an application that draws basic graphical primitives on the screen."));
        experimentList.add(new Experiment("5", "Develop an application that makes use of database."));
        experimentList.add(new Experiment("6", "Develop an application that makes use of RSS Feed."));
        experimentList.add(new Experiment("7", "Develop an application that implements Multi threading."));
        experimentList.add(new Experiment("8", "Develop a native application that uses GPS location information."));
        experimentList.add(new Experiment("9", "Implement an application that writes data to the SD card."));
        experimentList.add(new Experiment("10", "Implement an application that creates an alert upon receiving a message."));
        experimentList.add(new Experiment("11", "Write a mobile application that creates alarm clock"));
        adapter.notifyDataSetChanged();
    }

    public void viewCode(int pos){
        String filename = "exp"+String.valueOf(pos)+".txt";
        Intent intent = new Intent(getApplicationContext(),CodeViewActivity.class);
        intent.putExtra("codeTitle",experimentList.get(pos-1).getTitle());
        intent.putExtra("filename", filename);
        startActivity(intent);
    }


    public void runApp(int pos){
        switch (pos){
            case 1:{
                startActivity(new Intent(getApplicationContext(),ExperimentActivity1.class));
                break;
            }
            case 2:{
                startActivity(new Intent(getApplicationContext(),ExperimentActivity2.class));
                break;
            }
            case 3:{
                startActivity(new Intent(getApplicationContext(), ExperimentActivity3.class));
                break;
            }
            case 4:{
                startActivity(new Intent(getApplicationContext(), ExperimentActivity4.class));
                break;
            }
            case 5:{
                startActivity(new Intent(getApplicationContext(), ExperimentActivity5.class));
                break;
            }
            case 6:{
                startActivity(new Intent(getApplicationContext(), ExperimentActivity6.class));
                break;
            }
            case 7:{
                startActivity(new Intent(getApplicationContext(), ExperimentActivity7.class));
                break;
            }
            case 8:{
                startActivity(new Intent(getApplicationContext(), ExperimentActivity8.class));
                break;
            }
            case 9:{
                startActivity(new Intent(getApplicationContext(), ExperimentActivity9.class));
                break;
            }
            case 10:{
                startActivity(new Intent(getApplicationContext(), ExperimentActivity10.class));
                break;
            }
            case 11:{
                startActivity(new Intent(getApplicationContext(), ExperimentActivity11.class));
                break;
            }
        }
    }
}
