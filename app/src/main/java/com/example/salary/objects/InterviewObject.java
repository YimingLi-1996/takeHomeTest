package com.example.salary.objects;

import java.util.ArrayList;

public class InterviewObject extends BaseObject {

    private String employerName;
    private String jobTitle;
    private String location;
    private String processAnswer;
    private String processDifficulty;
    private String squareLogo;
    private String processOverallExperience;
    private ArrayList<QuestionObject> questions;


    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProcessAnswer() {
        return processAnswer;
    }

    public void setProcessAnswer(String processAnswer) {
        this.processAnswer = processAnswer;
    }

    public String getSquareLogo() {
        return squareLogo;
    }

    public void setSquareLogo(String squareLogo) {
        this.squareLogo = squareLogo;
    }

    public ArrayList<QuestionObject> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<QuestionObject> questions) {
        this.questions = questions;
    }

    public String getProcessDifficulty() {
        return processDifficulty;
    }

    public void setProcessDifficulty(String processDifficulty) {
        this.processDifficulty = processDifficulty;
    }

    public String getProcessOverallExperience() {
        return processOverallExperience;
    }

    public void setProcessOverallExperience(String processOverallExperience) {
        this.processOverallExperience = processOverallExperience;
    }
}
