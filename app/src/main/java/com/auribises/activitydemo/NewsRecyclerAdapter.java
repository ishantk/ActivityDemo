package com.auribises.activitydemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ishantkumar on 13/11/17.
 */

public class NewsRecyclerAdapter extends RecyclerView.Adapter<NewsRecyclerAdapter.ViewHolder> {


    Context context;
    int resource;
    ArrayList<NewsModel> objects;

    public NewsRecyclerAdapter(Context context, int resource, ArrayList<NewsModel> objects) {

        this.context = context;
        this.resource = resource;
        this.objects = objects;

    }

    @Override
    public NewsRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //1.
        View view = LayoutInflater.from(context).inflate(resource,parent,false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(NewsRecyclerAdapter.ViewHolder holder, int position) {
        //3.
        NewsModel news = objects.get(position);

        holder.img.setBackgroundResource(news.getImage());
        holder.txtName.setText(news.getName());
        holder.txtDes.setText(news.getDescription());
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView txtName;
        TextView txtDes;

        public ViewHolder(View itemView) {
            super(itemView);

            //2.
            img = (ImageView)itemView.findViewById(R.id.imageViewIcon);
            txtName = (TextView)itemView.findViewById(R.id.textViewName);
            txtDes = (TextView)itemView.findViewById(R.id.textViewDescription);

        }
    }
}
