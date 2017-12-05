package com.auribises.activitydemo;

import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class AllUsersActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    @InjectView(R.id.listView)
    ListView listView;

    ArrayAdapter<String> adapter;

    ArrayList<User> userArrayList;

    ContentResolver resolver;

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_users);

        ButterKnife.inject(this);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);

        resolver = getContentResolver();

        retrieveFromDB();
    }

    void retrieveFromDB(){

        String[] projection = {Util.COL_ID,Util.COL_NAME,Util.COL_PHONE,Util.COL_PASSWORD};

        Cursor cursor = resolver.query(Util.uri,projection,null,null,null);

        int id = 0;
        String nm="", ph="", pwd="";

        userArrayList = new ArrayList<>();

        while (cursor.moveToNext()){
            id = cursor.getInt(cursor.getColumnIndex(Util.COL_ID));
            nm = cursor.getString(cursor.getColumnIndex(Util.COL_NAME));
            ph = cursor.getString(cursor.getColumnIndex(Util.COL_PHONE));
            pwd = cursor.getString(cursor.getColumnIndex(Util.COL_PASSWORD));

            User user = new User(id,nm,ph,pwd);
            userArrayList.add(user);

            adapter.add(id+"  -  "+nm+"\n"+ph);
        }

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    void showOptions(){
        String[] items = {"View","Delete","Update"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i){
                    case 0:

                        Intent intent = new Intent(AllUsersActivity.this,ShowUserActivity.class);
                        intent.putExtra("keyUser",user);
                        startActivity(intent);

                        break;

                    case 1:

                        break;

                    case 2:

                        break;
                }
            }
        });
        builder.create().show();
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        user = userArrayList.get(i);
        Toast.makeText(this,"You Selected: "+user.name,Toast.LENGTH_LONG).show();

        showOptions();

    }
}
