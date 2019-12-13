package com.example.domingo_final_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListVIew extends AppCompatActivity {
    DBHelper helper;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        List<student> studentList = helper.getAllStudent();

        StudentAdapter adapter = new StudentAdapter(this,R.layout.activity_list, studentList);
        listView =  findViewById(R.id.lvStudents);
        listView.setAdapter(adapter);
    }
}
