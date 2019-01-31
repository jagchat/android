package com.samples.android.passingvaluestoactivity;

import android.os.Parcel;
import android.os.Parcelable;

public class SampleData implements Parcelable {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this._firstValue);
        dest.writeInt(this._secondValue);
    }

    protected SampleData(Parcel in) {
        this._firstValue = in.readInt();
        this._secondValue = in.readInt();
    }

    public static final Parcelable.Creator<SampleData> CREATOR = new Parcelable.Creator<SampleData>() {
        @Override
        public SampleData createFromParcel(Parcel source) {
            return new SampleData(source);
        }

        @Override
        public SampleData[] newArray(int size) {
            return new SampleData[size];
        }
    };
}