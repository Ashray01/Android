package com.drawingtest.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.drawingtest.R;

public class Calculator extends AppCompatActivity {

    double num1,num2;
    TextView input0;
    Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button0, Add, Subtract,Division,Multiply, CE, Equal;
    boolean add1,sub,div,mul,ret,del;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        input0= (TextView) findViewById(R.id.input0);
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        Add = (Button) findViewById(R.id.Add);
        Subtract= (Button) findViewById(R.id.Substract);
        Multiply= (Button) findViewById(R.id.Multiply);
        Division= (Button) findViewById(R.id.Division);
        CE= (Button) findViewById(R.id.delete);
        Equal= (Button) findViewById(R.id.Equal);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input0.setText(input0.getText() + "0");

            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input0.setText(input0.getText() + "1");

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input0.setText(input0.getText() + "2");

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input0.setText(input0.getText() + "3");

            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input0.setText(input0.getText() + "4");

            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input0.setText(input0.getText() + "5");

            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input0.setText(input0.getText() + "6");

            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input0.setText(input0.getText() + "7");

            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input0.setText(input0.getText() + "8");

            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input0.setText(input0.getText() + "9");

            }
        });


        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input0.getText().length() !=0){
                    num1=Float.parseFloat(input0.getText() + "");
                    add1=true;
                    input0.setText(null);

                }

            }
        });

        Subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input0.getText().length() !=0 ){
                    num1=Float.parseFloat(input0.getText() + "");
                    sub=true;
                    input0.setText(null);
                }

            }
        });
        Division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input0.getText().length() !=0 ){
                    num1=Float.parseFloat(input0.getText() + "");
                    div=true;
                    input0.setText(null);
                }

            }
        });
        Multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input0.getText().length() !=0 ){
                    num1=Float.parseFloat(input0.getText() + "");
                    mul=true;
                    input0.setText(null);
                }

            }
        });
        CE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input0.setText("");
                num1=0.0;
                num2=0.0;

            }
        });

        Equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(add1 || sub|| div|| mul){
                    num2=Float.parseFloat(input0.getText()+"");
                }
                if(add1){
                    input0.setText(num1 + num2+ "");
                    add1=false;
                }
                if(sub){
                    input0.setText(num1 - num2 + "");
                    sub=false;
                }

                if(div){
                    input0.setText(num1 / num2 + "");
                    div=false;
                }

                if(mul){
                    input0.setText(num1 * num2 + "");
                    mul=false;
                }
            }

        });

    }
}
