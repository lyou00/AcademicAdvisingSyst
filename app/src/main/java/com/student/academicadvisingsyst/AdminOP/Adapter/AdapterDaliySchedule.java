package com.student.academicadvisingsyst.AdminOP.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.student.academicadvisingsyst.AdminOP.Models.DailySchedule;
import com.student.academicadvisingsyst.AdminOP.Models.Section;
import com.student.academicadvisingsyst.R;

import java.util.List;

public class AdapterDaliySchedule extends RecyclerView.Adapter<AdapterDaliySchedule.ViewHolder> {
    private List<DailySchedule>mylists;
   // private ProductFragment productFragment;
   // private ProductPageByCategoryFragment productPageByCategoryFragment;
    private Context activity;
    public AdapterDaliySchedule(List<DailySchedule> mylists) {
        this.mylists = mylists;
    }

    public AdapterDaliySchedule(List<DailySchedule> mylists, Context activity) {
        this.mylists = mylists;
        this.activity = activity;
    }

    @NonNull
    @Override
    public AdapterDaliySchedule.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        if (viewType == VIEW_TYPE_EMPTY){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.empty_data, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_daliy,parent,false);
        }


        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull AdapterDaliySchedule.ViewHolder holder, int position) {
        if (!mylists.isEmpty()) {
            holder.textView.setText(" اليوم : " + mylists.get(position).getDayName());
            holder.txv_user_age.setText(" من الساعه  :" + mylists.get(position).getTimeOf());
            holder.txv_job_title.setText("الى الساعه" + mylists.get(position).getTimeTo());
            // Toast.makeText(activity, "a"+mylists.size(), Toast.LENGTH_SHORT).show();

        }
//        holder.add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(activity, DailyScheduleView.class);
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
        private TextView textView ,txv_job_title,txv_user_age;

        ImageView add;
       // textTitle,textHeader,textSubtitle

        private LinearLayoutCompat linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txtNameDay);
           txv_job_title = itemView.findViewById(R.id.txtTimeOf);
            txv_user_age= itemView.findViewById(R.id.txtTimeTo);
            add=itemView.findViewById(R.id.iconAddWahlist);
            //add=binding.iconAddWahlist;
//            linearLayout= itemView.findViewById(R.id.item_container);
        }
    }
    public void updateList( List<DailySchedule> newList) {
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


