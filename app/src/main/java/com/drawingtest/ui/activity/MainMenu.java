package com.drawingtest.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.drawingtest.R;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void CreateCanvas(View view) {
        Intent intent = new Intent(MainMenu.this,MainActivity.class);
        startActivity(intent);
    }

    public void CreateGrid(View view) {
        Intent intent = new Intent(MainMenu.this,CreateGrid.class);
        startActivity(intent);
    }


    public void Shapes(View view) {
        Intent intent = new Intent(MainMenu.this,DrawShapes.class);
        startActivity(intent);

    }
}


