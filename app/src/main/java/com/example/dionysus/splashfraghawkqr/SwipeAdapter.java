package com.example.dionysus.splashfraghawkqr;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.orhanobut.hawk.Hawk;

public class SwipeAdapter extends PagerAdapter {
    private int[] image_resources2 = {0,R.drawable.mess};

    private LayoutInflater layoutInflater;
    private Context ctx;

    public SwipeAdapter(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return image_resources2.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(RelativeLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //PageAdapter Basic Setting

        layoutInflater = layoutInflater.from(ctx);
        View item_view = layoutInflater.inflate(R.layout.swipelayout,container,false);
        ImageView imageView2 = item_view.findViewById(R.id.mess);

        imageView2.setImageResource(image_resources2[position]);



        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }



}
