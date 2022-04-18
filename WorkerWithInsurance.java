/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import com.google.gson.annotations.*;

/**
 *
 * @author Gevoooo
 */
public class WorkerWithInsurance extends Worker {
    
    @SerializedName("healthInsCost")
    private double healthInsCost;
    
    public WorkerWithInsurance() {
        super();
        healthInsCost = 0.0;
    }
    
    /**
     * Gets Health Insurance Cost.
     * @return healthInsCost.
     */
    public double getHealthInsCost() {
        return healthInsCost;
    }
    
    /**
     * Sets Health Insurance Cost.
     * @param healthInsCost.
     */
    public void setHealthInsCost(double healthInsCost) {
        this.healthInsCost = healthInsCost;
    }
}
