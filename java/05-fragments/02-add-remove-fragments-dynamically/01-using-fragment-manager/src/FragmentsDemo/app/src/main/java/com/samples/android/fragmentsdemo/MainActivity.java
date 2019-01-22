package com.samples.android.fragmentsdemo;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private void removeExistingFragment(){

        //fetch the fragment already sitting in frameContainer (FrameLayout control)
        Fragment existingFragment = getSupportFragmentManager()
                .findFragmentById(R.id.frameContainer);

        //if fragment already exists in the container, remove it
        if(existingFragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .remove(existingFragment)
                    .commit();
        }
    }


    public void showFragment1buttonOnClick(View v){

        removeExistingFragment();

        //add new fragment (fragment 1);
        Fragment1 frg = new Fragment1();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frameContainer, frg) //add fragment to FrameLayout control
                .commit();
    }


    public void showFragment2buttonOnClick(View v){

        removeExistingFragment();

        //add new fragment (fragment 2)
        Fragment2 frg = new Fragment2();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frameContainer, frg) //add fragment to FrameLayout control
                .commit();
    }
}
