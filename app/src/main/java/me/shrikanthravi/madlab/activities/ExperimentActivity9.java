package me.shrikanthravi.madlab.activities;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import me.shrikanthravi.madlab.R;

public class ExperimentActivity9 extends AppCompatActivity {

    EditText writeET;
    Button writeBTN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment9);

        //Initialization
        init();

        writeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(writeET.getText().toString().trim().length()!=0){
                    writetoSD(writeET.getText().toString());
                }else {
                    Toast.makeText(getApplicationContext(),"Blank text cannot be written !",Toast.LENGTH_SHORT).show();
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
        writeBTN = findViewById(R.id.writeBTN);
        writeET = findViewById(R.id.writeET);
    }

    public void writetoSD(String text){
        // Get the directory for the user's public download directory.
        final File path =
                Environment.getExternalStoragePublicDirectory
                        (
                                //Environment.DIRECTORY_PICTURES
                                Environment.DIRECTORY_DOWNLOADS + "/madlabFolder/"
                        );

        // Make sure the path directory exists.
        if(!path.exists())
        {
            // Make it, if it doesn't exit
            path.mkdirs();
        }

        final File file = new File(path, "config.txt");

        // Save your stream, don't forget to flush() it before closing it.

        try
        {
            file.createNewFile();
            FileOutputStream fOut = new FileOutputStream(file);
            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
            myOutWriter.append(text);

            myOutWriter.close();

            fOut.flush();
            fOut.close();
            Toast.makeText(getApplicationContext(),"Config.txt file with above data created inside downloads folder.",Toast.LENGTH_SHORT).show();
            writeET.setText("");
        }
        catch (IOException e)
        {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

}
