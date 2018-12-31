package com.samples.android.custommoduledemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.samples.android.utils.Calc;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSumButtonClick(View v){
        Calc o = new Calc();
        int s = o.getSum(10, 20);
        Toast.makeText(this, "Sum = " + s, Toast.LENGTH_SHORT).show();
    }
}
