package com.student.academicadvisingsyst.AdminOP.Adapter;

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

import com.student.academicadvisingsyst.AdminOP.Models.Subjects;
import com.student.academicadvisingsyst.AdminOP.View.SectionView;
import com.student.academicadvisingsyst.R;
import com.student.academicadvisingsyst.StudentOp.SectionViewStudent;

import java.util.List;

public class AdapterSubjects extends RecyclerView.Adapter<AdapterSubjects.ViewHolder> {
    private List<Subjects>mylists;
   // private ProductFragment productFragment;
   // private ProductPageByCategoryFragment productPageByCategoryFragment;
    private Context activity;

    public AdapterSubjects(List<Subjects> mylists) {
        this.mylists = mylists;
    }

    public AdapterSubjects(List<Subjects> mylists, Context activity) {
        this.mylists = mylists;
        this.activity = activity;
    }

    int ac=0;
    public AdapterSubjects(List<Subjects> mylists, Context activity,int act) {
        this.mylists = mylists;
        this.activity = activity;
        this.ac=act;
    }
    @NonNull
    @Override
    public AdapterSubjects.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;

        if (viewType == VIEW_TYPE_EMPTY){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.empty_data, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subjectlist,parent,false);
        }
        return new ViewHolder(view);
    }

    long id;
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull AdapterSubjects.ViewHolder holder, int position) {
        if (!mylists.isEmpty()){

            holder.codesub.setText("رمز المادة : "+mylists.get(position).getSubjectCode());
                holder.txtNameSubject.setText("اسم المادة  :"+mylists.get(position).getSubjectNameAr());
                holder.txtSubjectType.setText("نوع المادة"+mylists.get(position).getSubjectType());
                holder.txtSubjectdmends.setText("الفصل  :"+mylists.get(position).getSemesterName());
                holder.txtNameSubjectParnId.setText("عدد الساعات "+mylists.get(position).getCountTime());
                if(mylists.get(position).getSubjectDemand()==2){
                    holder.txtSubjectParnet.setText("متطلب  :"+mylists.get(position).getParentName());

                }else{
                    holder.txtSubjectParnet.setText("لايوجد متطلب  :");

                }

                holder.txtNameSubjectParnId.setText("عدد الساعات العملي"+mylists.get(position).getPractical());
               // Toast.makeText(activity, "a"+mylists.get(position).getStudentName(), Toast.LENGTH_SHORT).show();
                holder.iconAddWatchlist2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent=new Intent(activity, SectionView.class);


                        id=mylists.get(position).getSubjectId();

                        Toast.makeText(activity, "aa"+mylists.get(position).getSubjectId(), Toast.LENGTH_SHORT).show();
                        intent.putExtra("subjectId",mylists.get(position).getSubjectId());
                        Toast.makeText(activity, "aa"+mylists.get(position).getSubjectId(), Toast.LENGTH_SHORT).show();

                        intent.putExtra("SubjectName",mylists.get(position).getSubjectNameAr());

                        activity.startActivity(intent);
                    }
                });
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
        private ImageView iconAddWatchlist2;
        private TextView  codesub, txtNameSubject , txtNameSubjectParnId,txtSubjectdmends,txtSubjectType,txtPar,txtSubjectParnet;
       // textTitle,textHeader,textSubtitle

        private LinearLayoutCompat linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iconAddWatchlist2=itemView.findViewById(R.id.iconAddWatchlist2);
            codesub = itemView.findViewById(R.id.codesub);
            txtNameSubject = itemView.findViewById(R.id.txtNameSubject);
            txtNameSubjectParnId= itemView.findViewById(R.id.txtNameSubjectParnId);
            txtSubjectdmends = itemView.findViewById(R.id.txtSubjectdmends);
            txtSubjectType = itemView.findViewById(R.id.txtSubjectType);
            txtPar= itemView.findViewById(R.id.txtPar);
            txtSubjectParnet= itemView.findViewById(R.id.txtSubjectParnet);
//            linearLayout= itemView.findViewById(R.id.item_container);
        }
    }
    public void updateList( List<Subjects> newList) {
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


