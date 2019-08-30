package com.example.changefragment;


import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnblue;
    private Button btnyellow;
    private boolean chng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState!=null){
            chng =savedInstanceState.getBoolean("omid");
        }

        btnblue=(Button)findViewById(R.id.btnblue);
        btnyellow=(Button)findViewById(R.id.btnyellow);
        btnblue.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                changeState(true);
                stack(true);


            }
        });

        btnyellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeState(false);
                stack(false);
            }
        });
        changeState(chng);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("omid", chng);
    }

    private void changeState(boolean state){
        chng =state;
        FragmentManager fragmentManager=getSupportFragmentManager();
        Fragment fragment;
        if(state){

            fragment=new BlueFragment();

        }
        else{

            fragment=new YellowFragment();
        }
        fragmentManager.beginTransaction().add(R.id.framelayout,fragment).commit();
    }
    private void stack(boolean state){
        chng=state;
        if (state){
            Snackbar snackbar=Snackbar.make(btnblue,"Fragment No.1",Snackbar.LENGTH_LONG);
            snackbar.show();

        }else {
            Snackbar snackbar=Snackbar.make(btnyellow,"Fragment No.2",Snackbar.LENGTH_LONG);
            snackbar.show();

        }
    }
}