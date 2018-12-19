package com.example.gangplank.yuekao;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by GANGPLANK on 2018/10/22.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<Person>list;
    private Context context;

    public void setList(ArrayList<Person> list) {
        this.list = list;
    }

    public MyAdapter(FragmentActivity activity, ArrayList<Person> list) {
        this.context=activity;
        this.list=list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item, null);
        ViewHolder  viewHolder =new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Person person = list.get(position);
        holder.name.setText(person.getName());
        holder.leve1.setText(person.getLeve1());
        Glide.with(context).load(person.getImage_url()).into(holder.image_url);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name,leve1;
        private ImageView image_url;
        public ViewHolder(View itemView) {
            super(itemView);
            name =itemView.findViewById(R.id.name);
            leve1=itemView.findViewById(R.id.leve1);
            image_url=itemView.findViewById(R.id.image_url);
        }
    }
}
