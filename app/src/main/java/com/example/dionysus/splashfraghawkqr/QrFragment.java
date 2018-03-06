package com.example.dionysus.splashfraghawkqr;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.orhanobut.hawk.Hawk;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dionysus on 8/2/2018.
 */

public class QrFragment extends BaseFragment{
    @BindView(R.id.qrcode)
    ImageView qrcode;
    @BindView(R.id.barcode)
    ImageView barcode;
    @BindView(R.id.qrfragback)
    Button qrfragback;
    @BindView(R.id.tv_inputtext)
    TextView tv_inputtext;

    String text1;
    String text2;

//    public static QrFragment newInstance(String i,String j){
//        QrFragment qrFragment = new QrFragment();
//        Bundle args = new Bundle();
//        args.putString("keyString1",i);
//        args.putString("keyString2",j);
//        qrFragment.setArguments(args);
//
//        return qrFragment;
//
//    }
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);  USELESS
//    }
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        Bundle args = getArguments();
//
//         text1 =args.getString(GlobalConstants.KEY_A);
//        text2 =args.getString(GlobalConstants.KEY_C);
//
//          Log.i("QrFrag","Get Data Success");
//
//
//
//    }




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.qrfragment,container,false);
        ButterKnife.bind(this,v);

//        String tmp1=Hawk.get(GlobalConstants.KEY_A);
//        String tmp2=Hawk.get(GlobalConstants.KEY_C);    Testing
//        testing.setText(tmp1+"   "+tmp2);


        //set QR code
        Bitmap bm = generateQRCode((String)Hawk.get(GlobalConstants.KEY_A));
        qrcode.setImageBitmap(bm);
        Log.i("QrFrag","Set View");

        //set Bar cdoe

        Bitmap bm2 = getBarCode((String)Hawk.get(GlobalConstants.KEY_C));
        barcode.setImageBitmap(bm2);


        tv_inputtext.setText("Input Text:"+GlobalConstants.KEY_E);


        return v;

    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @OnClick(R.id.qrfragback)
    public void qrfragback(){
        onBackPressed();

    }







}
