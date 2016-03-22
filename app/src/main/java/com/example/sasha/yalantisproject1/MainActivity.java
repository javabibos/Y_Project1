package com.example.sasha.yalantisproject1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    private RecyclerView.LayoutManager layoutManager;
    public  static View.OnClickListener recycleOnClickListener;
    private static RecyclerView recyclerView;
    private static MyRecyclerViewAdapter myAdapter;
    private ArrayList<Photo> pictureList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(R.string.title);
        actionBar.setDisplayHomeAsUpEnabled(true);

        recycleOnClickListener = new RecycleOnClickListener();

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        pictureList = getPictureData();

        myAdapter = new MyRecyclerViewAdapter(this, pictureList);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem)    {
        onBackPressed();
        return true;
    }

    private ArrayList<Photo> getPictureData() {

        pictureList = new ArrayList<>();
        for (String imageUrl : MyPicturesData.urls)  {
            pictureList.add(new Photo(imageUrl));
        }
        return pictureList;
    }

    protected class RecycleOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            int selectedArticleUrl = getSelectedArticleUrl(view);
            Toast.makeText(MainActivity.this, "image_" + selectedArticleUrl, Toast.LENGTH_SHORT).show();
        }
    }

    private int getSelectedArticleUrl(View view) {
        int selectedItemPosition = recyclerView.getChildAdapterPosition(view);
        return selectedItemPosition;
    }

    public void onClickButton(View view)    {
        Toast.makeText(this, "Button", Toast.LENGTH_SHORT).show();
    }

    public void onClickTextView(View view)    {
        Toast.makeText(this, "TextView", Toast.LENGTH_SHORT).show();
    }

}
