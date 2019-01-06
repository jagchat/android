package com.samples.android.passingvaluestoactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity1 extends AppCompatActivity {

    TextView firstNoTextView = null;
    TextView secondNoTextView = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        //init ctrl. variables
        firstNoTextView = (TextView) findViewById(R.id.firstNoTextView);
        secondNoTextView = (TextView) findViewById(R.id.secondNoTextView);

        //fetch params
        Intent intent = getIntent();
        SampleData d = (SampleData) intent.getSerializableExtra("ProvidedValues");

        //place values into ctrls.
        firstNoTextView.setText(Integer.toString(d.getFirstValue()));
        secondNoTextView.setText(Integer.toString(d.getSecondValue()));
    }

    public void sumButtonClick(View v){

        //get values from controls
        int a = Integer.parseInt(firstNoTextView.getText().toString());
        int b = Integer.parseInt(secondNoTextView.getText().toString());

        //calc. result (sum)
        int s = a + b;

        //create result object ro return back to caller/parent activity
        //(can also use intent.putExtra or bundle here instead of custom object)
        SampleResultData oResult = new SampleResultData();
        oResult.setOperationType("SUM");
        oResult.setResultValue(Integer.toString(s));


        //return "ok" (success)
        //return data (result)
        Intent intentResult = new Intent();
        intentResult.putExtra("result", oResult);
        setResult(RESULT_OK, intentResult);

        //mark activity as finished.
        finish();
    }

    public void multiplyButtonClick(View v){

        //get values from controls
        int a = Integer.parseInt(firstNoTextView.getText().toString());
        int b = Integer.parseInt(secondNoTextView.getText().toString());

        //calc. result (multiply)
        int p = a * b;

        //create result object ro return back to caller/parent activity
        //(can also use intent.putExtra or bundle here instead of custom object)
        SampleResultData oResult = new SampleResultData();
        oResult.setOperationType("MULTIPLY");
        oResult.setResultValue(Integer.toString(p));


        //return "ok" (success)
        //return data (result)
        Intent intentResult = new Intent();
        intentResult.putExtra("result", oResult);
        setResult(RESULT_OK, intentResult);

        //mark activity as finished.
        finish();
    }
}
