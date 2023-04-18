package com.student.academicadvisingsyst.StudentOp.AdapterStudent;

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

import java.util.List;

public class AdapterSectionAttend extends RecyclerView.Adapter<AdapterSectionAttend.ViewHolder> {
    private List<Section>mylists;
   // private ProductFragment productFragment;
   // private ProductPageByCategoryFragment productPageByCategoryFragment;
    private Context activity;
    public AdapterSectionAttend(List<Section> mylists) {
        this.mylists = mylists;
    }

    public AdapterSectionAttend(List<Section> mylists, Context activity) {
        this.mylists = mylists;
        this.activity = activity;
    }
    int pid=0;
    public AdapterSectionAttend(List<Section> mylists, Context activity, int pid) {
        this.mylists = mylists;
        this.activity = activity;
        this.pid=pid;
    }
    @NonNull
    @Override
    public AdapterSectionAttend.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        if (viewType == VIEW_TYPE_EMPTY){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.empty_data, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_media_long,parent,false);
        }
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull AdapterSectionAttend.ViewHolder holder, int position) {
        if (!mylists.isEmpty()) {

            holder.txtdate.setText("التاريخ : " + mylists.get(position).getAttendanceDate());
            holder.txtNameday.setText(" اليوم : " + mylists.get(position).getDayName());

            holder.txtTimeOf.setText("  الى الساعه :" + mylists.get(position).getTimeTo());

            holder.txtTimeTo.setText("  من الساعه :" + mylists.get(position).getTimeOf());
            holder.txtRes.setText(" الحاله :" + mylists.get(position).getResult());


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
        private TextView txtdate,txtNameday,txtTimeOf,txtTimeTo,txtRes;

        ImageView add;
       // textTitle,textHeader,textSubtitle

        private LinearLayoutCompat linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtdate = itemView.findViewById(R.id.txtdate);

            txtNameday = itemView.findViewById(R.id.txtSectionNme);
            txtNameday = itemView.findViewById(R.id.txtNameday);
            txtTimeOf= itemView.findViewById(R.id.txtTimeOf);
            txtTimeTo=itemView.findViewById(R.id.txtTimeTo);
            txtRes=itemView.findViewById(R.id.txtRes);

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


