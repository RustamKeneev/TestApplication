package com.onlineapteka.testapplication.doctors.recycler;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.onlineapteka.testapplication.R;
import com.onlineapteka.testapplication.model.Doctor;

import de.hdodenhof.circleimageview.CircleImageView;


public class DoctorViewHolder extends RecyclerView.ViewHolder {

    private TextView doctors_title;
    private TextView doctors_description;
    private TextView doctors_status;
    private TextView doctors_work_location;
    private CircleImageView doctors_image;
    private IOnClickListener onClickListener;

    public DoctorViewHolder(@NonNull View itemView, final IOnClickListener onClickListener) {
        super(itemView);
        doctors_title = itemView.findViewById(R.id.doctors_title);
        doctors_description = itemView.findViewById(R.id.doctors_description);
        doctors_status = itemView.findViewById(R.id.doctors_status);
        doctors_work_location = itemView.findViewById(R.id.doctors_work_location);
        doctors_image = itemView.findViewById(R.id.doctors_image);
        this.onClickListener = onClickListener;
    }

    public interface IOnClickListener{
        void onClick(String doctorID);
    }

    public void onBind(Doctor doctor){
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onClick(doctor.getId());
            }
        });
        Glide.with(itemView.getContext()).load(doctor.getDoctorImage()).into(doctors_image);
        doctors_title.setText(doctor.getDoctorFullName());
        doctors_description.setText(doctor.getDoctor_type());
        doctors_status.setText(doctor.getDoctorStatus());
        doctors_work_location.setText(doctor.getDoctorWorkLocation());
    }
}
