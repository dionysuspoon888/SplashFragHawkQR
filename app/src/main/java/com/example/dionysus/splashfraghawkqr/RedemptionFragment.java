package com.example.dionysus.splashfraghawkqr;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.orhanobut.hawk.Hawk;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dionysus on 8/2/2018.
 */

public class RedemptionFragment extends BaseFragment {
    @BindView(R.id.qrcode2)
    ImageView qrcode2;
    @BindView(R.id.barcode2)
    ImageView barcode2;
    @BindView(R.id.qrfragback2)
    ImageButton qrfragback2;

    @BindView(R.id.iv_expired)
    ImageView iv_expired;

    //Image Slider
   @BindView(R.id.view_pager)
   ViewPager viewPager;

    private SwipeAdapter adapter;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.redemptionfrag,container,false);
        ButterKnife.bind(this,v);


        //set QR code
        if(Hawk.get(GlobalConstants.KEY_A)!=null) {
            Bitmap bm = generateQRCode((String) Hawk.get(GlobalConstants.KEY_A));
            qrcode2.setImageBitmap(bm);
        }
        Log.i("RedmpFrag","Set View");
        Log.i("RedmpFrag", (String)Hawk.get(GlobalConstants.KEY_STATE));

        //set Bar cdoe
        if(Hawk.get(GlobalConstants.KEY_C) !=null) {
            Bitmap bm2 = getBarCode((String) Hawk.get(GlobalConstants.KEY_C));
            barcode2.setImageBitmap(bm2);
        }

        //set Image Slider
        adapter = new SwipeAdapter(getActivity().getBaseContext());
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(1);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==0){
                    viewPager.setAdapter(null);
                    Hawk.put(GlobalConstants.KEY_STATE, "2");
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        int i=Integer.parseInt((String)Hawk.get(GlobalConstants.KEY_STATE));

        if(i==1){
            Log.i("i","i is sucessful");
        }



        if(i==1){
            qrcode2.setVisibility(View.VISIBLE);
            barcode2.setVisibility(View.VISIBLE);
            iv_expired.setVisibility(View.GONE);
            viewPager.setVisibility(View.VISIBLE);
            Log.i("RedemptionFragment", "GET FULL");

        }else if(i==3){
            qrcode2.setVisibility(View.VISIBLE);
            barcode2.setVisibility(View.GONE);
            iv_expired.setVisibility(View.GONE);
            viewPager.setVisibility(View.VISIBLE);
            Log.i("RedemptionFragment", "GET QR");

        }else if(i==4){
            qrcode2.setVisibility(View.GONE);
            barcode2.setVisibility(View.VISIBLE);
            iv_expired.setVisibility(View.GONE);
            viewPager.setVisibility(View.VISIBLE);
            Log.i("RedemptionFragment", "GET BARCODE");
        }else if(i==2){
            qrcode2.setVisibility(View.GONE);
            barcode2.setVisibility(View.GONE);
            iv_expired.setVisibility(View.VISIBLE);
            viewPager.setVisibility(View.GONE);
            Log.i("RedemptionFragment", "GET EXPIRED");
        }


        return v;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @OnClick(R.id.qrfragback2)
    public void qrfragback(){
        onBackPressed();

    }


}

