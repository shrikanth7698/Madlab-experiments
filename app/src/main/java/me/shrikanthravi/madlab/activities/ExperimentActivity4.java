package me.shrikanthravi.madlab.activities;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import me.shrikanthravi.madlab.MyView;
import me.shrikanthravi.madlab.R;

public class ExperimentActivity4 extends AppCompatActivity {

    //Global
    MyView drawingView;
    Button rectangleBTN;
    Button circleBTN;
    Button squareBTN;
    CardView redCV;
    CardView blueCV;
    CardView yellowCV;

    // 0 - Rect
    // 1 - Square
    // 2 - Circle
    int currentShape=0;
    int currentColor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment4);

        //Initialization
        init();

        rectangleBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
                //RectF innerRectangle = new RectF(100, 100, 500, 300);
                //canvas.drawRect(innerRectangle,paint);
                currentShape = 0;
                drawingView.setCurrentShape(currentShape);
                //graphicsIV.invalidate();
            }
        });

        circleBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
                //canvas.drawCircle(100,500,100,paint);
                currentShape = 2;
                drawingView.setCurrentShape(currentShape);
                //graphicsIV.invalidate();
            }
        });

        squareBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
                //RectF innerRectangle = new RectF(500, 500, 300, 300);
                //canvas.drawRect(innerRectangle,paint);
                currentShape = 1;
                drawingView.setCurrentShape(currentShape);
                //graphicsIV.invalidate();
            }
        });

        redCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawingView.setPaintColor(Color.parseColor("#FF0000"));
            }
        });

        blueCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawingView.setPaintColor(Color.parseColor("#00F3D4"));
            }
        });

        yellowCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawingView.setPaintColor(Color.parseColor("#FFDD00"));
            }
        });

    }


    public void init(){
        //Hiding action bar that displays app name
        if(getSupportActionBar()!=null) {
            getSupportActionBar().hide();
        }

        drawingView = findViewById(R.id.drawingView);
        rectangleBTN = findViewById(R.id.rectangleBTN);
        circleBTN = findViewById(R.id.circleBTN);
        squareBTN = findViewById(R.id.squareBTN);
        redCV = findViewById(R.id.redColorCV);
        blueCV = findViewById(R.id.blueColorCV);
        yellowCV = findViewById(R.id.yellowColorCV);

        currentColor = Color.parseColor("#FF0000");
        drawingView.setPaintColor(currentColor);



    }
}
