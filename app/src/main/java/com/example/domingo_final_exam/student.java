package com.example.domingo_final_exam;

public class student {

    private int id;
    private String fName;
    private String lName;
    public student(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }


    public student(int id, String fName, String lName) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
    }
}
