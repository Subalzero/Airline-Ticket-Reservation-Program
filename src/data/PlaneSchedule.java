/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Acer
 */
public class PlaneSchedule implements java.io.Serializable {
    private String name;
    private String destination;
    private String departTime;
    private String departDate;
    
    public PlaneSchedule(String n, String d, String dt, String dd) {
        name = n;
        destination = d;
        departTime = dt;
        departDate = dd;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDestination() {
        return destination;
    }
    
    public String getDate() {
        return departDate;
    }
    
    public String getTime() {
        return departTime;
    }
    
    public void setName(String n) {
        name = n;
    }
    
    public void setDestination(String d) {
        destination = d;
    }
    
    public void setDate(String dd) {
        departDate = dd;
    }
    
    public void setTime(String dt) {
        departTime = dt;
    }
}
