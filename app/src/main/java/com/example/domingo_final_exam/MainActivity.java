package com.example.domingo_final_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.domingo_final_exam.DBHelper;
import com.example.domingo_final_exam.R;

public class MainActivity extends AppCompatActivity {
    EditText fname, lname, id;
    DBHelper helper;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new DBHelper(this);
        fname = findViewById(R.id.etFName);
        lname = findViewById(R.id.etLName);
        id = findViewById(R.id.etId);

    }
    public void addRecord(View v){
        String first = fname.getText().toString();
        String last = lname.getText().toString();
        long isInserted = helper.insert(first, last);
        if(isInserted == -1){
            Toast.makeText(this, "not inserted", Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(this, "inserted", Toast.LENGTH_LONG).show();
        }
    }
    public void moveFirst(View v){
        cursor = helper.getRecords();
        cursor.moveToFirst();
        displayData();
    }
    public void movePrev(View v){
        if(cursor.isFirst()){
            Toast.makeText(this,"this is the first record...",Toast.LENGTH_LONG).show();
        } else{
            cursor.moveToPrevious();
        }
        displayData();
    }
    public void moveNext(View v){
        if(cursor.isLast()){
            Toast.makeText(this,"this is the last record...",Toast.LENGTH_LONG).show();
        } else{
            cursor.moveToNext();
        }
        displayData();
    }
    public void editRecord(View v){
        String first = fname.getText().toString();
        String last = lname.getText().toString();
        String id = cursor.getString(0);
        int numUpdated = helper.update(id, first, last);
    }

    public void deleteRecord(View v){
        String id = cursor.getString(0);
        int numDeleted = helper.delete(id);
        if(numDeleted == 1){
            Toast.makeText(this, "record deleted...",Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "deletion failed ...", Toast.LENGTH_LONG).show();
        }
    }
    private void displayData(){
        id.setText(cursor.getString(0));
        fname.setText(cursor.getString(1));
        lname.setText(cursor.getString(2));
    }

    //ETO YUNG ONCLICK NG VIEW ALL BUTTON, INTENT LANG SIYA PARA MAPUNTA DUN SA MAGLALABAS NG LIST NA 'activity_list'
    public void viewAll(View v){
        Intent intent = new Intent(getApplicationContext(), ListActivity.class);        //ETO YUNG ListActivity.java MAGCCALL NUNG LIST
        startActivity(intent);
    }
}
