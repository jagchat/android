package com.samples.android.passingvaluestoactivity;

import java.io.Serializable;

public class SampleResultData implements Serializable {
    String _opType;
    int _result;

    public SampleResultData(){

    }

    public SampleResultData(String opType, String resultValue){
        setOperationType(opType);
        setResultValue(resultValue);
    }

    public void setOperationType(String value){
        _opType = value;
    }

    public void setResultValue(String value){
        _result = Integer.parseInt(value);
    }

    public String getOperationType(){
        return _opType;
    }

    public int getResultValue(){
        return _result;
    }

}