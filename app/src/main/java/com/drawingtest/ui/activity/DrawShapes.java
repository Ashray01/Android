package com.drawingtest.ui.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.drawingtest.R;

public class DrawShapes extends AppCompatActivity {
    ImageView imageview;
    Button linebutton,cirButton,recbutton,squareButton;
    Bitmap bitmap;
    Canvas canvas;
    Paint paint;
    int CanvasRadius;
    int CanvasPadding = 7;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_shapes);

        imageview = (ImageView)findViewById(R.id.imageView1);
        cirButton = (Button)findViewById(R.id.drwCircle);
        squareButton= (Button)findViewById(R.id.drwsquare);
        linebutton = (Button)findViewById(R.id.drwline);
        recbutton = (Button)findViewById(R.id.drwRect);


        cirButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CreateBitmap();

                CreateCanvas();

                CanvasRadius = Math.min(canvas.getWidth(),canvas.getHeight()/2);

                CreatePaint();
                paint.setColor(Color.RED);

                canvas.drawCircle(
                        canvas.getWidth() / 2,
                        canvas.getHeight() / 2,
                        CanvasRadius - CanvasPadding,
                        paint
                );


                imageview.setImageBitmap(bitmap);
            }
        });

        recbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateBitmap();

                CreateCanvas();

                CreatePaint();

                canvas.drawRect(
                        20, 20, 300,400,
                        paint
                );


                imageview.setImageBitmap(bitmap);

            }
        });

        squareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateBitmap();

                CreateCanvas();


                CreatePaint();

                canvas.drawRect(10,10,500,500,paint);
                imageview.setImageBitmap(bitmap);

            }
        });

        linebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateBitmap();

                CreateCanvas();

                CreatePaint();
                paint.setStyle(Paint.Style.FILL);

                canvas.drawLine(20,100,canvas.getWidth(),canvas.getHeight(),paint);

                imageview.setImageBitmap(bitmap);
            }
        });



    }

    public void CreateBitmap(){

        bitmap = Bitmap.createBitmap(
                1080,
                800,
                Bitmap.Config.RGB_565
        );

    }

    public void CreateCanvas(){

        canvas = new Canvas(bitmap);

        canvas.drawColor(Color.BLACK);

    }

    public void CreatePaint(){

        paint = new Paint();

        paint.setStyle(Paint.Style.FILL);

        paint.setColor(Color.BLUE);

        paint.setAntiAlias(true);

    }
}
