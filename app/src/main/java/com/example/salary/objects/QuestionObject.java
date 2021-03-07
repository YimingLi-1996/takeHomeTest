package com.example.salary.objects;

import java.io.Serializable;
import java.util.ArrayList;

public class QuestionObject implements Serializable {
    private String question;
    private ArrayList<ResponseObject> responses;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<ResponseObject> getResponses() {
        return responses;
    }

    public void setResponses(ArrayList<ResponseObject> responses) {
        this.responses = responses;
    }
}
