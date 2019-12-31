package com.drawingtest.ui.activity;
import com.drawingtest.ui.component.GridView;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.drawingtest.R;

public class DisplayGrid extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_main);
        LinearLayout layout= (LinearLayout) findViewById(R.id.layout);
        TextView txt= (TextView) findViewById(R.id.txt);
        GridView pixelGrid= new GridView(this);
        SharedPreferences sharedPreferences= getSharedPreferences(CreateGrid.globalPreferenceName,MODE_PRIVATE);



        int rowData= sharedPreferences.getInt("seekBarProgress", 7);
        pixelGrid.setNumCol(rowData);
        pixelGrid.setNumRows(rowData);
        layout.addView(pixelGrid);
        txt.setText("You have chosen the following " + rowData + " numbers of rows and columns");




    }


    }

