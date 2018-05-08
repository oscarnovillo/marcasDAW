/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author user
 */
public class Arrive {
    
   private String stopId;
   private String busId;
   private String busTimeLeft;
   private String latitude;
   private String longitude;
   private String busPositionType;

    public Arrive() {
    }

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public String getStopId() {
        return stopId;
    }

    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    public String getBusTimeLeft() {
        return busTimeLeft;
    }

    public void setBusTimeLeft(String busTimeLeft) {
        this.busTimeLeft = busTimeLeft;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getBusPositionType() {
        return busPositionType;
    }

    public void setBusPositionType(String busPositionType) {
        this.busPositionType = busPositionType;
    }
 
    
    
}
