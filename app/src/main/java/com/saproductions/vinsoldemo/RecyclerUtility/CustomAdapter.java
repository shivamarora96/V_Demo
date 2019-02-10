package com.saproductions.vinsoldemo.RecyclerUtility;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.os.Handler;

import com.saproductions.vinsoldemo.Configuration;
import com.saproductions.vinsoldemo.R;
import com.wajahatkarim3.easyflipview.EasyFlipView;

import java.util.ArrayList;

/**
 * Created by shivam on 9/2/19.
 */

public class CustomAdapter extends RecyclerView.Adapter<ViewHolder> {

    private ArrayList<Integer> mData;
    static ClickListner listner;
    Context context;

    public CustomAdapter(Context c,ArrayList<Integer> mData) {
        this.mData = mData;
        context = c;
    }

    public ArrayList<Integer> getmData() {
        return mData;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.childlayout, parent, false);

        return new ViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
//
        final EasyFlipView mFV = holder.fv;
        TextView textView = holder.tv;
        textView.setText("" + mData.get(position));
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFV.setFlipDuration(Configuration.CONFIG_ANIMATION_SPEED);
                mFV.setAutoFlipBack(true);
                mFV.setAutoFlipBackTime(Configuration.CONFIG_ANIMATION_SPEED/2);
                mFV.setFlipTypeFromBack();
                mFV.flipTheView();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        listner.onItemClick(position);
                    }
                }, (long) (2.5*(Configuration.CONFIG_ANIMATION_SPEED)));

                //setAnimation_Left_in(holder.itemView);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public void setOnItemClick(ClickListner l){
        Log.i("TAG", "Iside CustomAdapterONCLICK");
        CustomAdapter.listner = l;
        Log.i("TAG", CustomAdapter.listner.toString());

    }


    private void setAnimation_Left_in(View view) {
        Animation zoomIn = AnimationUtils.loadAnimation(context, R.anim.flip);// animation file
        zoomIn.setDuration(Configuration.CONFIG_ANIMATION_SPEED);
//        view.startAnimation(zoomIn);
    }


}


