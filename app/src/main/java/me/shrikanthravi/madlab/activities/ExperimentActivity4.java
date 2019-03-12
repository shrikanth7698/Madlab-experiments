package me.shrikanthravi.madlab.activities;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import me.shrikanthravi.madlab.R;

public class ExperimentActivity4 extends AppCompatActivity {

    //Global
    ImageView graphicsIV;
    Button rectangleBTN;
    Button circleBTN;
    Button squareBTN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment4);

        //Initialization
        init();

        rectangleBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
                RectF innerRectangle = new RectF(100, 100, 500, 300);
                canvas.drawRect(innerRectangle,paint);
                graphicsIV.invalidate();
            }
        });

        circleBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
                canvas.drawCircle(100,500,100,paint);
                graphicsIV.invalidate();
            }
        });

        squareBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
                RectF innerRectangle = new RectF(500, 500, 300, 300);
                canvas.drawRect(innerRectangle,paint);
                graphicsIV.invalidate();
            }
        });

    }

    Bitmap bitmap;
    Paint paint;
    Canvas canvas;
    public void init(){
        //Hiding action bar that displays app name
        if(getSupportActionBar()!=null) {
            getSupportActionBar().hide();
        }

        //Linking xml views with java
        graphicsIV = findViewById(R.id.graphicsIV);
        Display currentDisplay = getWindowManager().getDefaultDisplay();
        float dw = currentDisplay.getWidth();
        float dh = currentDisplay.getHeight();
        System.out.println("display width -> "+dw);
        bitmap = Bitmap.createBitmap((int) dw, (int) dh, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        paint = new Paint();
        paint.setColor(Color.RED);
        graphicsIV.setImageBitmap(bitmap);
        rectangleBTN = findViewById(R.id.rectangleBTN);
        circleBTN = findViewById(R.id.circleBTN);
        squareBTN = findViewById(R.id.squareBTN);

    }
}
