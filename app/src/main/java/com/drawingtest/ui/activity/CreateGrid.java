package com.drawingtest.ui.activity;


import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.drawingtest.R;

import java.util.ArrayList;
import java.util.List;

public class CreateGrid extends AppCompatActivity {



    public static  String globalPreferenceName="preferenceName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_grid);

        final SharedPreferences.Editor editor= getSharedPreferences(globalPreferenceName,MODE_PRIVATE).edit();



        final SeekBar volumeControl = (SeekBar) findViewById(R.id.VolumeControl);

        volumeControl.setProgress(4);
        volumeControl.setMax(9);

        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChanged = 0;


            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChanged = progress + 1;
                editor.putInt("seekBarProgress",progressChanged);
                editor.commit();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateGrid.this, "You have chosen: " + progressChanged +" rows and column", Toast.LENGTH_SHORT)
                        .show();


            }


        });



        final Spinner spinControl = (Spinner) findViewById(R.id.SpinControl);
        final Button spinSubmit = (Button) findViewById(R.id.SpinSubmit);

        List<String> rows = new ArrayList<String>();
        rows.add("Blue");
        rows.add("Red");
        rows.add("Black");
        rows.add("Light_Blue");
        rows.add("Yellow");
        rows.add("White");

        ArrayAdapter<String> daRow = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, rows);
        daRow.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinControl.setAdapter(daRow);

        spinSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CreateGrid.this, "You have chosen the color: "+ String.valueOf(spinControl.getSelectedItem()) +" as you favourite color choice ", Toast.LENGTH_SHORT).show();
            }
        });

        final ListView LVControl = (ListView) findViewById(R.id.LVControl);

        List<String> cols = new ArrayList<String>();
        cols.add("Col-1");
        cols.add("Col-2");
        cols.add("Col-3");
        cols.add("Col-4");

        final ArrayAdapter<String> daCol = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cols);
        daCol.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        LVControl.setAdapter(daCol);

        LVControl.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(CreateGrid.this, "Chose: " + String.valueOf(daCol.getItem(position)), Toast.LENGTH_SHORT).show();
            }
        });

        Button gridbutton= (Button) findViewById(R.id.btndrawgrid);
        gridbutton.setOnClickListener(new View. OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
                System.out.println("Clicked");

            }
        });

    }



    public void openActivity2(){

        Intent intent1 = new Intent(this,DisplayGrid.class);

        startActivity(intent1);
    }


}

