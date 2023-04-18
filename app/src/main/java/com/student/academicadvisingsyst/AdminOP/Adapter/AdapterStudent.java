package com.student.academicadvisingsyst.AdminOP.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.student.academicadvisingsyst.AdminOP.Models.Student;
import com.student.academicadvisingsyst.R;
import com.student.academicadvisingsyst.AdminOP.View.StudentDetails;

import java.util.List;

public class AdapterStudent extends RecyclerView.Adapter<AdapterStudent.ViewHolder> {
    private List<Student>mylists;
   // private ProductFragment productFragment;
   // private ProductPageByCategoryFragment productPageByCategoryFragment;
    private Context activity;

    public AdapterStudent(List<Student> mylists) {
        this.mylists = mylists;
    }

    public AdapterStudent(List<Student> mylists, Context activity) {
        this.mylists = mylists;
        this.activity = activity;
    }

    @NonNull
    @Override
    public AdapterStudent.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;

        if (viewType == VIEW_TYPE_EMPTY){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.empty_data, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list,parent,false);
        }
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull AdapterStudent.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        if (!mylists.isEmpty()){
                holder.textView.setText("اسم المتدرب : "+mylists.get(position).getStudentName());
                holder.txv_user_age.setText("العنوان :"+mylists.get(position).getStudentAdderss());
                holder.txv_job_title.setText("الهاتف"+mylists.get(position).getStudentPhone());
                holder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent goInput = new Intent(activity, StudentDetails.class);

                        Bundle bundle=new Bundle();
                        bundle.putParcelable("student", mylists.get(position));
                        //  goInput.putExtra
                        goInput.putExtras(bundle);


                        Toast.makeText(activity, "a"+mylists.get(position).getStudentName(), Toast.LENGTH_SHORT).show();
                        activity.startActivity(goInput);
                    }
                });}

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
        private ImageView imageView;
        private TextView textView ,txv_job_title,txv_user_age;
       // textTitle,textHeader,textSubtitle

        private LinearLayoutCompat linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tvDisplaySingelMedName);
           txv_job_title = itemView.findViewById(R.id.tvDisplaySingleMedInfo);
            txv_user_age= itemView.findViewById(R.id.tvDisplaySingleMedTime);
//            linearLayout= itemView.findViewById(R.id.item_container);
        }
    }
    public void updateList( List<Student> newList) {
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


