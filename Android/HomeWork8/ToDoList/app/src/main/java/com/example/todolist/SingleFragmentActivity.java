package com.example.todolist;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.omid.hw88.R;

public abstract class SingleFragmentActivity extends AppCompatActivity {
    public abstract Fragment createFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment_activities);
        FragmentManager fm = getSupportFragmentManager();
        if (fm.findFragmentById(R.id.single_fragment_activity) == null) {
            fm.beginTransaction().add((int) R.id.single_fragment_activity, createFragment()).commit();
        }
    }
}