package com.auribises.activitydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class HomeActivity extends AppCompatActivity {

    EditText eTxtName, eTxtEmail;
    String name, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        eTxtName = (EditText)findViewById(R.id.editText);
        eTxtEmail = (EditText)findViewById(R.id.editText2);

        Intent rcv = getIntent();

//        String name = rcv.getStringExtra("keyName");
//        String email = rcv.getStringExtra("keyEmail");
//        int age = rcv.getIntExtra("keyAge",0);

        int result = rcv.getIntExtra("keyResult",0);

        eTxtName.setText("Result is: "+result);
        eTxtEmail.setText("");
    }

    public void goBack(View view){

        name = eTxtName.getText().toString().trim();
        email = eTxtEmail.getText().toString().trim();

        Intent data = new Intent();
        data.putExtra("keyName",name);
        data.putExtra("keyEmail",email);

        setResult(201,data);

        finish();
    }
}
