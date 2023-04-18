package com.student.academicadvisingsyst.AdminOP.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.student.academicadvisingsyst.AdminOP.Models.SemesterNew;
import com.student.academicadvisingsyst.R;

import java.util.List;

public class AdapterSemester extends RecyclerView.Adapter<AdapterSemester.ViewHolder> {
    private List<SemesterNew>mylists;
   // private ProductFragment productFragment;
   // private ProductPageByCategoryFragment productPageByCategoryFragment;
    private Context activity;

    public AdapterSemester(List<SemesterNew> mylists) {
        this.mylists = mylists;
    }

    public AdapterSemester(List<SemesterNew> mylists, Context activity) {
        this.mylists = mylists;
        this.activity = activity;
    }

    @NonNull
    @Override
    public AdapterSemester.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        if (viewType == VIEW_TYPE_EMPTY){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.empty_data, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_semeter,parent,false);
        }
        return new ViewHolder(view);    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull AdapterSemester.ViewHolder holder, int position) {
        if (!mylists.isEmpty()) {

            holder.txtYearId.setText(" العام الدراسي  : " + mylists.get(position).getYearId());
            holder.txtNameSemesterName.setText("الفصل الدراسي :" + mylists.get(position).getSemesterName());
            holder.txtDateSt.setText(" بداية الفصل :" + mylists.get(position).getSemesterStDate());
            holder.txtDateEnd.setText(" نهاية الفصل :" + mylists.get(position).getSemesterStDate());

        }
       // Toast.makeText(activity, "a"+mylists.get(position).getStudentName(), Toast.LENGTH_SHORT).show();

    }
    private static final int VIEW_TYPE_MEDICINE = 0;
    private static final int VIEW_TYPE_EMPTY = 1;
    @Override
    public int getItemViewType(int position) {
        if (mylists.size() == 0) {
            return VIEW_TYPE_EMPTY;
        } else {
            return VIEW_TYPE_MEDICINE;
        }
    }

    @Override
    public int getItemCount() {
        // Get position of the product
        if (mylists == null) {
            return 0;
        }
        return mylists.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView txtDateEnd,txtDateSt,txtNameSemesterName,txtYearId;
       // textTitle,textHeader,textSubtitle

        private LinearLayoutCompat linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtYearId = itemView.findViewById(R.id.txtYearId);
            txtNameSemesterName = itemView.findViewById(R.id.txtNameSemesterName);
            txtDateSt= itemView.findViewById(R.id.txtDateSt);
            txtDateEnd=itemView.findViewById(R.id.txtDateEnd);
            //add=binding.iconAddWahlist;
//            linearLayout= itemView.findViewById(R.id.item_container);
        }
    }
    public void updateList( List<SemesterNew> newList) {
        // on below line we are clearing
        // our notes array list
        mylists.clear();
        // on below line we are adding a
        // new list to our all notes list.
        mylists.addAll(newList);
        // on below line we are calling notify data
        // change method to notify our adapter.
        notifyDataSetChanged();
    }
}


