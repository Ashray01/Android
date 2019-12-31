package com.drawingtest.ui.component;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.NumberPicker;

import com.drawingtest.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import butterknife.OnClick;

public class GridView extends View {


    private int numCol, numRows;
    private int cellWidth, cellHeight;
    private Paint gPaint = new Paint();
    private boolean[][] valCell;
    List<String> list = new ArrayList<String>();
    List<String> maxList = new ArrayList<String>();
    List<String> sublist= new ArrayList<String>();
    HashMap<Integer, String> hm = new HashMap<Integer, String>();

    public GridView(Context context){
        this (context,null);
    }

    public GridView(Context context, AttributeSet attrs) {
        super(context,attrs);
        gPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    public void setNumCol(int numCol) {
        this.numCol = numCol;
        calculateDimensions();
    }

    public int getNumCol() {
        return numCol;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
        calculateDimensions();
    }

    public int getNumRows() {
        return numRows;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldWidth, int oldHeight) {
        super.onSizeChanged(w, h, oldWidth, oldHeight);
        calculateDimensions();
    }

    private void calculateDimensions() {
        if (numCol < 1 || numRows < 1) {
            return;
        }

        cellWidth = 120;
        cellHeight = 120;

        valCell = new boolean[numCol][numRows];

        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
      Paint  paint = new Paint(Color.WHITE);
        gPaint.setColor(Color.YELLOW);
        canvas.drawColor(Color.WHITE);


        if (numCol == 0 || numRows == 0) {
            return;
        }

        for (int c = 0; c < numCol; c++) {
            int answer;
            String ans = "";
            String i= "";
            for (int r = 0; r < numRows; r++) {
                Random rn = new Random();
                answer = rn.nextInt(9) + 1;
                ans= String.valueOf(answer);

                    Rect rectangle= new Rect(c * cellWidth, r * cellHeight,
                            (c + 1) * cellWidth, (r + 1) * cellHeight);
                    canvas.drawRect(rectangle,
                            paint);
               Paint paints = new Paint();
                paint.setStyle(Paint.Style.FILL);

                paints.setColor(Color.RED);
                paints.setAntiAlias(true);
                paints.setTextSize(60);
                paints.setTextAlign(Paint.Align.CENTER);
                Typeface typeface = Typeface.create(Typeface.SANS_SERIF,Typeface.BOLD_ITALIC);
                paints.setTypeface(typeface);
                paints.getTextBounds(
                        ans,
                        0,
                        ans.length(),
                        rectangle
                );
                canvas.drawText(
                        ans,
                        ((c + 1) * cellWidth)-50,
                        ((r + 1) * cellHeight) -50 ,
                        paints
                );
                list.add(ans);








            }



        }
        int size = numCol;
        for (int start = 0; start < list.size(); start += size) {
            int end = Math.min(start + size, list.size());
            sublist = list.subList(start, end);
            maxList.add(Collections.max(sublist));
            //System.out.println(sublist);


        }
        //maxList.add(Collections.max(sublist));
        System.out.println(maxList);
        //System.out.println(list);





        for (int c = 0; c < numCol + 1; c++) {
            canvas.drawLine(c * cellWidth, 0, c * cellWidth, numCol*120, gPaint);
            canvas.drawLine(0, c * cellHeight, numRows*120, c*cellHeight,gPaint );
        }




    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int touchX = (int) event.getX();
        int touchY = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                float posX= event.getX();
                float posY = event.getY();

                float x1= cellWidth, x2= cellHeight, y1= cellWidth, y2=cellHeight;
                for (int c = 0; c < numCol; c++) {
                    for (int r = 0; r < numRows; r++){
                        if (posX >= (c*x1) && posX >= (r*x2) && (posY >= (c*y1) && posY >= (r*y2) )) {
                            System.out.println("Touching down!");



                        }



                    }




                }




            case MotionEvent.ACTION_UP: {
                break;
            }

            case MotionEvent.ACTION_MOVE: {
                break;
            }

            default:
                throw new IllegalStateException("Unexpected value: " + event.getAction());
        }
        return true;
    }

    }




