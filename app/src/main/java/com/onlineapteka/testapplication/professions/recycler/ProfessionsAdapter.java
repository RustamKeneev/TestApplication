//package com.onlineapteka.testapplication.professions.recycler;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.onlineapteka.testapplication.R;
//import com.onlineapteka.testapplication.model.Professions;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ProfessionsAdapter extends RecyclerView.Adapter<ProfessionsViewHolder> {
//    private ProfessionsViewHolder.IOnClickListener iOnClickListener;
//    private List<Professions> mProfessions = new ArrayList<>();
//
//    public ProfessionsAdapter(ProfessionsViewHolder.IOnClickListener iOnClickListener) {
//        this.iOnClickListener = iOnClickListener;
//    }
//
//    public void updateList(List<Professions> professions){
//        this.mProfessions = professions;
//        notifyDataSetChanged();
//    }
//
//    @NonNull
//    @Override
//    public ProfessionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_professions,parent,false);
//        return new ProfessionsViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ProfessionsViewHolder holder, int position) {
//        holder.onBind(mProfessions.get(position));
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                iOnClickListener.onClick(mProfessions.get(position).getId(),
//                        mProfessions.get(position).getProfessionsTitle());
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return mProfessions.size();
//    }
//}
