package com.auribises.activitydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class HomeActivity extends AppCompatActivity {

    EditText eTxtName, eTxtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        eTxtName = (EditText)findViewById(R.id.editText);
        eTxtEmail = (EditText)findViewById(R.id.editText2);

        Intent rcv = getIntent();
        String name = rcv.getStringExtra("keyName");
        String email = rcv.getStringExtra("keyEmail");

        eTxtName.setText(name);
        eTxtEmail.setText(email);
    }

    public void goBack(View view){
        finish();
    }
}
