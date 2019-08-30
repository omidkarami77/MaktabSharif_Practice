package com.example.scrollview;


import android.annotation.SuppressLint;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button Buttonred;
    private Button Buttonorange;
    private Button Buttonyellow;
    private Button Buttongreen;
    private Button Buttonblue;
    private Button ButtonINDIGO;
    private Button ButtonViolet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Buttonred = findViewById(R.id.btnred);
        Buttonorange = findViewById(R.id.btnorange);
        Buttonyellow = findViewById(R.id.btnyellow);
        Buttongreen = findViewById(R.id.btngreen);
        Buttonblue = findViewById(R.id.btnblue);
        ButtonINDIGO = findViewById(R.id.btnINDIGO);
        ButtonViolet = findViewById(R.id.Violet);
        Buttonred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setVisibility(view.GONE);

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Buttonred.setText(R.string.red);
                        Buttonblue.setText(R.string.red);
                        Buttonorange.setText(R.string.red);
                        Buttonorange.setText(R.string.red);
                        Buttonyellow.setText(R.string.red);
                        Buttongreen.setText(R.string.red);
                        ButtonINDIGO.setText(R.string.red);
                        ButtonViolet.setText(R.string.red);
                    }
                }, 0000);
                setclick();
            }
        });
        Buttonblue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setVisibility(view.GONE);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                       Buttonred.setText(R.string.blue);
                        Buttonorange.setText(R.string.blue);
                        Buttonyellow.setText(R.string.blue);
                        Buttongreen.setText(R.string.blue);
                        ButtonINDIGO.setText(R.string.blue);
                        ButtonViolet.setText(R.string.blue);
                    }
                }, 0000);
                setclick();
            }
        });
        Buttonorange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setVisibility(view.GONE);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Buttongreen.setText(R.string.green);
                        Buttonred.setText(R.string.Orange);
                        Buttonblue.setText(R.string.Orange);
                        Buttonyellow.setText(R.string.Orange);
                        ButtonINDIGO.setText(R.string.Orange);
                        ButtonViolet.setText(R.string.Orange);
                    }
                }, 0000);
                setclick();
            }
        });
        Buttonyellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setVisibility(view.GONE);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Buttonred.setText(R.string.yellow);
                        Buttonblue.setText(R.string.yellow);
                        Buttonorange.setText(R.string.yellow);
                        Buttongreen.setText(R.string.yellow);
                        ButtonINDIGO.setText(R.string.yellow);
                        ButtonViolet.setText(R.string.yellow);
                    }
                }, 0000);
                setclick();
            }
        });
        Buttongreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setVisibility(view.GONE);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Buttonred.setText(R.string.green);
                        Buttonblue.setText(R.string.green);
                        Buttonorange.setText(R.string.green);
                        Buttonyellow.setText(R.string.green);
                        ButtonINDIGO.setText(R.string.green);
                        ButtonViolet.setText(R.string.green);
                    }
                }, 0000);
                setclick();
            }
        });
        ButtonViolet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setVisibility(view.GONE);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Buttonred.setText(R.string.red);
                        Buttonblue.setText(R.string.violet);
                        Buttonorange.setText(R.string.violet);
                        Buttonyellow.setText(R.string.violet);
                        Buttongreen.setText(R.string.violet);
                        ButtonINDIGO.setText(R.string.violet);
                    }
                }, 0000);
                setclick();
            }
        });
        ButtonINDIGO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setVisibility(view.GONE);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Buttonred.setText(R.string.red);
                        Buttonblue.setText(R.string.INDIGO);
                        Buttonorange.setText(R.string.INDIGO);
                        Buttonyellow.setText(R.string.INDIGO);
                        Buttongreen.setText(R.string.INDIGO);
                        ButtonViolet.setText(R.string.INDIGO);
                    }
                }, 0000);
                setclick();
            }
        });
    }

    public void setclick() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Buttonred.setText(R.string.red);
                Buttonorange.setText(R.string.Orange);
                Buttonyellow.setText(R.string.yellow);
                Buttonblue.setText(R.string.blue);
                Buttongreen.setText(R.string.green);
                ButtonINDIGO.setText(R.string.INDIGO);
                ButtonViolet.setText(R.string.violet);
            }
        }, 5000);
    }
}