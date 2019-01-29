package com.samples.android.fragmentsdemo;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String FRAG_TAG = "MyFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void removeExistingFragment(){

        //fetch the fragment by tag
        Fragment existingFragment = getSupportFragmentManager()
                .findFragmentByTag(FRAG_TAG);

        //if fragment already exists in the container, remove it
        if(existingFragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .remove(existingFragment)
                    .commit();
        }
    }

    private SampleData getDataObject(){
        //gather data and create custom object
        EditText firstNoEditText = (EditText) findViewById(R.id.firstNoEditText);
        EditText secondNoEditText = (EditText) findViewById(R.id.secondNoEditText);
        SampleData d = new SampleData();
        d.setFirstValue(firstNoEditText.getText().toString());
        d.setSecondValue(secondNoEditText.getText().toString());
        return d;
    }

    public void showSum(View v){
        removeExistingFragment(); //remove existing (already added) fragment


        //create bundle with the custom object
        Bundle b = new Bundle();
        b.putSerializable("data", getDataObject());

        //create fragment instance
        SumFragment frg = new SumFragment();
        frg.setArguments(b); //passing data using bundle

        //add fragment
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frameContainer, frg, FRAG_TAG)
                .commit();
    }
}
