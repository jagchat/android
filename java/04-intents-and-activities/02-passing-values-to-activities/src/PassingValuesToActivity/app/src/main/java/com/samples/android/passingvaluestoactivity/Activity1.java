package com.samples.android.passingvaluestoactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        Intent intent = getIntent();
        int firstValue = Integer.parseInt(intent.getStringExtra("FirstValue"));
        int secondValue = Integer.parseInt(intent.getStringExtra("SecondValue"));
        int sum = firstValue + secondValue;

        TextView firstNoTextView = (TextView) findViewById(R.id.firstNoTextView);
        TextView secondNoTextView = (TextView) findViewById(R.id.secondNoTextView);
        TextView sumTextView = (TextView) findViewById(R.id.sumTextView);

        firstNoTextView.setText(Integer.toString(firstValue));
        secondNoTextView.setText(Integer.toString(secondValue));
        sumTextView.setText(Integer.toString(sum));
    }
}
