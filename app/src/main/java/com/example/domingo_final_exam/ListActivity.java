package com.example.domingo_final_exam;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.ListView;
import java.util.List;
                                                                    //GAYAHIN NIYO LANG LAHAT TO PALITAN LANG MGA NEED PALITAN
public class ListActivity extends AppCompatActivity {
    DBHelper helper;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        helper = new DBHelper(this);
        setContentView(R.layout.activity_list_view);
        List<student> studentList = helper.getAllStudent();

        StudentAdapter adapter = new StudentAdapter(this,R.layout.activity_list, studentList);
        listView =  findViewById(R.id.lvStudents);
        listView.setAdapter(adapter);
    }
}
