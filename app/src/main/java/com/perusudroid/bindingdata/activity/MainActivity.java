package com.perusudroid.bindingdata.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.perusudroid.bindingdata.R;
import com.perusudroid.bindingdata.adapter.RecyclerActivity;
import com.perusudroid.bindingdata.adapter.SampleData;
import com.perusudroid.bindingdata.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ToolbarData toolbarData = new ToolbarData("SampleBindingData");
        mainBinding.setToolbarData(toolbarData);

        mainBinding.btnGo.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ArrayList<SampleData> mList = new ArrayList<>();
                        mList.add(new SampleData("Periya", "Nayagam"));
                        mList.add(new SampleData("Android", "Dev"));
                        Intent intent = new Intent(MainActivity.this, RecyclerActivity.class);
                        intent.putParcelableArrayListExtra("obj", mList);
                        startActivity(intent);
                    }
                }
        );
    }
}
