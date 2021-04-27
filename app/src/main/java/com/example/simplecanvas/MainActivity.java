package com.example.simplecanvas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Canvas mCanvas;
    private Paint mPaint=new Paint();
    private Paint mPaintText=new Paint(Paint.UNDERLINE_TEXT_FLAG);
    private Bitmap mBitmap;
    private ImageView mImageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView=findViewById(R.id.my_imageview);
        mPaint.setColor(Color.YELLOW);
        mPaintText.setColor(ResourcesCompat.getColor(getResources(),R.color.white, null));
        mPaintText.setTextSize(20);
    }

    public void drawTriangle(Canvas canvas, Paint paint, int x, int y, int width) {
        int halfWidth = width / 2;

        Path path = new Path();
        path.moveTo(x, y - halfWidth); // Top
        path.lineTo(x - halfWidth, y + halfWidth); // Bottom left
        path.lineTo(x + halfWidth, y + halfWidth); // Bottom right
        path.lineTo(x, y - halfWidth); // Back to Top
        path.close();

        canvas.drawPath(path, paint);
    }

    public void drawSomething(View view) {
        int vWidth=view.getWidth();
        int vHeight=view.getHeight();
        mBitmap=Bitmap.createBitmap(vWidth,vHeight,Bitmap.Config.ARGB_8888);
        mImageView.setImageBitmap(mBitmap);
        mCanvas=new Canvas(mBitmap);

        //roof
        mPaint.setColor(Color.YELLOW);
        drawTriangle(mCanvas, mPaint, 350, 300, 500);

        //wall
        mPaint.setColor(Color.RED);
        Rect mRect = new Rect();
        mRect.set(100,550,600,1050);
        mCanvas.drawRect(mRect,mPaint);;

        //outline_windows
        mPaint.setColor(Color.GREEN);
        mCanvas.drawCircle(225, 800, 80, mPaint);

        //window
        mPaint.setColor(Color.CYAN);
        mCanvas.drawCircle(225, 800, 70, mPaint);

        //partition_window
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(5);
        mCanvas.drawLine(155,800,295,800,mPaint);

        //outline
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(5);
        mCanvas.drawLine(225,730,225,870,mPaint);

        //outline_door
        mPaint.setColor(Color.MAGENTA);
        Rect mRect2 = new Rect();
        mRect2.set(350,700,550,1050);
        mCanvas.drawRect(mRect2,mPaint);

        //door
        mPaint.setColor(Color.LTGRAY);
        Rect mRect3 = new Rect();
        mRect3.set(360,710,540,1050);
        mCanvas.drawRect(mRect3,mPaint);

        //handle_door
        mPaint.setColor(Color.YELLOW);
        mCanvas.drawCircle(380, 880, 10, mPaint);

        //cimney
        mPaint.setColor(Color.YELLOW);
        Rect mRect4 = new Rect();
        mRect4.set(500,50,600,550);
        mCanvas.drawRect(mRect4,mPaint);;

        mCanvas.drawText("Hubertus Rino Augenio",350,620, mPaintText);
        mCanvas.drawText("19/441226/SV/16578",350,650, mPaintText);

//        //canvas
//        mCanvas.drawColor(Color.GREEN);

//
//        //garis
//        mPaint.setColor(Color.BLUE);
//        mPaint.setStrokeWidth(5);
//        mCanvas.drawLine(100,100,300,200,mPaint);
//
//        //rectangle
//        mPaint.setColor(Color.RED);
//        Rect mRect = new Rect();
//        mRect.set(100,200,300,400);
//        mCanvas.drawRect(mRect,mPaint);;
//        mPaint.setColor(Color.YELLOW);
//
//        //circle
//        mCanvas.drawCircle(200,500,100,mPaint);
//
//        Path path=new Path();
//        path.moveTo(100,600);
//        path.lineTo(300,750);
//        path.lineTo(500,650);
//        path.lineTo(700,800);
//        mPaint.setColor(Color.MAGENTA);
//        mCanvas.drawPath(path,mPaint);
//
//        view.invalidate();
    }
}