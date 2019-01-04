package com.samples.android.passingvaluestoactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        Intent intent1 = new Intent(this, Activity1.class);
        intent1.putExtra("FirstValue", firstNoEditText.getText().toString());
        intent1.putExtra("SecondValue", secondNoEditText.getText().toString());
        startActivity(intent1);
    }
}
