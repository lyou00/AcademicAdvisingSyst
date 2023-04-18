package com.student.academicadvisingsyst.TecahrOp.AdapterTechar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.student.academicadvisingsyst.AdminOP.Models.Attendance;
import com.student.academicadvisingsyst.AdminOP.Models.Section;
import com.student.academicadvisingsyst.AdminOP.View.DailyScheduleView;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelAttendance;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelSection;
import com.student.academicadvisingsyst.R;
import com.student.academicadvisingsyst.StudentOp.AdapterStudent.AdapterFileStudentStudent;
import com.student.academicadvisingsyst.TecahrOp.View.AttendanceNew;

import java.util.List;

public class AdapterSectionFile extends RecyclerView.Adapter<AdapterSectionFile.ViewHolder> {
    private List<Section>mylists;
   // private ProductFragment productFragment;
   // private ProductPageByCategoryFragment productPageByCategoryFragment;
    private Context activity;
    public AdapterSectionFile(List<Section> mylists) {
        this.mylists = mylists;
    }

    public AdapterSectionFile(List<Section> mylists, Context activity) {
        this.mylists = mylists;
        this.activity = activity;
    }
    long pid=0;
    public AdapterSectionFile(List<Section> mylists, Context activity, long pid) {
        this.mylists = mylists;
        this.activity = activity;
        this.pid=pid;
    }
    ViewModelAttendance viewModel;
    @NonNull
    @Override
    public AdapterSectionFile.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
      //  View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.ud, parent);
        if (viewType == VIEW_TYPE_EMPTY){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.empty_data, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_itemattend,parent,false);
        }
        return new ViewHolder(view);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull AdapterSectionFile.ViewHolder holder, int position) {
        if (!mylists.isEmpty()){
                holder.txtFileId.setText(" رقم الملف  : " + mylists.get(position).getFileStudentId());
                holder.txtNameStudent.setText("الاسم :" + mylists.get(position).getStudentName());
                holder.txt.setText("رقم تسجيل الشعبة" + mylists.get(position).getSubSubjectId());
                holder.txtSectionName.setText("اسم الشعبة" + mylists.get(position).getSectionName());


                holder.buTrue.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        viewModel = new ViewModelProvider((ViewModelStoreOwner) activity).get(ViewModelAttendance.class);
                        viewModel.init();

                        Attendance attendance = new Attendance();
                        attendance.setSubSubjectId(mylists.get(position).getSubSubjectId());
                        attendance.setAttendanceId(pid);
                        attendance.setAttendanceRes("حاضر");


                        viewModel.createAttendancet(activity, attendance);


                    }
                });

                holder.btFalse.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        viewModel = new ViewModelProvider((ViewModelStoreOwner) activity).get(ViewModelAttendance.class);
                        viewModel.init();

                        Attendance attendance = new Attendance();
                        attendance.setSubSubjectId(mylists.get(position).getSubSubjectId());
                        attendance.setAttendanceId(pid);
                        attendance.setAttendanceRes("غايب");


                        viewModel.createAttendancet(activity, attendance);


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
        private Button buTrue,btFalse;
        private TextView     txtFileId,txtNameStudent,txt,txtDateReg,txtSectionName,txtFileSt;

        // textTitle,textHeader,textSubtitle

        private LinearLayoutCompat linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtFileId = itemView.findViewById(R.id.txtFileId);
            txtNameStudent = itemView.findViewById(R.id.txtNameStudent);
            txtSectionName = itemView.findViewById(R.id.txtSectionName);
            txt= itemView.findViewById(R.id.txt);
          linearLayout= itemView.findViewById(R.id.item_container);
            buTrue= itemView.findViewById(R.id.btTrue);
            btFalse= itemView.findViewById(R.id.btFalse);


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


