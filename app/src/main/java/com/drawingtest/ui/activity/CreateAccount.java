package com.drawingtest.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.drawingtest.R;

public class CreateAccount extends AppCompatActivity {

    EditText getName,getEmailAddress,getPhone,getPassword,confirmPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        getName= (EditText) findViewById(R.id.fullname);
        getPhone= (EditText) findViewById(R.id.number);
        getEmailAddress= (EditText) findViewById(R.id.email);
        getPassword= (EditText) findViewById(R.id.pass1);
        confirmPassword= (EditText) findViewById(R.id.pass2);

    }

    public void createAcc(View view) {

        String name= getName.getText().toString();
        String phone= getPhone.getText().toString();
        String email= getEmailAddress.getText().toString();
        String pass1= getPassword.getText().toString();
        String pass2= confirmPassword.getText().toString();


        if( name.equals("") || phone.equals("") || email.equals("") || pass1.equals("") || pass2.equals("") ){
            Toast.makeText(getBaseContext(),"Please fill out all the fields",Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent = new Intent(CreateAccount.this,Login.class);
            startActivity(intent);
        }
    }
}

