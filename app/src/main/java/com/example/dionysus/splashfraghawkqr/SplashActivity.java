package com.example.dionysus.splashfraghawkqr;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import butterknife.BindView;

/**
 * Created by dionysus on 8/2/2018.
 */

public class SplashActivity extends AppCompatActivity{

Handler handler = new Handler();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        SplashFragment splashFragmen = new SplashFragment();

          FragmentTransaction transaction =getFragmentManager().beginTransaction();
          transaction.replace(R.id.activity_splash , splashFragmen)
                .commit();

          handler.postDelayed(DelayRun,2000);

    }

   private Runnable DelayRun = new Runnable() {
       @Override
       public void run() {
           Intent i = new Intent(SplashActivity.this,MapsActivity.class);
           startActivity(i);
           finish();
       }
   };


}

