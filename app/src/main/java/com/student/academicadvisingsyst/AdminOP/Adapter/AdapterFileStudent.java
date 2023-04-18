package com.student.academicadvisingsyst.AdminOP.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.student.academicadvisingsyst.AdminOP.Models.FileStudent;
import com.student.academicadvisingsyst.R;
import com.student.academicadvisingsyst.StudentOp.FileStudentSemester;

import java.util.List;

public class AdapterFileStudent extends RecyclerView.Adapter<AdapterFileStudent.ViewHolder> {
    private List<FileStudent>mylists;
   // private ProductFragment productFragment;
   // private ProductPageByCategoryFragment productPageByCategoryFragment;
    private Context activity;

    public AdapterFileStudent(List<FileStudent> mylists) {
        this.mylists = mylists;
    }

    public AdapterFileStudent(List<FileStudent> mylists, Context activity) {
        this.mylists = mylists;
        this.activity = activity;
    }
    int ii=0;
    public AdapterFileStudent(List<FileStudent> mylists, Context activity,int i) {
        this.mylists = mylists;
        this.activity = activity;
        ii=i;

    }
    @NonNull
    @Override
    public AdapterFileStudent.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;

        if (viewType == VIEW_TYPE_EMPTY){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.empty_data, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_file_student,parent,false);
        }
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull AdapterFileStudent.ViewHolder holder, int position) {
        if (!mylists.isEmpty()){
             if (ii==0) {
                 holder.txtFileId.setText(" رقم الملف  : " + mylists.get(position).getFileStudentId());
                 holder.txtNameStudent.setText("الاسم :" + mylists.get(position).getStudentName());
                 holder.txt.setText("hj" + mylists.get(position).getFileNote());
                 holder.txtSectionName.setText("رقم الصف" + mylists.get(position).getSemesterNewId());
                 holder.txtDateReg.setText("تاريخ التسجيل" + mylists.get(position).getFileDateReg());
                 holder.txtFileSt.setText("حاله الدراسه" + mylists.get(position).getFileStat());
             }else {
                 holder.txtFileId.setText(" رقم الملف  : "+mylists.get(position).getFileStudentId());
                 holder.txtNameStudent.setText("اسم القصل :"+mylists.get(position).getSemesterName());
                 holder.txt.setText("رقم الغام" + mylists.get(position).getYearId());
                 holder.txtSectionName.setText("ناريح البداية  " + mylists.get(position).getSemesterStDate());
                 holder.txtDateReg.setText("تاريخ التسجيل" + mylists.get(position).getFileDateReg());
                 holder.txtFileSt.setText("تاريخ النهاية " + mylists.get(position).getSemesterEndDate());
                 holder.txtNameStudent.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View view) {
                         Intent intent=new Intent(activity, FileStudentSemester.class);
                         activity.startActivity(intent);
                     }
                 });
             }}

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
        private TextView     txtFileId,txtNameStudent,txt,txtDateReg,txtSectionName,txtFileSt;

        // textTitle,textHeader,textSubtitle

        private LinearLayoutCompat linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtFileId = itemView.findViewById(R.id.txtFileId);
            txtNameStudent = itemView.findViewById(R.id.txtNameStudent);
            txtDateReg= itemView.findViewById(R.id.txtDateReg);
            txtSectionName = itemView.findViewById(R.id.txtSectionName);
            txtFileSt = itemView.findViewById(R.id.txtFileSt);
            txt= itemView.findViewById(R.id.txt);
//            linearLayout= itemView.findViewById(R.id.item_container);
        }
    }
    public void updateList( List<FileStudent> newList) {
        // on below line we are clearing
        // our notes array list
       // mylists.clear();
        // on below line we are adding a
        // new list to our all notes list.
        mylists.addAll(newList);
        // on below line we are calling notify data
        // change method to notify our adapter.
        notifyDataSetChanged();
    }
}


