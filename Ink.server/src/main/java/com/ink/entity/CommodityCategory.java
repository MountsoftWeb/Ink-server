package com.ink.entity;

public class CommodityCategory {
    private Integer id;
    private String name;

    public CommodityCategory() {

    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public CommodityCategory(Integer id, String name) {
        this.setId(id);
        this.setName(name);
    }
}