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

import com.student.academicadvisingsyst.AdminOP.Models.Techars;
import com.student.academicadvisingsyst.AdminOP.View.UserNew;
import com.student.academicadvisingsyst.R;
import com.student.academicadvisingsyst.AdminOP.View.TecherDetails;

import java.util.List;

public class AdapterTechars extends RecyclerView.Adapter<AdapterTechars.ViewHolder> {
    private List<Techars>mylists;
   // private ProductFragment productFragment;
   // private ProductPageByCategoryFragment productPageByCategoryFragment;
    private Context activity;

    int type=0;
    public AdapterTechars(List<Techars> mylists) {
        this.mylists = mylists;
    }

    public AdapterTechars(List<Techars> mylists, Context activity,int type) {
        this.mylists = mylists;
        this.activity = activity;
        this.type=type;
    }

    @NonNull
    @Override
    public AdapterTechars.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;

        if (viewType == VIEW_TYPE_EMPTY){
            Toast.makeText(activity, "empty", Toast.LENGTH_SHORT).show();
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.empty_data, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.liststu,parent,false);
        }

        return new ViewHolder(view);
    }

    String typeTi="";
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull AdapterTechars.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        if (!mylists.isEmpty()){
                if(type==1){
                    typeTi="اسم المدرب";
                }else if(type==2){
                    typeTi="اسم المرشد";
                }
                holder.textView.setText(typeTi+"  "+mylists.get(position).getTecharName());
                holder.txv_user_age.setText("العنوان :"+mylists.get(position).getTecharAddress());
                holder.txv_job_title.setText(" الهاتف "+mylists.get(position).getTypeChar());
                if(mylists.get(position).getUserId()==0){
                    holder.buttonuserid.setVisibility(View.VISIBLE);

                }
                else {
                    holder.buttonuserid.setVisibility(View.INVISIBLE);

                }

                holder.buttonuserid.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(activity, UserNew.class);
                        intent.putExtra("Id",mylists.get(position).getTecharId());
                        intent.putExtra("type","مدرب");
                        intent.putExtra("Name",mylists.get(position).getTecharName());
                        activity.startActivity(intent);



                    }
                });
                holder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = null;
                        if(type==1){
                         intent = new Intent(activity, TecherDetails.class);
                        }else if(type==2){
                             intent = new Intent(activity, TecherDetails.class);
                        }

                        intent.putExtra("TecharId",mylists.get(position).getTecharId());
                        intent.putExtra("TecharName",mylists.get(position).getTecharName());

                        intent.putExtra("TypeChar",mylists.get(position).getTypeChar());
                        intent.putExtra("TecharPhone",mylists.get(position).getTecharPhone());
                        intent.putExtra("TecharAddress",mylists.get(position).getTecharAddress());
                        intent.putExtra("Specialization",mylists.get(position).getSpecialization());
                        intent.putExtra("Sex",mylists.get(position).getSex());
                        intent.putExtra("NationalId",mylists.get(position).getNationalId());
                        intent.putExtra("Note",mylists.get(position).getNote());

        //                Bundle bundle=new Bundle();
        //                bundle.putParcelable("techar", mylists.get(position));
                      //  goInput.putExtra
                       // intent.putExtras(bundle);



                        Toast.makeText(activity, "a"+mylists.get(position).getTypeChar(), Toast.LENGTH_SHORT).show();
                        activity.startActivity(intent);
                    }
                });
        }
    }
    private static final int VIEW_TYPE_MEDICINE = 0;
    private static final int VIEW_TYPE_EMPTY = 1;
    @Override
    public int getItemViewType(int position) {
        if (mylists== null) {
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
        private Button buttonuserid;
       // textTitle,textHeader,textSubtitle

        private LinearLayoutCompat linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textHeader);
           txv_job_title = itemView.findViewById(R.id.textTitle);
            txv_user_age= itemView.findViewById(R.id.textSubtitle);
            buttonuserid= itemView.findViewById(R.id.buttonuserid);


//            linearLayout= itemView.findViewById(R.id.item_container);
        }
    }
    public void updateList( List<Techars> newList) {
        // on below line we are clearing
        // our notes array list
//        if(!mylists.isEmpty()){
//       mylists.clear();}
        // on below line we are adding a
        // new list to our all notes list.
        mylists.addAll(newList);
        // on below line we are calling notify data
        // change method to notify our adapter.
        notifyDataSetChanged();
    }
}


