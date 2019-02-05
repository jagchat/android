package com.samples.android.passingvaluestoactivity;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private SampleData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        data = ViewModelProviders.of(this).get(SampleData.class);
        setFormValues(data);
        setEventListeners();
        Log.d("test-MainActivity", "OnCreate");
    }

    private void setFormValues(SampleData d){
        EditText firstNoEditText = (EditText) findViewById(R.id.firstNoEditText);
        EditText secondNoEditText = (EditText) findViewById(R.id.secondNoEditText);

        firstNoEditText.setText(Integer.toString(d.getFirstValue()));
        secondNoEditText.setText(Integer.toString(d.getSecondValue()));
    }

    private void setEventListeners(){

        EditText firstNoEditText = (EditText) findViewById(R.id.firstNoEditText);
        firstNoEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                setModel();
            }
        });

        EditText secondNoEditText = (EditText) findViewById(R.id.secondNoEditText);
        secondNoEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                setModel();
            }
        });

    }

    private void setModel(){
        EditText firstNoEditText = (EditText) findViewById(R.id.firstNoEditText);
        EditText secondNoEditText = (EditText) findViewById(R.id.secondNoEditText);

        data.setFirstValue(firstNoEditText.getText().toString());
        data.setSecondValue(secondNoEditText.getText().toString());
        Log.d("test-MainActivity", "OnSetModel");

        SumFragment sumFragment = (SumFragment) getSupportFragmentManager()
                .findFragmentById(R.id.sumFragment);

        sumFragment.refreshForm();


    }

}
