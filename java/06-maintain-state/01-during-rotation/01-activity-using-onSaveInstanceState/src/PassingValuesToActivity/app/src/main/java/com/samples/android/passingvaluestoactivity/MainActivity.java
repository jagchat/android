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
        EditText firstNoEditText = (EditText) findViewById(R.id.firstNoEditText);
        EditText secondNoEditText = (EditText) findViewById(R.id.secondNoEditText);
        outState.putString("firstNo", firstNoEditText.getText().toString());
        outState.putString("secondNo", secondNoEditText.getText().toString());

        super.onSaveInstanceState(outState);
        Log.d("test-MainActivity", "OnSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        //fetch values from state (after rotation)
        EditText firstNoEditText = (EditText) findViewById(R.id.firstNoEditText);
        EditText secondNoEditText = (EditText) findViewById(R.id.secondNoEditText);
        firstNoEditText.setText(savedInstanceState.getString("firstNo"));
        secondNoEditText.setText(savedInstanceState.getString("secondNo"));

        Log.d("test-MainActivity", "OnRestoreInstanceState");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d("test-MainActivity", "OnConfigurationChanged");
    }

    public void calcSumButton(View v){
        EditText firstNoEditText = (EditText) findViewById(R.id.firstNoEditText);
        EditText secondNoEditText = (EditText) findViewById(R.id.secondNoEditText);

        SampleData d = new SampleData();
        d.setFirstValue(firstNoEditText.getText().toString());
        d.setSecondValue(secondNoEditText.getText().toString());

        Intent intent1 = new Intent(this, Activity1.class);
        intent1.putExtra("ProvidedValues", d);

        startActivity(intent1);
    }
}
