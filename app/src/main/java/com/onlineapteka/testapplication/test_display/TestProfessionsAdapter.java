package com.onlineapteka.testapplication.test_display;

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
import com.onlineapteka.testapplication.model.ProfessionsCategory;

import java.util.ArrayList;

public class TestProfessionsAdapter extends RecyclerView.Adapter<TestProfessionsAdapter.TestProfessionsViewHolder>{

    private Context context;
    private ArrayList<ProfessionsCategory> professionsCategories;
    private OnItemClickListener onItemClickListener;

    public TestProfessionsAdapter(Context context, ArrayList<ProfessionsCategory> professionsCategories) {
        this.context = context;
        this.professionsCategories = professionsCategories;
    }

    @NonNull
    @Override
    public TestProfessionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_professions,parent,false);
        return new TestProfessionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TestProfessionsViewHolder holder, int position) {
        holder.onBind(professionsCategories.get(position));
    }

    @Override
    public int getItemCount() {
        return professionsCategories.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class TestProfessionsViewHolder extends RecyclerView.ViewHolder{

        private ImageView professions_image;
        private TextView medical_person_professions_title;
        private TextView medical_person_professions_description;
        private TextView medical_professions_text;

        public TestProfessionsViewHolder(@NonNull View itemView) {
            super(itemView);
            professions_image = itemView.findViewById(R.id.professions_image);
            medical_person_professions_title = itemView.findViewById(R.id.medical_person_professions_title);
            medical_person_professions_description = itemView.findViewById(R.id.medical_person_professions_description);
            medical_professions_text = itemView.findViewById(R.id.medical_professions_text);
        }

        public void onBind(ProfessionsCategory professionsCategory){
            Glide.with(itemView.getContext()).load(professionsCategory.getProfessionsId()).into(professions_image);
//            professions_image.setImageResource(Integer.parseInt(professionsCategory.getProfessionsId()));
            medical_person_professions_title.setText(professionsCategory.getProfessionsName());
        }
    }
}
