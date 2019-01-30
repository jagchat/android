package com.samples.android.fragmentsdemo;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements SumFragment.OnFragmentInteractionListener {//implementing Fragment interface

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

    private void showValues(SampleData d){
        //get ref to render
        TextView firstNoTextView = (TextView) findViewById(R.id.firstNoTextView);
        TextView secondNoEditText = (TextView) findViewById(R.id.secondNoTextView);

        //render values
        firstNoTextView.setText(Integer.toString(d.getFirstValue()));
        secondNoEditText.setText(Integer.toString(d.getSecondValue()));
    }

    private SampleData getDataObject(){
        //gather data and create custom object
        TextView firstNoTextView = (TextView) findViewById(R.id.firstNoTextView);
        TextView secondNoEditText = (TextView) findViewById(R.id.secondNoTextView);
        SampleData d = new SampleData();
        d.setFirstValue(firstNoTextView.getText().toString());
        d.setSecondValue(secondNoEditText.getText().toString());
        return d;
    }

    public void showValuesEditor(View v){
        removeExistingFragment(); //remove existing (already added) fragment

        //create fragment instance (using factory method)
        //pass (default) data (from Activity) to fragment using factory method
        SumFragment frg = SumFragment.newInstance(getDataObject());

        //add fragment
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frameContainer, frg, FRAG_TAG)
                .commit();
    }

    //fragment interface method implementation
    @Override
    public void onApplyChanges(SampleData data) { //automatically called from the fragment itself
        showValues(data); //refresh UI with latest data returned from fragment
        removeExistingFragment(); //done with editing, remove the fragment from UI
    }
}
