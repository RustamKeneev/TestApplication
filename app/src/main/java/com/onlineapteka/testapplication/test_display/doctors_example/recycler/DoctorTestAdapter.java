package com.onlineapteka.testapplication.test_display.doctors_example.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.onlineapteka.testapplication.R;
import com.onlineapteka.testapplication.model.Doctor;
import com.onlineapteka.testapplication.model.Professions;

import java.util.ArrayList;
import java.util.List;

public class DoctorTestAdapter extends RecyclerView.Adapter<DoctorTestViewHolder> {

    private DoctorTestViewHolder.IOnClickListener onClickListener;
    private List<Doctor> mDoctors = new ArrayList<>();

    public DoctorTestAdapter(DoctorTestViewHolder.IOnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void updateList(List<Doctor> doctors){
        this.mDoctors = doctors;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DoctorTestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_doctors,parent,false);
        return new DoctorTestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorTestViewHolder holder, int position) {
        holder.onBind(mDoctors.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onClick(mDoctors.get(position).getId(),
                        mDoctors.get(position).getDoctorFullName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDoctors.size();
    }
}
