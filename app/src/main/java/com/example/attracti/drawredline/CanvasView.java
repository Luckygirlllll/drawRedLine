package com.example.attracti.drawredline;

/**
 * Created by attracti on 4/4/16.
 */
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * Created by Iryna on 4/1/16.
 */

public class CanvasView extends View {
    public Paint mPaint;
    public static Canvas mCanvas;
    private int startX = 100;
    private int startY =100;
    private int stopX = 500;
    private int stopY = 500;

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
    }

    //constructor
    public CanvasView(Context context) {
        super(context);
        mPaint = new Paint();
    }

    public void drawLine() {
        Random random = new Random();
        startX = random.nextInt(stopX - startX);
        startY = random.nextInt(stopY-startX);
        //important. Refreshes the view by calling onDraw function
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        mCanvas = canvas;
        super.onDraw(mCanvas);
        canvas.drawColor(Color.YELLOW);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
        canvas.drawLine(startX, startY, stopX, stopY, mPaint);
    }
}
