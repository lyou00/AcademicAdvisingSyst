package com.student.academicadvisingsyst.TecahrOp.AdapterTechar;

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

import com.student.academicadvisingsyst.AdminOP.Models.Attendance;
import com.student.academicadvisingsyst.AdminOP.Models.Section;
import com.student.academicadvisingsyst.AdminOP.View.DailyScheduleView;
import com.student.academicadvisingsyst.R;
import com.student.academicadvisingsyst.StudentOp.AdapterStudent.AdapterFileStudentStudent;
import com.student.academicadvisingsyst.TecahrOp.View.ViewStudentInSection;

import java.util.List;

public class AdapterAttendce extends RecyclerView.Adapter<AdapterAttendce.ViewHolder> {
    private List<Attendance>mylists;
   // private ProductFragment productFragment;
   // private ProductPageByCategoryFragment productPageByCategoryFragment;
    private Context activity;
    public AdapterAttendce(List<Attendance> mylists) {
        this.mylists = mylists;
    }

    public AdapterAttendce(List<Attendance> mylists, Context activity) {
        this.mylists = mylists;
        this.activity = activity;
    }
    long pid=0;
    public AdapterAttendce(List<Attendance> mylists, Context activity, long pid) {
        this.mylists = mylists;
        this.activity = activity;
        this.pid=pid;
    }
    @NonNull
    @Override
    public AdapterAttendce.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        if (viewType == VIEW_TYPE_EMPTY){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.empty_data, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_sectio_techar,parent,false);
        }
        return new ViewHolder(view);

   }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull AdapterAttendce.ViewHolder holder, int position) {
        if (!mylists.isEmpty()) {
            holder.txtnameSubject.setText("رقم المحاضرة  : " + mylists.get(position).getAttendanceId());
            holder.txtSectionNme.setText(" تاريخ المحاضرة   :" + mylists.get(position).getAttendanceDate());
            holder.btFileStudent.setText("تحضير الطلاب");

            holder.btFileStudent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(activity, ViewStudentInSection.class);
                   // Toast.makeText(activity, "" + mylists.get(position).getAttendanceId(), Toast.LENGTH_SHORT).show();
                    intent.putExtra("AttendanceId", mylists.get(position).getAttendanceId());
                    intent.putExtra("SectionId", pid);



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
        private TextView txtnameSubject ,txtSectionNme,txtcountStudent;

        Button btFileStudent;
       // textTitle,textHeader,textSubtitle

        private LinearLayoutCompat linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtSectionNme = itemView.findViewById(R.id.txtSectionNme);
            txtnameSubject = itemView.findViewById(R.id.txtnameSubject);
          //  txtcountStudent= itemView.findViewById(R.id.txtcountStudent);
            btFileStudent=itemView.findViewById(R.id.btFileStudent);
            iconAddWatchlist=itemView.findViewById(R.id.iconAddWatchlist);

            //add=binding.iconAddWahlist;
//            linearLayout= itemView.findViewById(R.id.item_container);
        }
    }
    public void updateList( List<Attendance> newList) {
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


