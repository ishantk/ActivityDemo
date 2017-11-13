package com.auribises.activitydemo;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ishantkumar on 10/11/17.
 */

public class NewsAdapter extends ArrayAdapter<NewsModel> {

    Context context;
    int resource;
    ArrayList<NewsModel> objects;

    public NewsAdapter(Context context, int resource, ArrayList<NewsModel> objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        this.objects = objects;

    }

    // Binding the data from Object on list item
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        //1.
        View view = LayoutInflater.from(context).inflate(resource,parent,false);

        //2.
        ImageView img = (ImageView)view.findViewById(R.id.imageViewIcon);
        TextView txtName = (TextView)view.findViewById(R.id.textViewName);
        TextView txtDes = (TextView)view.findViewById(R.id.textViewDescription);

        //3.
        NewsModel news = objects.get(position);

        img.setBackgroundResource(news.getImage());
        txtName.setText(news.getName());
        txtDes.setText(news.getDescription());

        return view;
    }
}
