package com.auribises.activitydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText eTxtName, eTxtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("MainActvity - onCreate");
        Log.i("MainActivty","onCreate");
        Toast.makeText(this,"MainActvity - onCreate",Toast.LENGTH_LONG).show();

        eTxtName = (EditText)findViewById(R.id.editText);
        eTxtEmail = (EditText)findViewById(R.id.editText2);
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("MainActvity - onStart");
        Log.i("MainActivty","onStart");
        Toast.makeText(this,"MainActvity - onStart",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("MainActvity - onResume");
        Log.i("MainActivty","onResume");
        Toast.makeText(this,"MainActvity - onResume",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("MainActvity - onPause");
        Log.i("MainActivty","onPause");
        Toast.makeText(this,"MainActvity - onPause",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("MainActvity - onStop");
        Log.i("MainActivty","onStop");
        Toast.makeText(this,"MainActvity - onStop",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("MainActvity - onDestroy");
        Log.i("MainActivty","onDestroy");
        Toast.makeText(this,"MainActvity - onDestroy",Toast.LENGTH_LONG).show();
    }

    public void clickHandler(View view){

        String name = eTxtName.getText().toString().trim();
        String email = eTxtEmail.getText().toString().trim();

        Toast.makeText(this,"You Clicked Button: "+name+" - "+email,Toast.LENGTH_LONG).show();

        Intent intent = new Intent(MainActivity.this,HomeActivity.class);
        intent.putExtra("keyName",name);
        intent.putExtra("keyEmail",email);
        startActivity(intent);
    }
}
