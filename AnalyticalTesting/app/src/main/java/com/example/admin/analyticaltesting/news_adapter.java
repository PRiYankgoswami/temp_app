package com.example.admin.analyticaltesting;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class news_adapter extends RecyclerView.Adapter<news_adapter.MyViewHolder>
{

    private List<news_class> data;

    public news_adapter(List<news_class> data1)
    {
        this.data = data1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView date,time,title,body;

        public MyViewHolder(View view)
        {
            super(view);
            date=(TextView)view.findViewById(R.id.news_date);
            time=(TextView)view.findViewById(R.id.news_time);
            title=(TextView)view.findViewById(R.id.news_title);
            body=(TextView)view.findViewById(R.id.news_body);
        }
    }

    @NonNull
    @Override
    public news_adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View iv= LayoutInflater.from(parent.getContext()).inflate(R.layout.news_feed_layout,parent,false);
        return new MyViewHolder(iv);
    }

    @Override
    public void onBindViewHolder(@NonNull news_adapter.MyViewHolder holder, int position)
    {
        final news_class n_c=data.get(position);
        holder.body.setText(n_c.news_body);
        holder.title.setText(n_c.news_title);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
