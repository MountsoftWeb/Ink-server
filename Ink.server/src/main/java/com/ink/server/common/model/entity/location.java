package com.ink.common.model.entity;

/**
 * @author Created by carlos
 */
public class location {
    private Integer id;
    private String locationName;

    public location() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public location(Integer id, String locationName) {
        this.id = id;
        this.locationName = locationName;
    }
}
