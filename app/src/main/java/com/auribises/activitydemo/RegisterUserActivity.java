package com.auribises.activitydemo;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class RegisterUserActivity extends AppCompatActivity implements View.OnClickListener{


    @InjectView(R.id.editTextName)
    EditText eTxtName;

    @InjectView(R.id.editTextPhone)
    EditText eTxtPhone;

    @InjectView(R.id.editTextPassword)
    EditText eTxtPassword;

    @InjectView(R.id.buttonRegister)
    Button btnSubmit;

    User uRef;
    ContentValues values;
    ContentResolver resolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        ButterKnife.inject(this);

        btnSubmit.setOnClickListener(this);

        uRef = new User();

        resolver = getContentResolver();

    }

    void registerUser(){

        values = new ContentValues();

        values.put(Util.COL_NAME,uRef.name);
        values.put(Util.COL_PHONE,uRef.phone);
        values.put(Util.COL_PASSWORD,uRef.password);

        Uri uri = resolver.insert(Util.uri,values);
        Toast.makeText(this,uRef.name+" registered successfully !! "+uri.getLastPathSegment(),Toast.LENGTH_LONG).show();

        clearFields();

    }
    void clearFields(){
        eTxtName.setText("");
        eTxtPhone.setText("");
        eTxtPassword.setText("");
    }


    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.buttonRegister){

            uRef.name = eTxtName.getText().toString().trim();
            uRef.phone = eTxtPhone.getText().toString().trim();
            uRef.password = eTxtPassword.getText().toString().trim();

            registerUser();

        }
    }
}