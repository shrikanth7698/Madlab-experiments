package me.shrikanthravi.madlab;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class MyView extends View {

    float x, y;
    Bitmap bmp;
    Paint mPaint;
    float width = 250.0f;
    float height = 125.0f;

    boolean touched = false;
    int currentShape=0;

    public MyView(Context context) {
        super(context);
        init(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }
    private void init(Context context) {
        x = y = 0;
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    Bitmap mDrawBitmap;
    Canvas mBitmapCanvas;
    Paint mDrawPaint = new Paint();

    @Override
    protected void onDraw(Canvas canvas) {
        //canvas.drawColor(Color.WHITE);
        if (mDrawBitmap == null) {
            mDrawBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            mBitmapCanvas = new Canvas(mDrawBitmap);
        }
        if (touched) {
            switch (currentShape){
                case 0:
                    mBitmapCanvas.drawRect(x, y, x + width, y + height, mPaint);
                    canvas.drawBitmap(mDrawBitmap, 0, 0, mDrawPaint);
                    break;
                case 1:
                    mBitmapCanvas.drawRect(x, y, x + height, y + height, mPaint);
                    canvas.drawBitmap(mDrawBitmap, 0, 0, mDrawPaint);
                    break;
                case 2:
                    mBitmapCanvas.drawCircle(x, y,   height, mPaint);
                    canvas.drawBitmap(mDrawBitmap, 0, 0, mDrawPaint);
                    break;
            }

        }
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        touched = true;
        //getting the touched x and y position
        x = event.getX();
        y = event.getY();
        invalidate();
        return true;
    }

    public void setPaintColor(int color){
        mPaint.setColor(color);
    }

    public void setCurrentShape(int shape){
        this.currentShape = shape;
    }
}