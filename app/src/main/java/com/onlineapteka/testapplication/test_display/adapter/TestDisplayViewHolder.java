package com.onlineapteka.testapplication.test_display.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.onlineapteka.testapplication.R;
import com.onlineapteka.testapplication.model.Professions;

public class TestDisplayViewHolder extends RecyclerView.ViewHolder {

    private ImageView professions_image;
    private TextView medical_person_professions_title;
    private TextView medical_person_professions_description;
    private TextView medical_professions_text;

    public TestDisplayViewHolder(@NonNull View itemView) {
        super(itemView);
        professions_image = itemView.findViewById(R.id.professions_image);
        medical_person_professions_title = itemView.findViewById(R.id.medical_person_professions_title);
        medical_person_professions_description = itemView.findViewById(R.id.medical_person_professions_description);
        medical_professions_text = itemView.findViewById(R.id.medical_professions_text);
    }
    public interface IOnClickListener{
        void onClick(String position, String title);
    }
    public void onBind(Professions professions){
//        Glide.with(itemView.getContext()).load(professions.getProfessionsImage()).into(professions_image);
        medical_person_professions_title.setText(professions.getProfessionsTitle());
        medical_person_professions_description.setText(professions.getProfessionsDescription());
        medical_professions_text.setText(professions.getMedicalProfessions());
    }
}
