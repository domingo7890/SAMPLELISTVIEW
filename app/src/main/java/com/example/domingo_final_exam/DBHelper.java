package com.example.domingo_final_exam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    String col2 = "fName";
    String col3 = "lName";
    public static final String table = "student";
    static final String dbName = "student.db";

    public DBHelper(@Nullable Context context){
        super(context, dbName, null, 1);
        this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + table + "(id INTEGER  PRIMARY KEY AUTOINCREMENT, fName TEXT, lName TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public long insert(String fn, String ln){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(col2, fn);
        cv.put(col3, ln);
        return db.insert(table, null, cv);
    }
    public Cursor getRecords(){
        SQLiteDatabase db = this.getWritableDatabase();
        String selectAll = "SELECT * FROM " + table;
        db.rawQuery(selectAll, null);
        return db.rawQuery(selectAll, null);
    }
    public int update (String id, String fn, String ln){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(col2, fn);
        cv.put(col3, ln);
        return db.update(table, cv, "id = ?", new String[]{id});
    }

    public int delete(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(table,"id = ?", new String[]{id});
    }
    public Cursor viewAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor todoCursor = db.rawQuery("SELECT COUNT(*) FROM " + table, null);
        return todoCursor;
    }


    //ETO YUNG PINAKA IMPORTANT NA MAHALAGANG PART, GAGAWIN NIYONG JAVA OBJECT YUNG MGA NAKUHANG DATA SA DATABASE
    public List<student> getAllStudent() { 
        List<student> studentArrayList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + table; // PALITAN TO NG TABLE NAME NIYO

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                student student = new student();                                //PALITAN NG MGA DAPAT PALITAN NA VARIABLES
                student.setId(Integer.parseInt(cursor.getString(0)));
                student.setfName(cursor.getString(1));
                student.setlName(cursor.getString(2));
                studentArrayList.add(student);
            } while (cursor.moveToNext());
        }

        // return contact list
        return studentArrayList;
    }

}
