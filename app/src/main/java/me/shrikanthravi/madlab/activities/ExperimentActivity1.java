package me.shrikanthravi.madlab.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import me.shrikanthravi.madlab.R;

public class ExperimentActivity1 extends AppCompatActivity {

    //Global
    Button loginBTN;
    EditText emailET;
    EditText passwordET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment1);
        //Initialization
        init();

        //Listener for login BTN
        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Validate email and password
                if(emailET.getText().toString().trim().length()!=0){
                    if(passwordET.getText().toString().trim().length()!=0){
                        Toast.makeText(getApplicationContext(),"Login successful!",Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getApplicationContext(),"Password field is empty!",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(getApplicationContext(),"Email field is empty!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void init(){
        //Hiding action bar that displays app name
        if(getSupportActionBar()!=null) {
            getSupportActionBar().hide();
        }

        //Linking xml views with java
        loginBTN = findViewById(R.id.loginBTN);
        emailET = findViewById(R.id.emailET);
        passwordET = findViewById(R.id.passwordET);

    }
}
