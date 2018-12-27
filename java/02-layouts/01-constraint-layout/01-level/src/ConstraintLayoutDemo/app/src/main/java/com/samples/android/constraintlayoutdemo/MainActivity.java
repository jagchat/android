package com.samples.android.constraintlayoutdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void CalculateSum(View v){
        EditText ctlFirstEditText = findViewById(R.id.firstEditText);
        EditText ctlSecondEditText = findViewById(R.id.secondEditText);
        TextView msgTextView = findViewById(R.id.msgTextView);

        String sFirstNo = ctlFirstEditText.getText().toString();
        String sSecondNo = ctlSecondEditText.getText().toString();

        int firstNo = Integer.parseInt(sFirstNo);
        int secondNo = Integer.parseInt(sSecondNo);

        int sum = firstNo + secondNo;

        String msg = String.format("Sum = %s", sum);

        msgTextView.setText(msg);

    }
}
