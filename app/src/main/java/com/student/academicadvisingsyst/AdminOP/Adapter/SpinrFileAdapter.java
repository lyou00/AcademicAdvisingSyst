package com.student.academicadvisingsyst.AdminOP.Adapter;


import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.student.academicadvisingsyst.AdminOP.Models.FileStudent;

import java.util.List;

public class SpinrFileAdapter extends ArrayAdapter<FileStudent> {

    // Your sent context
    private Context context;
    // Your custom values for the spinner (User)
    private List<FileStudent> values;

    public SpinrFileAdapter(Context context, int textViewResourceId,
                            List<FileStudent> values) {
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
    public FileStudent getItem(int position){
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
        // I created a dynamic TextView here, but you can reference your own  custom layout for each spinner item
        TextView label = (TextView) super.getView(position, convertView, parent);
        label.setTextColor(Color.BLACK);
        // Then you can get the current item using the values array (Users array) and the current position
        // You can NOW reference each method you has created in your bean object (User class)
        label.setText(values.get(position).getStudentName()+"");

        Toast.makeText(context, ""+values.get(position).getStudentId(), Toast.LENGTH_SHORT).show();
        // And finally return your dynamic (or custom) view for each spinner item
        return label;
    }

    // And here is when the "chooser" is popped up
    // Normally is the same view, but you can customize it if you want
    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        TextView label = (TextView) super.getDropDownView(position, convertView, parent);
    //    label.setTextColor(Color.BLACK);
        label.setText(values.get(position).getStudentName()+"");

        return label;
    }
}

