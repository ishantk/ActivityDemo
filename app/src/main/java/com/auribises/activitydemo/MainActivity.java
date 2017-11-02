package com.auribises.activitydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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

        int n1 = Integer.parseInt(name);
        int n2 = Integer.parseInt(email);

        int n3 = n1+n2;

        int age = 20;

        Toast.makeText(this,"You Clicked Button: "+name+" - "+email,Toast.LENGTH_LONG).show();

        // Forward Passing

        /*Intent intent = new Intent(MainActivity.this,HomeActivity.class);
        intent.putExtra("keyName",name);
        intent.putExtra("keyEmail",email);
        intent.putExtra("keyAge",age);

        startActivity(intent);*/

        // Explicit Way
        //Intent intent = new Intent(MainActivity.this,HomeActivity.class);

        // Implicit Intent
        Intent intent = new Intent("com.auribises.activitydemo.homeactivity");

        intent.putExtra("keyResult",n3);
        startActivityForResult(intent,101); // we are expecting data in MainActivity from HomeActivity
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 101 && resultCode == 201){
            String nm = data.getStringExtra("keyName");
            String em = data.getStringExtra("keyEmail");

            eTxtName.setText(nm);
            eTxtEmail.setText(em);
        }
    }

    // Create menu in Android
    // Explicit Way
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
                // gid, itemid, order, name
        /*menu.add(0,101,0,"All Songs");
        menu.add(0,2,0,"Favourites");
        menu.add(0,333,0,"Artists");
        menu.add(0,4,0,"Play Lists");*/

        getMenuInflater().inflate(R.menu.menu_main,menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        //int gid = item.getGroupId();

        switch (id){
            /*case 101:
                Toast.makeText(this,"You Selected All Songs",Toast.LENGTH_LONG).show();
                break;

            case 2:

                break;

            case 333:

                break;

            case 4:

                break;*/

            case R.id.add:

                break;

            case R.id.remove:
                Toast.makeText(this,"You Removed Employee",Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
