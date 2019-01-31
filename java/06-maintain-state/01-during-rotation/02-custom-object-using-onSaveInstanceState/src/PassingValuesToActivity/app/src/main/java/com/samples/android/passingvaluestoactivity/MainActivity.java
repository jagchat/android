package com.samples.android.passingvaluestoactivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("test-MainActivity", "OnCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("test-MainActivity", "OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("test-MainActivity", "OnResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("test-MainActivity", "OnRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("test-MainActivity", "OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("test-MainActivity", "OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("test-MainActivity", "OnDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //-very minimal amount of information needs to be placed in state
        //-probably a couple of values
        //-not a good idea to store huge/complex object
        //-stored/retrieved from disk (serialization/deserialization takes long time)
        
        //place values in state (before rotation)
        super.onSaveInstanceState(outState);
        outState.putParcelable("data", getDataObject());
        Log.d("test-MainActivity", "OnSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        //fetch values from state (after rotation)
        SampleData d = (SampleData) savedInstanceState.getParcelable("data");
        EditText firstNoEditText = (EditText) findViewById(R.id.firstNoEditText);
        EditText secondNoEditText = (EditText) findViewById(R.id.secondNoEditText);
        firstNoEditText.setText(Integer.toString(d.getFirstValue()));
        secondNoEditText.setText(Integer.toString(d.getSecondValue()));

        Log.d("test-MainActivity", "OnRestoreInstanceState");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d("test-MainActivity", "OnConfigurationChanged");
    }

    private SampleData getDataObject(){
        EditText firstNoEditText = (EditText) findViewById(R.id.firstNoEditText);
        EditText secondNoEditText = (EditText) findViewById(R.id.secondNoEditText);

        SampleData d = new SampleData();
        d.setFirstValue(firstNoEditText.getText().toString());
        d.setSecondValue(secondNoEditText.getText().toString());

        return d;
    }

    public void calcSumButton(View v){
        Intent intent1 = new Intent(this, Activity1.class);
        intent1.putExtra("ProvidedValues", getDataObject());

        startActivity(intent1);
    }
}
