package com.auribises.activitydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class NewsListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView listView;
    ArrayAdapter<String> newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);

        listView = (ListView)findViewById(R.id.listView);

        newsAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        newsAdapter.add("AajTak"); //0
        newsAdapter.add("ZeeNews");
        newsAdapter.add("DD News");
        newsAdapter.add("CNBC");
        newsAdapter.add("Tez");
        newsAdapter.add("NDTV");   //n-1

        listView.setAdapter(newsAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Intent intent = new Intent(NewsListActivity.this,NewsActivity.class);

        switch (i){
            case 0:
                //Toast.makeText(this,"You Selected AajTak",Toast.LENGTH_LONG).show();
                intent.putExtra("newsUrlKey","https://aajtak.intoday.in/");
                break;

            case 1:
                intent.putExtra("newsUrlKey","http://zeenews.india.com/");
                break;
        }


        startActivity(intent);
    }
}
