package com.perusudroid.bindingdata.adapter;

import android.databinding.BaseObservable;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Intel on 23-04-2018.
 */

public class SampleData  extends BaseObservable implements Parcelable{

    private String firstName, lastName;

    public SampleData(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    protected SampleData(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
    }

    public static final Creator<SampleData> CREATOR = new Creator<SampleData>() {
        @Override
        public SampleData createFromParcel(Parcel in) {
            return new SampleData(in);
        }

        @Override
        public SampleData[] newArray(int size) {
            return new SampleData[size];
        }
    };

    public void notifyData(SampleData data) {
        this.firstName = data.firstName;
        this.lastName = data.lastName;
        notifyChange();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(firstName);
        parcel.writeString(lastName);
    }
}
