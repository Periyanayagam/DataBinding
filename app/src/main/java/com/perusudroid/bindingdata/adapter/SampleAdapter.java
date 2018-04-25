package com.perusudroid.bindingdata.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.perusudroid.bindingdata.R;
import com.perusudroid.bindingdata.databinding.InflaterSampleBinding;

import java.util.List;

/**
 * Created by Intel on 23-04-2018.
 */

public class SampleAdapter extends RecyclerView.Adapter<SampleAdapter.SampleViewHolder> {

    private static final String TAG = SampleAdapter.class.getSimpleName();
    private List<SampleData> sampleDataList;
    private InflaterSampleBinding sampleBinding;


    public SampleAdapter(List<SampleData> sampleDataList) {
        this.sampleDataList = sampleDataList;
    }

    public void refresh(List<SampleData> sampleDataList) {
        this.sampleDataList = sampleDataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        sampleBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.inflater_sample, parent, false);
        return new SampleViewHolder(sampleBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull SampleViewHolder holder, int position) {
        SampleData sampleData = sampleDataList.get(position);
        Log.d(TAG, "onBindViewHolder: ");
        holder.sampleBinding.setSampleData(sampleData);
        holder.sampleBinding.executePendingBindings();

    }

    @Override
    public int getItemCount() {
        return sampleDataList.size();
    }

    public class SampleViewHolder extends RecyclerView.ViewHolder {

        public InflaterSampleBinding sampleBinding;

        public SampleViewHolder(@NonNull InflaterSampleBinding sampleBinding) {
            super(sampleBinding.getRoot());
            this.sampleBinding = sampleBinding;
        }
    }
}
