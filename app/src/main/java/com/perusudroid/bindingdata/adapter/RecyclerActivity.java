package com.perusudroid.bindingdata.adapter;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.perusudroid.bindingdata.R;
import com.perusudroid.bindingdata.databinding.ActivityRecyclerBinding;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    private static final String TAG = RecyclerActivity.class.getSimpleName();
    ActivityRecyclerBinding recyclerBinding;
    SampleAdapter sampleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recyclerBinding = DataBindingUtil.setContentView(this, R.layout.activity_recycler);
        recyclerBinding.rview.setLayoutManager(new LinearLayoutManager(this));
        processInputs();
    }

    private void processInputs() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.getSerializable("obj") != null) {
                ArrayList<SampleData> sampleData = extras.getParcelableArrayList("obj");
                Log.d("Data", "processInputs: "+ sampleData.size());
                if(sampleAdapter == null){
                    sampleAdapter = new SampleAdapter(sampleData);
                    recyclerBinding.rview.setAdapter(sampleAdapter);
                    Log.d(TAG, "processInputs: adapter set");
                }else{
                    Log.d(TAG, "processInputs: refreshed");
                    sampleAdapter.refresh(sampleData);
                }
            }
        }
    }
}
