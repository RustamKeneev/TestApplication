package com.onlineapteka.testapplication.doctors.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.onlineapteka.testapplication.R;
import com.onlineapteka.testapplication.model.Doctor;

import java.util.ArrayList;
import java.util.List;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorViewHolder> {

    private DoctorViewHolder.IOnClickListener onClickListener;
    private List<Doctor> mDoctors = new ArrayList<>();

    public DoctorAdapter(DoctorViewHolder.IOnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
//
//    public void updateList(List<Doctor> doctors){
//        this.mDoctors = doctors;
//        notifyDataSetChanged();
//    }

    @NonNull
    @Override
    public DoctorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_doctors,parent,false);
        return new DoctorViewHolder(view,onClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorViewHolder holder, int position) {
        holder.onBind(mDoctors.get(position));

    }

    @Override
    public int getItemCount() {
        return mDoctors.size();
    }

    public void setData(List<Doctor> doctors){
        mDoctors.clear();
        mDoctors.addAll(doctors);
        notifyDataSetChanged();
    }
}
