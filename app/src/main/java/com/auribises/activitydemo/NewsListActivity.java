package com.auribises.activitydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NewsListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    //ListView listView;
    //GridView gridView;

    RecyclerView recyclerView;

    //ArrayAdapter<String> newsAdapter;

    ArrayList<NewsModel> newsList;
    NewsAdapter newsAdapter;
    NewsRecyclerAdapter recyclerAdapter;

    void initViews(){
        //listView = (ListView)findViewById(R.id.listView);
        //gridView = (GridView)findViewById(R.id.gridView);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        newsList = new ArrayList<>();

        NewsModel n1 = new NewsModel(R.drawable.sunny,"CNBC","Worlds Leading News");
        NewsModel n2 = new NewsModel(R.drawable.sunny,"AAJ TAK","Worlds Leading News");
        NewsModel n3 = new NewsModel(R.drawable.sunny,"BBC","Worlds Leading News");
        NewsModel n4 = new NewsModel(R.drawable.sunny,"NDTV","Worlds Leading News");

        newsList.add(n1);
        newsList.add(n2);
        newsList.add(n3);
        newsList.add(n4);

        //newsAdapter = new NewsAdapter(this,R.layout.list_item,newsList);
        recyclerAdapter = new NewsRecyclerAdapter(this,R.layout.list_item,newsList);
        //listView.setAdapter(newsAdapter);
        //listView.setOnItemClickListener(this);

        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //recyclerView.setLayoutManager(linearLayoutManager);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.setAdapter(recyclerAdapter);

        //gridView.setAdapter(newsAdapter);
        //gridView.setOnItemClickListener(this);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);

        initViews();


        /*
        listView = (ListView)findViewById(R.id.listView);
        newsAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        newsAdapter.add("AajTak"); //0
        newsAdapter.add("ZeeNews");
        newsAdapter.add("DD News");
        newsAdapter.add("CNBC");
        newsAdapter.add("Tez");
        newsAdapter.add("NDTV");   //n-1

        listView.setAdapter(newsAdapter);
        listView.setOnItemClickListener(this);*/
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
