/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.georgenakashyan.lab1.homework3;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author George Nakashyan
 */
public class MyDate {
    
    @SerializedName("month")
    private int month;
    
    @SerializedName("day")
    private int day;
    
    @SerializedName("year")
    private int year;
    
    /**
     * Default constructor for MyDate
     * Sets month, day, and year all to 0.
     */
    public MyDate() {
        month = 1;
        day = 1;
        year = 2021;
    }
    
    /**
     * Gets month.
     * @return month.
     */
    public int getMonth() {
        return month;
    }
    
    /**
     * Gets day.
     * @return day.
     */
    public int getDay() {
        return day;
    }
    
    /**
     * Gets year.
     * @return year.
     */
    public int getYear() {
        return year;
    }
    
    /**
     * Sets month.
     * @param month.
     */
    public void setMonth(int month) {
        this.month = month;
    }
    
    /**
     * Sets day.
     * @param day.
     */
    public void setDay(int day) {
        this.day = day;
    }
    
    /**
     * Sets year.
     * @param year.
     */
    public void setYear(int year) {
        this.year = year;
    }
}
