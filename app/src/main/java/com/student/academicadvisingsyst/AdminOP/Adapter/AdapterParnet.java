package com.student.academicadvisingsyst.AdminOP.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.student.academicadvisingsyst.AdminOP.Models.Student;
import com.student.academicadvisingsyst.R;

import java.util.List;

public class AdapterParnet extends RecyclerView.Adapter<AdapterParnet.ViewHolder> {
    private List<Student>mylists;
   // private ProductFragment productFragment;
   // private ProductPageByCategoryFragment productPageByCategoryFragment;
    private Context activity;

    public AdapterParnet(List<Student> mylists) {
        this.mylists = mylists;
    }

    public AdapterParnet(List<Student> mylists, Context activity) {
        this.mylists = mylists;
        this.activity = activity;
    }

    @NonNull
    @Override
    public AdapterParnet.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
      //  View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.ud, parent);

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view =  inflater.inflate(R.layout.list_item_media_long,parent,false);
        return new ViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull AdapterParnet.ViewHolder holder, int position) {
        holder.textView.setText("اسم المتدرب : "+mylists.get(position).getStudentName());
        holder.txv_user_age.setText("العنوان :"+mylists.get(position).getStudentAdderss());
        holder.txv_job_title.setText("الهاتف"+mylists.get(position).getStudentPhone());
       // Toast.makeText(activity, "a"+mylists.get(position).getStudentName(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public int getItemCount() {
        // Get position of the product
        if (mylists == null) {
            return 0;
        }
        return mylists.size();
    }    public class ViewHolder extends RecyclerView.ViewHolder {
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
    public void updateList( List<Student> newList) {
        // on below line we are clearing
        // our notes array list
//        mylists.clear();
        // on below line we are adding a
        // new list to our all notes list.
        mylists.addAll(newList);
        // on below line we are calling notify data
        // change method to notify our adapter.
        notifyDataSetChanged();
    }
}


