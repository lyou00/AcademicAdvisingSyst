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

import com.student.academicadvisingsyst.AdminOP.Models.Courses;
import com.student.academicadvisingsyst.R;

import java.util.List;

public class AdapterCourses extends RecyclerView.Adapter<AdapterCourses.ViewHolder> {
    private List<Courses>mylists;
   // private ProductFragment productFragment;
   // private ProductPageByCategoryFragment productPageByCategoryFragment;
    private Context activity;

    public AdapterCourses(List<Courses> mylists) {
        this.mylists = mylists;
    }

    public AdapterCourses(List<Courses> mylists, Context activity) {
        this.mylists = mylists;
        this.activity = activity;
    }

    @NonNull
    @Override
    public AdapterCourses.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
      //  View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.ud, parent);

        if (viewType == VIEW_TYPE_EMPTY){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.empty_data, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_media_long,parent,false);
        }

        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull AdapterCourses.ViewHolder holder, int position) {
        if (!mylists.isEmpty()) {
            holder.textView.setText("اسم الكورس : " + mylists.get(position).getCoursesName());
            holder.txv_user_age.setText(" نوغ الكورس : " + mylists.get(position).getCoursesType());
            holder.txv_job_title.setText("رقم " + mylists.get(position).getSubjectsId());
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
            textView = itemView.findViewById(R.id.textHeader);
            txv_job_title = itemView.findViewById(R.id.textTitle);
            txv_user_age= itemView.findViewById(R.id.textSubtitle);
//            linearLayout= itemView.findViewById(R.id.item_container);
        }
    }
    @SuppressLint("NotifyDataSetChanged")
    public void updateList(List<Courses> newList) {
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


