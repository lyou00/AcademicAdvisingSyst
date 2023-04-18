package com.student.academicadvisingsyst.TecahrOp.AdapterTechar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.student.academicadvisingsyst.AdminOP.Models.Section;
import com.student.academicadvisingsyst.AdminOP.View.DailyScheduleView;
import com.student.academicadvisingsyst.R;
import com.student.academicadvisingsyst.StudentOp.AdapterStudent.AdapterFileStudentStudent;
import com.student.academicadvisingsyst.TecahrOp.DailyScheduleInTecharView;

import java.util.List;

public class AdapterSectionTeacher extends RecyclerView.Adapter<AdapterSectionTeacher.ViewHolder> {
    private List<Section>mylists;
   // private ProductFragment productFragment;
   // private ProductPageByCategoryFragment productPageByCategoryFragment;
    private Context activity;
    public AdapterSectionTeacher(List<Section> mylists) {
        this.mylists = mylists;
    }

    public AdapterSectionTeacher(List<Section> mylists, Context activity) {
        this.mylists = mylists;
        this.activity = activity;
    }
    int pid=0;
    public AdapterSectionTeacher(List<Section> mylists, Context activity, int pid) {
        this.mylists = mylists;
        this.activity = activity;
        this.pid=pid;
    }
    @NonNull
    @Override
    public AdapterSectionTeacher.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        if (viewType == VIEW_TYPE_EMPTY){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.empty_data, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_sectio_techar_attend,parent,false);
        }
        return new ViewHolder(view);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull AdapterSectionTeacher.ViewHolder holder, int position) {

        if (!mylists.isEmpty()) {
            if (pid == 0) {
                holder.txtnameSubject.setText("اسم المادة : " + mylists.get(position).getSubjectNameAr());
                holder.txtSectionNme.setText(" اسم الشعبة   :" + mylists.get(position).getSectionName());
                //            holder.txtcountStudent.setText("عدد الطلاب"+mylists.get(position).getCountMax());
            } else if (pid == 1) {
                holder.txtnameSubject.setText("اسم المادة : " + mylists.get(position).getSubjectNameAr());
                holder.txtSectionNme.setText(" اسم الشعبة   :" + mylists.get(position).getSectionName());
                holder.txtcountStudent.setText("عدد الطلاب" + mylists.get(position).getCountMax());

            }


            holder.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(activity, DailyScheduleInTecharView.class);
                    Toast.makeText(activity, "" + mylists.get(position).getSectionId(), Toast.LENGTH_SHORT).show();
                    intent.putExtra("SectionId", mylists.get(position).getSectionId());
                    intent.putExtra("SectionName", mylists.get(position).getSectionName());
                    intent.putExtra("SubjectName", mylists.get(position).getSubjectNameAr());
                    intent.putExtra("TecharName", mylists.get(position).getTecharName());

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
            return 1;
        }
        return mylists.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView,iconAddWatchlist;
        private TextView txtnameSubject ,txtSectionNme,txtcountStudent;

        ImageView add;
       // textTitle,textHeader,textSubtitle

        private LinearLayoutCompat linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtSectionNme = itemView.findViewById(R.id.txtSectionNme);
            txtnameSubject = itemView.findViewById(R.id.txtnamesubject);
            txtcountStudent= itemView.findViewById(R.id.txtcount);
            add=itemView.findViewById(R.id.iconAddWahlist);
            iconAddWatchlist=itemView.findViewById(R.id.iconAddWatchlist);
            linearLayout=itemView.findViewById(R.id.layout);

            //add=binding.iconAddWahlist;
//            linearLayout= itemView.findViewById(R.id.item_container);
        }
    }
    @SuppressLint("NotifyDataSetChanged")
    public void updateList(List<Section> newList) {
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


