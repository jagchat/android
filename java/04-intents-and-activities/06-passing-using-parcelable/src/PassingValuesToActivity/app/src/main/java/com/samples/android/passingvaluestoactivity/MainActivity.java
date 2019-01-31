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
