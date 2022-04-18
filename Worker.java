/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.georgenakashyan.lab1.homework3;

import com.google.gson.annotations.SerializedName;

/**
 *This class simulates workers, keeping track of their names, hours, and rates.
 * @author George Nakashyan
 */
public class Worker {
    
    @SerializedName("name")
    protected String name;
    
    @SerializedName("hours")
    protected double hours;
    
    @SerializedName("rate")
    protected double rate;
    
    @SerializedName("hireDate")
    protected MyDate hireDate;
    
    /**
      * Default constructor for Worker.
      * Sets Name to "NONAME".
      * Sets hours to 0.0.
      * Sets rate to 0.0.
      */
    public Worker() {
        name = "NONAME";
        hours = 0.0;
        rate = 0.0;
        hireDate = new MyDate();
    }
    
    /**
     * Returns name of Worker object.
     * @return name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns hours of Worker object.
     * @return hours
     */
    public double getHours() {
        return hours;
    }
    
    /**
     * Returns rate of Worker object.
     * @return rate
     */
    public double getRate() {
        return rate;
    }
    
    /**
     * Returns hireDate.
     * @return hireDate.
     */
    public MyDate getHireDate() {
        return hireDate;
    }
    
    /**
     * Sets Name of Worker object.
     * @param name the new name to be assigned to the Worker object's Name.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Sets Name of Worker object.
     * @param hours the new hours to be assigned to the Worker object's hours.
     */
    public void setHours(double hours) {
        this.hours = hours;
    }
    
    /**
     * Sets Name of Worker object.
     * @param rate the new rate to be assigned to the Worker object's rate.
     */
    public void setRate(double rate) {
        this.rate = rate;
    }
    
    /**
     * Sets hireDate with another MyDate object.
     * @param hireDate.
     */
    public void setHireDate(MyDate hireDate) {
        this.hireDate.setMonth(hireDate.getMonth());
        this.hireDate.setDay(hireDate.getDay());
        this.hireDate.setYear(hireDate.getYear());
    }
    
    /**
     * Sets hireDate with a month, day, and year parameter.
     * @param m for months.
     * @param d for days.
     * @param y for years.
     */
    public void setHireDate(int m, int d, int y) {
        hireDate.setMonth(m);
        hireDate.setDay(d);
        hireDate.setYear(y);
    }
}
