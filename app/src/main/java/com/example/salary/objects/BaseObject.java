package com.example.salary.objects;

import java.io.Serializable;

public class BaseObject implements Serializable {
    String type;
    private String attributionURL;

    public String getAttributionURL() {
        return attributionURL;
    }

    public void setAttributionURL(String attributionURL) {
        this.attributionURL = attributionURL;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
