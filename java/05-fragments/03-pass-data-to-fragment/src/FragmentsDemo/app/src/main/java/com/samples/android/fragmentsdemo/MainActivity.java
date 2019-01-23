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

    public void showSum(View v){

        //gather data and create custom object
        EditText firstNoEditText = (EditText) findViewById(R.id.firstNoEditText);
        EditText secondNoEditText = (EditText) findViewById(R.id.secondNoEditText);
        SampleData d = new SampleData();
        d.setFirstValue(firstNoEditText.getText().toString());
        d.setSecondValue(secondNoEditText.getText().toString());

        //create bundle with the custom object
        Bundle b = new Bundle();
        b.putSerializable("data", d);

        //fetch/check the fragment by tag (if exists)
        Fragment existingFragment = getSupportFragmentManager()
                .findFragmentByTag(FRAG_TAG);

        //if fragment not exists, create it
        if(existingFragment == null){
            //create fragment instance
            SumFragment frg = new SumFragment();
            frg.setArguments(b); //passing data using bundle

            //add fragment
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.frameContainer, frg, FRAG_TAG)
                    .commit();
        }
        else{
            //if already exists, just pass new data
            SumFragment frg = (SumFragment) existingFragment;

            //'setArguments' doesn't work once frag already added
            frg.putArguments(b);  //call custom method in frag
        }


    }

}
