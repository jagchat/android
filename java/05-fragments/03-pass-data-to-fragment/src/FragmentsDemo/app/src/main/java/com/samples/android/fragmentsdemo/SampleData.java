package com.samples.android.fragmentsdemo;

import java.io.Serializable;

public class SampleData implements Serializable {
    int _firstValue;
    int _secondValue;

    public SampleData(){

    }

    public SampleData(String firstValue, String secondValue){
        setFirstValue(firstValue);
        setSecondValue(secondValue);
    }

    public void setFirstValue(String value){
        _firstValue = Integer.parseInt(value);
    }

    public void setSecondValue(String value){
        _secondValue = Integer.parseInt(value);
    }

    public int getFirstValue(){
        return _firstValue;
    }

    public int getSecondValue(){
        return _secondValue;
    }

}
