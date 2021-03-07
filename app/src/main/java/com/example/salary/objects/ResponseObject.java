package com.example.salary.objects;

import java.io.Serializable;

public class ResponseObject implements Serializable {
    private String responseText;

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }
}
