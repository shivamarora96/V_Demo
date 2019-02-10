package com.saproductions.vinsoldemo.Acitvity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.saproductions.vinsoldemo.RecyclerUtility.ClickListner;
import com.saproductions.vinsoldemo.Configuration;
import com.saproductions.vinsoldemo.RecyclerUtility.CustomAdapter;
import com.saproductions.vinsoldemo.RecyclerUtility.GridSpacing;
import com.saproductions.vinsoldemo.R;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CustomAdapter adapter;
    ArrayList<Integer> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.rv);

        mData = new ArrayList<>();

        for(int i = 1 ; i<=100 ; i++){
            mData.add(i);
        }

        adapter = new CustomAdapter(MainActivity.this, mData);

        adapter.setOnItemClick(new ClickListner() {
            @Override
            public void onItemClick(int pos) {
                Toast.makeText(MainActivity.this, "Clicked :" + mData.get(pos), Toast.LENGTH_SHORT).show();
                mData.remove(pos);
                adapter.notifyDataSetChanged();

            }
        });


        GridLayoutManager layoutManager = new GridLayoutManager(MainActivity.this, Configuration.CONFIG_GRID_SIZE);
       // GridLayoutManager gridLayoutManager = new GridLayoutManager()


        recyclerView.addItemDecoration(new GridSpacing(Configuration.CONFIG_GRID_SIZE, Configuration.CONFIG_SPACING,true));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

}
