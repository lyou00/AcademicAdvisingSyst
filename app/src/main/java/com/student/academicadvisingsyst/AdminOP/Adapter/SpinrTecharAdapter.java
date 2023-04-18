package com.student.academicadvisingsyst.AdminOP.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.student.academicadvisingsyst.AdminOP.Models.Techars;
import com.student.academicadvisingsyst.R;

import java.util.List;

public class SpinrTecharAdapter extends ArrayAdapter<Techars> {

    // Your sent context
    private Context context;
    // Your custom values for the spinner (User)
    private List<Techars> values;

    public SpinrTecharAdapter(Context context, int textViewResourceId,
                              List<Techars> values) {
        super(context, textViewResourceId, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public int getCount(){

        // Get position of the product
        if (values == null) {
            return 0;
        }
        return values.size();
    }


    @Override
    public Techars getItem(int position){
        return values.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }


    // And the "magic" goes here
    // This is for the "passive" state of the spinner
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        //  View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.ud, parent);

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view =  inflater.inflate(R.layout.subjec,parent,false);
        // I created a dynamic TextView here, but you can reference your own  custom layout for each spinner item
        TextView label = (TextView) view.findViewById(R.id.text1);
        //  TextView labe2 = (TextView) view.findViewById(R.id.txtsuen);

        // Then you can get the current item using the values array (Users array) and the current position
        // You can NOW reference each method you has created in your bean object (User class)
        label.setText(values.get(position).getTecharId()+" "+values.get(position).getTecharName());
        //   labe2.setText(values.get(position).getSubjectNameEn());

        // And finally return your dynamic (or custom) view for each spinner item
        return label;
    }

    // And here is when the "chooser" is popped up
    // Normally is the same view, but you can customize it if you want
    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        View view;
        //  View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.ud, parent);

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view =  inflater.inflate(R.layout.subjec,parent,false);
        TextView label = (TextView) view.findViewById(R.id.text1);

        // Then you can get the current item using the values array (Users array) and the current position
        // You can NOW reference each method you has created in your bean object (User class)
        label.setText(values.get(position).getTecharId()+" "+values.get(position).getTecharName());

        return label;}}