package com.example.radoslawn.adapter;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by radoslawn on 18.07.16.
 */
public class ViewHolder {
    ImageView iv;
    TextView tv1;
    TextView tv2;
    public ViewHolder(View v) {
        this.iv = (ImageView)v.findViewById(R.id.icon);
        this.tv1 = (TextView)v.findViewById(R.id.tekst1);
        this.tv2 = (TextView)v.findViewById(R.id.tekst2);
        tv1.setTextColor(Color.parseColor("#FF0000"));
        tv2.setTextColor(Color.parseColor("#00FF00"));
    }

    public ViewHolder(ImageView iv, TextView tv1, TextView tv2, TextView tv3) {
        this.iv = iv;
        this.tv1 = tv1;
        this.tv2 = tv2;
    }
}
