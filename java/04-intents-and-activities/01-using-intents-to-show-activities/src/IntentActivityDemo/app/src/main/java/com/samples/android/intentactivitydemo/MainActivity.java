package com.samples.android.intentactivitydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onActivity1ButtonClick(View v){
        Intent intent1 = new Intent(this, Activity1.class);
        startActivity(intent1);
    }

    public void onActivity2ButtonClick(View v){
        Intent intent2 = new Intent(this, Activity2.class);
        startActivity(intent2);
    }
}
