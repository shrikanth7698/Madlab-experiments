package me.shrikanthravi.madlab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;
import com.mittsu.markedview.MarkedView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeViewActivity extends AppCompatActivity {

    String codeTitle = "";
    String filename = "";
    MarkedView markedView;
    TextView codeTitleTV;
    String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_view);
        getSupportActionBar().hide();
        init();
    }

    public void init(){
        codeTitleTV = findViewById(R.id.codeTitleTV);
        markedView = findViewById(R.id.md_view);
        codeTitle = getIntent().getStringExtra("codeTitle");
        filename = getIntent().getStringExtra("filename");
        codeTitleTV.setText(codeTitle);

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open(filename)));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            String ls = System.getProperty("line.separator");
            Log.e("Reader Stuff",reader.readLine());
            while ((line = reader.readLine()) != null) {
                //Log.e("code",line);
                stringBuilder.append(line);
                stringBuilder.append(ls);

            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            String content = stringBuilder.toString();
            markedView.setMDText(content);

        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }
}
