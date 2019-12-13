package com.example.domingo_final_exam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import java.util.List;

public class StudentAdapter extends ArrayAdapter<student>{ //MAKE SURE NAKA-EXTEND ARRAYADAPTER<'objectName'> TO
    private Context context;
    private int resources;

    private List<student> studentList; // <<<<<<-------INSTANTIATE NIYO YUNG ARRAY NA PAGLALAGYAN NG OBJECTS NIYO FROM DATABASE
    public StudentAdapter(Context context, int resource, List<student> studentList) {
        super(context, resource, studentList);
        this.context = context;
        this.resources = resource;
        this.studentList = studentList;
    }

    @Override
    public View getView(int i, @Nullable View convertView, @NonNull ViewGroup parent) {

        int id = getItem(i).getId();                                    //PALIT PALITAN NIYO LANG YUNG NAME DITO TSAKA MGA GETTERS (getId, getName, getLName, getTite etc.)
        String fname = getItem(i).getfName();
        String lname = getItem(i).getlName();

        student c = this.studentList.get(i);

        LayoutInflater inflater = LayoutInflater.from(context);                 //WALANG PAPALITAN
        convertView = inflater.inflate(resources, parent, false);    //WALANG PAPALITAN

        TextView tvId = convertView.findViewById(R.id.tvId);
        TextView tvFName = convertView.findViewById(R.id.tvFName);                      //DITO SAME PALITAN NIYO DIN MGA NEED
        TextView tvLName = convertView.findViewById(R.id.tvLName);

        tvLName.setText(c.getlName());
        tvFName.setText(c.getfName());                                                  //SAME HERE
        tvId.setText(Integer.toString(c.getId()));
        return convertView;
    }
}