package com.samples.android.passingvaluestoactivity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final int CALC_REQUEST_CODE  = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcButton(View v){
        EditText firstNoEditText = (EditText) findViewById(R.id.firstNoEditText);
        EditText secondNoEditText = (EditText) findViewById(R.id.secondNoEditText);

        SampleData d = new SampleData();
        d.setFirstValue(firstNoEditText.getText().toString());
        d.setSecondValue(secondNoEditText.getText().toString());

        Intent intent1 = new Intent(this, Activity1.class);
        intent1.putExtra("ProvidedValues", d);

        //register/wait for result, when child activity finishes
        //any code to identify request (will be returned from some other activity)
        startActivityForResult(intent1, CALC_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //called when child activity finishes

        // Check which request we're responding to (request code)
        if (requestCode == CALC_REQUEST_CODE) {
            // Make sure the request was successful (response code)
            if (resultCode == RESULT_OK) {

                //fetch returned result
                //(could also be bundle or getXXXXExtra methods of intent instead of custom object)
                SampleResultData d = (SampleResultData) data.getSerializableExtra("result");

                //show result
                TextView msgTextView = (TextView) findViewById(R.id.msgTextView);
                msgTextView.setText(String.format("Operation: %s, Result: %s",
                        d.getOperationType(), d.getResultValue()));
            }
        }

    }
}
