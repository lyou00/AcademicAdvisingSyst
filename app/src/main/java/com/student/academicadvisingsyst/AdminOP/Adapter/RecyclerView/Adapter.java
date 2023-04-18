package com.student.academicadvisingsyst.AdminOP.Adapter.RecyclerView;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.student.academicadvisingsyst.AdminOP.Models.Subjects;
import com.student.academicadvisingsyst.R;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends ArrayAdapter<Subjects> {

    // Your sent context
    private Context context;
    // Your custom values for the spinner (User)
    private List<Subjects> values;

    public Adapter( ArrayList<Subjects> countryList,Context context) {
        super(context, 0, countryList);
        this.context=context;
        this.values=countryList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView label = (TextView) super.getDropDownView(position, convertView, parent);
        label.setTextColor(Color.BLACK);
        label.setPadding(12,6,12,6);
        label.setTextSize(22);
        label.setText(values.get(position).getSubjectNameAr());

        return label;
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.subjec, parent, false
            );
        }

        //ImageView imageViewFlag = convertView.findViewById(R.id.image_view_flag);
        TextView textViewName = convertView.findViewById(R.id.txsubar);

        Subjects currentItem = getItem(position);

        if (currentItem != null) {
           // imageViewFlag.setImageResource(currentItem.getFlagImage());
            textViewName.setText(values.get(position).getSubjectNameAr());
        }

        return convertView;
    }
}