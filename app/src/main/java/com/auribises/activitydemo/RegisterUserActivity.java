package com.auribises.activitydemo;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

    User uRef,rcvUser;
    ContentValues values;
    ContentResolver resolver;

    boolean updateMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        ButterKnife.inject(this);

        btnSubmit.setOnClickListener(this);

        uRef = new User();

        resolver = getContentResolver();

        Intent rcv = getIntent();

        updateMode = rcv.hasExtra("keyUser");

        if(updateMode){

            btnSubmit.setText("Update User");

            rcvUser = (User) rcv.getSerializableExtra("keyUser");

            eTxtName.setText(rcvUser.name);
            eTxtPhone.setText(rcvUser.phone);
            eTxtPassword.setText(rcvUser.password);

        }

    }

    void registerUser(){

        values = new ContentValues();

        values.put(Util.COL_NAME,uRef.name);
        values.put(Util.COL_PHONE,uRef.phone);
        values.put(Util.COL_PASSWORD,uRef.password);

        if(updateMode){

            String where = Util.COL_ID+" = "+rcvUser.id;
            int i = resolver.update(Util.uri,values,where,null);
            Toast.makeText(this,uRef.name+" updated successfully !! "+i,Toast.LENGTH_LONG).show();
            finish();

        }else{
            Uri uri = resolver.insert(Util.uri,values);
            Toast.makeText(this,uRef.name+" registered successfully !! "+uri.getLastPathSegment(),Toast.LENGTH_LONG).show();

            clearFields();
        }




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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        if(!updateMode)
            getMenuInflater().inflate(R.menu.menu_users,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.users){
            Intent intent = new Intent(RegisterUserActivity.this,AllUsersActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
