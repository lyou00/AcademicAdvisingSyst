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
import com.student.academicadvisingsyst.AdminOP.View.DailyScheduleNew;
import com.student.academicadvisingsyst.AdminOP.View.DailyScheduleView;
import com.student.academicadvisingsyst.R;
import com.student.academicadvisingsyst.StudentOp.ui.DailyScheduleStudentView;

import java.util.List;

public class AdapterSectionStudent extends RecyclerView.Adapter<AdapterSectionStudent.ViewHolder> {
    private List<Section>mylists;
   // private ProductFragment productFragment;
   // private ProductPageByCategoryFragment productPageByCategoryFragment;
    private Context activity;
    public AdapterSectionStudent(List<Section> mylists) {
        this.mylists = mylists;
    }

    public AdapterSectionStudent(List<Section> mylists, Context activity) {
        this.mylists = mylists;
        this.activity = activity;
    }
    int pid=0;
    long fileId;
    public AdapterSectionStudent(List<Section> mylists, Context activity, int pid,long fileId) {
        this.mylists = mylists;
        this.activity = activity;
        this.pid=pid;
        this.fileId=fileId;
    }
    @NonNull
    @Override
    public AdapterSectionStudent.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        if (viewType == VIEW_TYPE_EMPTY){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.empty_data, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.section_student,parent,false);
        }
        return new ViewHolder(view);
    }

    public int res=0;
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull AdapterSectionStudent.ViewHolder holder, int position) {
        if (!mylists.isEmpty()) {

            if (pid == 0) {
                holder.txtSectionNme.setText("اسم الشعبة : " + mylists.get(position).getSectionName());
                holder.txtNameSubject.setText(" اسم المادة :" + mylists.get(position).getSubjectNameAr());
                holder.txtTecherName.setText(" المدرب :" + mylists.get(position).getTecharName());
                holder.txtTypeSection.setText(" نوع الشعبة :" + mylists.get(position).getSectionType());
            } else if (pid == 1) {

                if (mylists.get(0).getStatusRes() != null) {
                    res = 1;
                }

                holder.txtSectionNme.setText("اسم الشعبة : " + mylists.get(position).getSectionId());
                holder.txtNameSubject.setText(" اسم المادة :" + mylists.get(position).getSubjectNameAr());
                holder.txtTecherName.setText(" المدرب :" + mylists.get(position).getTecharName());
                holder.txtTypeSection.setText(" نوع الشعبة :" + mylists.get(position).getSectionType());

                if (mylists.get(position).getStatusRes() == null) {
                    holder.txt.setText("لم يلتحق");


                } else {
                    holder.txt.setText("التحق");

                }

                //Toast.makeText(activity, "a"+mylists.size(), Toast.LENGTH_SHORT).show();

            }


            holder.viewDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(activity, DailyScheduleStudentView.class);
                    Toast.makeText(activity, "" + mylists.get(position).getSectionId(), Toast.LENGTH_SHORT).show();
                    intent.putExtra("SectionId", mylists.get(position).getSectionId());
                    intent.putExtra("SectionName", mylists.get(position).getSectionName());
                    intent.putExtra("SubjectName", mylists.get(position).getSubjectNameAr());
                    intent.putExtra("TecharName", mylists.get(position).getTecharName());
                    intent.putExtra("res", res);

                    intent.putExtra("fileId", fileId);

                    activity.startActivity(intent);
                }
            });
            //        holder.iconAddWatchlist.setOnClickListener(new View.OnClickListener() {
            //            @Override
            //            public void onClick(View view) {
            //                Intent intent=new Intent(activity, DailyScheduleNew.class);
            //                Toast.makeText(activity, ""+mylists.get(position).getSectionId(), Toast.LENGTH_SHORT).show();
            //                intent.putExtra("SectionId",mylists.get(position).getSectionId()+"");
            //                intent.putExtra("SectionName",mylists.get(position).getSectionName());
            //                intent.putExtra("SubjectName",mylists.get(position).getSubjectNameAr());
            //                intent.putExtra("TecharName",mylists.get(position).getTecharName());
            //
            //                activity.startActivity(intent);
            //            }
            //        });

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

        Button viewDate;
       // textTitle,textHeader,textSubtitle

        private LinearLayoutCompat linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtSectionNme = itemView.findViewById(R.id.txtSectionNme);
            txtTecherName = itemView.findViewById(R.id.txtTecherName);
            txtNameSubject= itemView.findViewById(R.id.txtNameSubject);
            txtTypeSection=itemView.findViewById(R.id.txtTypeSection);
            txt=itemView.findViewById(R.id.txt);
            viewDate=itemView.findViewById(R.id.viewDate);
            //iconAddWatchlist=itemView.findViewById(R.id.iconAddWatchlist);

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


