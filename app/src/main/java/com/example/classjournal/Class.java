package com.example.classjournal;


import java.io.Serializable;

public class Class implements Serializable {
    private String week;
    private String grade;

    public Class(String week, String grade) {
        this.week = week;
        this.grade = grade;
    }

    public String getWeek()
    {
         return week;
    }
    public String getGrade()
    {
          return grade;
    }
 }

