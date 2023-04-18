package com.student.academicadvisingsyst.StudentOp.AdapterStudent;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.student.academicadvisingsyst.AdminOP.Models.Section;
import com.student.academicadvisingsyst.R;
import com.student.academicadvisingsyst.StudentOp.ui.AttendViewStudent;
import com.student.academicadvisingsyst.StudentOp.ui.DailyScheduleStudentView;

import java.util.List;

public class AdapterTableSectionStudent extends RecyclerView.Adapter<AdapterTableSectionStudent.ViewHolder> {
    private List<Section>mylists;
    // private ProductFragment productFragment;
    // private ProductPageByCategoryFragment productPageByCategoryFragment;
    private Context activity;
    public AdapterTableSectionStudent(List<Section> mylists) {
        this.mylists = mylists;
    }

    public AdapterTableSectionStudent(List<Section> mylists, Context activity) {
        this.mylists = mylists;
        this.activity = activity;
    }
    int pid=0;
    public AdapterTableSectionStudent(List<Section> mylists, Context activity, int pid) {
        this.mylists = mylists;
        this.activity = activity;
        this.pid=pid;
    }
    @NonNull
    @Override
    public AdapterTableSectionStudent.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        if (viewType == VIEW_TYPE_EMPTY){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.empty_data, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_table,parent,false);
        }
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull AdapterTableSectionStudent.ViewHolder holder, int position) {
        if (!mylists.isEmpty()) {

            holder.txtSectionNme.setText("اسم الشعبة : " + mylists.get(position).getSectionId());
            holder.txtNameSubject.setText(" اسم المادة :" + mylists.get(position).getSubjectNameAr());
            holder.txtTecherName.setText(" المدرب :" + mylists.get(position).getTecharName());
            holder.txtTypeSection.setText(" نوع الشعبة :" + mylists.get(position).getSectionType());
            holder.txtDayName.setText(" اليوم : " + mylists.get(position).getDayName());

            holder.txtTimeOf.setText("  الى الساعه :" + mylists.get(position).getTimeTo());

            holder.txtTimeTo.setText("  من الساعه :" + mylists.get(position).getTimeOf());
//            holder.txtRes.setText(" الحاله :" + mylists.get(position).getResult());


        }

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
        private ImageView imageView,iconAddWatchlist;
        private TextView txtSectionNme ,txtTecherName,txtNameSubject,txtTypeSection,txt;

        private TextView txtDayName,txtTimeOf,txtTimeTo,txtRes;

        ImageView add;
        // textTitle,textHeader,textSubtitle

        private LinearLayoutCompat linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtSectionNme = itemView.findViewById(R.id.txtSectionNme);
            txtTecherName = itemView.findViewById(R.id.txtTecherName);
            txtNameSubject= itemView.findViewById(R.id.txtNameSubject);
            txtTypeSection=itemView.findViewById(R.id.txtTypeSection);
            txtDayName=itemView.findViewById(R.id.txtDayName);

            txtTimeOf = itemView.findViewById(R.id.txtTimeOf);
            txtTimeTo= itemView.findViewById(R.id.txtTimeTo);

            //add=binding.iconAddWahlist;
//            linearLayout= itemView.findViewById(R.id.item_container);
        }
    }
    public void updateList( List<Section> newList) {
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


