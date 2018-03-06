package com.example.dionysus.splashfraghawkqr;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.orhanobut.hawk.Hawk;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dionysus on 8/2/2018.
 */

public class ParentFragment extends BaseFragment {

    @BindView(R.id.editTextA)
    EditText editTextA;
    @BindView(R.id.editTextC)
    EditText editTextC;
    @BindView(R.id.editTextE)
    EditText editTextE;
    @BindView(R.id.buttonB)
    Button buttonB;
    @BindView(R.id.buttonD)
    Button buttonD;
    @BindView(R.id.buttonF)
    Button buttonF;
    @BindView(R.id.buttonDelA)
    Button buttonDelA;
    @BindView(R.id.buttonDelC)
    Button buttonDelC;
    @BindView(R.id.buttonDelE)
    Button buttonDelE;
    @BindView(R.id.buttonG)
    Button buttonG;
    @BindView(R.id.buttonH)
    Button buttonH;

    @BindView(R.id.tv_A)
    TextView tv_A;
    @BindView(R.id.tv_C)
    TextView tv_C;
    @BindView(R.id.tv_E)
    TextView tv_E;
    @BindView(R.id.tv_state)
    TextView tv_state;



    String A;
    String C;
    String E;





    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.parentfrag,container,false);
        ButterKnife.bind(this,v);

        return v;
    }


    @Override
    public void onResume() {
        super.onResume();


        String tmp1 =Hawk.get(GlobalConstants.KEY_A);
        updateText(tv_A,tmp1);
        String tmp2 =Hawk.get(GlobalConstants.KEY_C);
        updateText(tv_C,tmp2);

        updateText(tv_E,GlobalConstants.KEY_E);


    }




    @OnClick(R.id.buttonB)
    public void setButtonB(){
        Log.i("Parent"," B!!!");
         A = editTextA.getText().toString().trim();
        editTextA.setText("");
        Hawk.put(GlobalConstants.KEY_A, A);
        String tmp = Hawk.get(GlobalConstants.KEY_A);

        Hawk.put(GlobalConstants.KEY_STATE,"0");
        updateText(tv_A,tmp); //class to string


        Log.i("Parent save",(String)Hawk.get(GlobalConstants.KEY_STATE));


    }



    @OnClick(R.id.buttonD)
    public void setButtonD(){
        Log.i("Parent"," D!!!");
         C = editTextC.getText().toString().trim();
        editTextC.setText("");
        Hawk.put(GlobalConstants.KEY_C, C);
        String tmp = Hawk.get(GlobalConstants.KEY_C);

        Hawk.put(GlobalConstants.KEY_STATE,"0");
        updateText(tv_C,tmp);



    }


    @OnClick(R.id.buttonF)
    public void setButtonF(){
        Log.i("Parent"," F!!!");
         E = editTextE.getText().toString().trim();
         GlobalConstants.KEY_E=E;
        editTextE.setText("");
        updateText(tv_E,GlobalConstants.KEY_E);

    }

    @OnClick(R.id.buttonDelA)
    public void setButtonDelA(){
        Hawk.delete(GlobalConstants.KEY_A);

        Hawk.put(GlobalConstants.KEY_STATE,"0");
        updateText(tv_A,"");

    }

    @OnClick(R.id.buttonDelC)
    public void setButtonDelC(){
        Hawk.delete(GlobalConstants.KEY_C);

        Hawk.put(GlobalConstants.KEY_STATE,"0");
        updateText(tv_C,"");

    }

    @OnClick(R.id.buttonDelE)
    public void setButtonDelE(){
        Hawk.delete(GlobalConstants.KEY_E);
        updateText(tv_E,"");
        GlobalConstants.KEY_E="";



    }






    @OnClick(R.id.buttonH)
    public void setButtonH(){
        Log.i("Parent"," H!!!");

//        if(A == "") {
//            startFragBackState(R.id.container, new QrFragment(), getFragmentManager());
//
//            Log.i("Parent","Not Sent String");
//        }else {
        if(Hawk.get(GlobalConstants.KEY_A)!=null&&Hawk.get(GlobalConstants.KEY_C)!=null) {

            startFragBackState(R.id.container, new QrFragment(), getFragmentManager());
        }



    }

    @OnClick(R.id.buttonG)
    public void setButtonG(){
        Log.i("Parent","G!!!");

        if(Hawk.get( GlobalConstants.KEY_A )!= null&& Hawk.get( GlobalConstants.KEY_C )!= null) {
            if(Integer.parseInt((String)Hawk.get(GlobalConstants.KEY_STATE)) ==0){
                Hawk.put(GlobalConstants.KEY_STATE, "1");

            }
            startFragBackState(R.id.container, new RedemptionFragment(), getFragmentManager());
            Log.i("Parent", "Sent FULL");
        }else if(Hawk.get( GlobalConstants.KEY_A )!= null&&Hawk.get( GlobalConstants.KEY_C )== null ){
            if(Integer.parseInt((String)Hawk.get(GlobalConstants.KEY_STATE)) !=2){
                Hawk.put(GlobalConstants.KEY_STATE, "3");
            }

            startFragBackState(R.id.container, new RedemptionFragment(), getFragmentManager());
            Log.i("Parent", "Sent QR");
        }else if(Hawk.get( GlobalConstants.KEY_A )== null&&Hawk.get( GlobalConstants.KEY_C )!= null ){
            if(Integer.parseInt((String)Hawk.get(GlobalConstants.KEY_STATE)) !=2) {
                Hawk.put(GlobalConstants.KEY_STATE, "4");
            }

            startFragBackState(R.id.container, new RedemptionFragment(), getFragmentManager());
            Log.i("Parent", "Sent BARCODE");
        }else if(Hawk.get( GlobalConstants.KEY_A )== null&&Hawk.get( GlobalConstants.KEY_C )== null){
            Log.i("Parent", "Sent NULL");
        }

        //"",,FULL,EXPIRED,QR,BARCODE
    }

    public void updateText(TextView textView,String i){
        textView.setText(i);
        if(Hawk.get(GlobalConstants.KEY_STATE)!=null){
            String tmp3 = Hawk.get(GlobalConstants.KEY_STATE);
            tv_state.setText("state:"+tmp3);
        }
    }

}
