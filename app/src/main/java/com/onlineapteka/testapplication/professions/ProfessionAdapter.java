package com.onlineapteka.testapplication.professions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.onlineapteka.testapplication.R;
import com.onlineapteka.testapplication.interfaces.OnItemClickListener;
import com.onlineapteka.testapplication.model.Professions;

import java.util.ArrayList;

public class ProfessionAdapter extends RecyclerView.Adapter<ProfessionAdapter.ProfessionsViewHolder> {

    private Context context;
    private ArrayList<Professions> mProfessions;
    private OnItemClickListener onItemClickListener;

    public ProfessionAdapter(Context context, ArrayList<Professions> mProfessions) {
        this.context = context;
        this.mProfessions = mProfessions;
    }

    @NonNull
    @Override
    public ProfessionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_professions,parent,false);
        return new ProfessionsViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ProfessionsViewHolder holder, int position) {
        holder.bind(mProfessions.get(position));
    }

    @Override
    public int getItemCount() {
        return mProfessions.size();
    }


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class ProfessionsViewHolder extends RecyclerView.ViewHolder{
        private ImageView professions_image;
        private TextView medical_person_professions_title;
        private TextView medical_person_professions_description;
        private TextView medical_professions_text;

        public ProfessionsViewHolder(@NonNull View itemView) {
            super(itemView);
            professions_image = itemView.findViewById(R.id.professions_image);
            medical_person_professions_title = itemView.findViewById(R.id.medical_person_professions_title);
            medical_person_professions_description = itemView.findViewById(R.id.medical_person_professions_description);
            medical_professions_text = itemView.findViewById(R.id.medical_professions_text);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(getAdapterPosition());
                }
            });
        }

        public void bind(Professions professions){
            Glide.with(itemView.getContext()).load(professions.getProfessionsImage()).into(professions_image);
            medical_person_professions_title.setText(professions.getProfessionsTitle());
            medical_person_professions_description.setText(professions.getProfessionsDescription());
            medical_professions_text.setText(professions.getMedicalProfessions());
        }
    }
}
