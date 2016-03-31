package com.example.sasha.y_project1_lastupdated;

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
    private int screenWidth;        // for getting image size
    private int activityMargin;     // for getting image size
    private int imageRightMargin;   // for getting image size

    public MyRecyclerViewAdapter(Context context, List<Photo> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
        screenWidth = context.getResources().getDisplayMetrics().widthPixels;                       //
        activityMargin = (int) context.getResources().getDimension(R.dimen.activity_margin);        // for getting image size
        imageRightMargin = (int) context.getResources().getDimension(R.dimen.image_right_margin);   //
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.row_layout, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {

        //find image side size
        int imageSideSize = (screenWidth - 2*activityMargin - imageRightMargin)/2;

        Photo current = data.get(i);
        Uri uri = Uri.parse(current.imageUrl);
        Context context = myViewHolder.aImage.getContext();
        Picasso.with(context).load(uri)
                .resize(imageSideSize, imageSideSize)
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
