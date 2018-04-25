package com.perusudroid.bindingdata.utils;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.perusudroid.bindingdata.R;
import com.perusudroid.bindingdata.adapter.SampleData;
import com.perusudroid.bindingdata.databinding.ActivityUtilBinding;

public class UtilActivity extends AppCompatActivity {

    ActivityUtilBinding utilBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        utilBinding = DataBindingUtil.setContentView(this, R.layout.activity_util);

        SampleData sampleData = new SampleData("Periys    Nayagam     sdvhjgds", "v  a   d  ");
        utilBinding.setSampleData(sampleData);

    }
}
