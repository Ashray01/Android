package com.drawingtest.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.drawingtest.R;

public class Login extends AppCompatActivity {

    RelativeLayout rellay1, rellay2;
    EditText uname,pword;
    Button btn;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rellay1.setVisibility(View.VISIBLE);
            rellay2.setVisibility(View.VISIBLE);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        rellay1 = (RelativeLayout) findViewById(R.id.rellay1);
        rellay2 = (RelativeLayout) findViewById(R.id.rellay2);
        uname = (EditText) findViewById(R.id.username);
        pword =(EditText) findViewById(R.id.password);
        btn= (Button) findViewById(R.id.login_btn);



        handler.postDelayed(runnable, 2000);




    }


    public void newActivity(View view) {

        String getName= uname.getText().toString();
        String getPassword= pword.getText().toString();

        if (getName.equals("") || getPassword.equals("")){
            Toast.makeText(getBaseContext(),"Please fill out all the fields",Toast.LENGTH_SHORT).show();
            Toast.makeText(getBaseContext(),"Incorrect Username or Password",Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent = new Intent(Login.this, MainMenu.class);
            startActivity(intent);
        }

    }

    public void Signup(View view) {
        Intent intent = new Intent(Login.this,CreateAccount.class);
        startActivity(intent);
    }
}
