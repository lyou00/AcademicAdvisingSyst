package com.student.academicadvisingsyst.AdminOP.Adapter;

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

import java.util.List;

public class AdapterSection extends RecyclerView.Adapter<AdapterSection.ViewHolder> {
    private List<Section>mylists;

    private Context activity;
    public AdapterSection(List<Section> mylists) {
        this.mylists = mylists;
    }

    public AdapterSection(List<Section> mylists, Context activity) {
        this.mylists = mylists;
        this.activity = activity;
    }
    int pid=0;
    public AdapterSection(List<Section> mylists, Context activity,int pid) {
        this.mylists = mylists;
        this.activity = activity;
        this.pid=pid;
    }

    @NonNull
    @Override
    public AdapterSection.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;

        if (viewType == VIEW_TYPE_EMPTY){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.empty_data, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_sectio,parent,false);
        }
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull AdapterSection.ViewHolder holder, int position) {
        if (!mylists.isEmpty()){
            if(pid==0){
                holder.txtSectionName.setText("اسم الشعبة : "+mylists.get(position).getSectionName());
                holder.countmax.setText("  العدد الاقصى :"+mylists.get(position).getCountMax());
                holder.txttecharname.setText(" المدرب : "+mylists.get(position).getTecharName());
                holder.countmin.setText("العدد الادنى:"+mylists.get(position).getCountMin());
            }else if(pid==1){
                holder.txtSectionName.setText("اسم الشعبة : "+mylists.get(position).getSectionName());
                holder.countmax.setText("  العدد الاقصى :"+mylists.get(position).getCountMax());
                holder.txttecharname.setText(" المدرب : "+mylists.get(position).getTecharName());
                holder.countmin.setText("العدد الادنى:"+mylists.get(position).getCountMin());

            }



        holder.btview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(activity, DailyScheduleView.class);
                Toast.makeText(activity, ""+mylists.get(position).getSectionId(), Toast.LENGTH_SHORT).show();
                intent.putExtra("SectionId",mylists.get(position).getSectionId());
                intent.putExtra("SectionName",mylists.get(position).getSectionName());
                intent.putExtra("SubjectName",mylists.get(position).getSubjectNameAr());
                intent.putExtra("TecharName",mylists.get(position).getTecharName());

                activity.startActivity(intent);
            }
        });
        holder.وbtvnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(activity, DailyScheduleNew.class);
                Toast.makeText(activity, ""+mylists.get(position).getSectionId(), Toast.LENGTH_SHORT).show();
                intent.putExtra("SectionId",mylists.get(position).getSectionId()+"");
                intent.putExtra("SectionName",mylists.get(position).getSectionName());
                intent.putExtra("SubjectName",mylists.get(position).getSubjectNameAr());
                intent.putExtra("TecharName",mylists.get(position).getTecharName());

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
            return 0;
        }
        return mylists.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView,iconAddWatchlist;
        private TextView            countmin,countmax,txttecharname,txtsectionid,txtSectionName;


        Button btview,وbtvnew;
       // textTitle,textHeader,textSubtitle

        private LinearLayoutCompat linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtsectionid = itemView.findViewById(R.id.txtsectionid);
            txtSectionName = itemView.findViewById(R.id.txtSectionName);
            txttecharname= itemView.findViewById(R.id.txttecharname);
            countmax=itemView.findViewById(R.id.countmax);
            countmin=itemView.findViewById(R.id.countmin);
            btview=itemView.findViewById(R.id.btview);
            وbtvnew=itemView.findViewById(R.id.btvnew);

//            linearLayout= itemView.findViewById(R.id.item_container);
        }
    }
    public void updateList( List<Section> newList) {
        // on below line we are clearing
        // our notes array list
     //  mylists.clear();
        // on below line we are adding a
        // new list to our all notes list.
        mylists.addAll(newList);
        // on below line we are calling notify data
        // change method to notify our adapter.
        notifyDataSetChanged();
    }
}


