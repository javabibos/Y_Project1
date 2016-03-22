package com.example.sasha.yalantisproject1;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    private List<Photo> data = Collections.emptyList();
    private LayoutInflater inflater;

    public MyRecyclerViewAdapter(Context context, List<Photo> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.row_layout, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        Photo current = data.get(i);
        Uri uri = Uri.parse(current.imageUrl);
        Context context = myViewHolder.aImage.getContext();
        Picasso.with(context).load(uri)
                .resize(300, 300)
                .into(myViewHolder.aImage);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView aImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            aImage = (ImageView) itemView.findViewById(R.id.imageViewRicycle);
            itemView.setOnClickListener(MainActivity.recycleOnClickListener);
        }
    }
}
