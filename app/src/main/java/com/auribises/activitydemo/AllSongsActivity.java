package com.auribises.activitydemo;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;

public class AllSongsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView listView;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_songs);


        listView = (ListView)findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);

        readSDCard();
    }

    void readSDCard(){

        try{

            String path = Environment.getExternalStorageDirectory().getAbsolutePath();
            File file = new File(path);

            if(file.exists()){
                String[] fileNames = file.list();
                for(String s : fileNames){
                    if(s.endsWith(".mp3"))
                        adapter.add(s);
                }

                listView.setAdapter(adapter);
                listView.setOnItemClickListener(this);
            }


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        String songName = adapter.getItem(i);
        Intent intent = new Intent(AllSongsActivity.this,PlaySongActivity.class);
        intent.putExtra("keySong",songName);
        startActivity(intent);


    }
}
