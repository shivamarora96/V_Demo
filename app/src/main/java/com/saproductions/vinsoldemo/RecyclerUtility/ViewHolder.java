package com.saproductions.vinsoldemo.RecyclerUtility;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.saproductions.vinsoldemo.R;
import com.wajahatkarim3.easyflipview.EasyFlipView;

public class ViewHolder extends RecyclerView.ViewHolder{

    public TextView tv;
    public EasyFlipView fv;

    public ViewHolder(View itemView) {
        super(itemView);

        tv = (TextView) itemView.findViewById(R.id.child_tv);
        fv = (EasyFlipView)itemView.findViewById(R.id.flipview);
    }

}
