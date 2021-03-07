package com.example.salary.objects;

import com.example.salary.objects.BaseObject;
import com.example.salary.objects.BasePayObject;

public class SalaryObject  extends BaseObject {

    private String employerName;
    private String employmentStatus;
    private String jobTitle;
    private String location;
    private String payPeriod;
    private String reviewDateTime;
    private String sqLogoUrl;
    private String payDeltaPercent;
    private BasePayObject basePay;
    private BasePayObject meanBasePay;




    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
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

    public String getPayPeriod() {
        return payPeriod;
    }

    public void setPayPeriod(String payPeriod) {
        this.payPeriod = payPeriod;
    }

    public String getReviewDateTime() {
        return reviewDateTime;
    }

    public void setReviewDateTime(String reviewDateTime) {
        this.reviewDateTime = reviewDateTime;
    }

    public String getSqLogoUrl() {
        return sqLogoUrl;
    }

    public void setSqLogoUrl(String sqLogoUrl) {
        this.sqLogoUrl = sqLogoUrl;
    }

    public String getPayDeltaPercent() {
        return payDeltaPercent;
    }

    public void setPayDeltaPercent(String payDeltaPercent) {
        this.payDeltaPercent = payDeltaPercent;
    }

    public BasePayObject getBasePay() {
        return basePay;
    }

    public void setBasePay(BasePayObject basePay) {
        this.basePay = basePay;
    }

    public BasePayObject getMeanBasePay() {
        return meanBasePay;
    }

    public void setMeanBasePay(BasePayObject meanBasePay) {
        this.meanBasePay = meanBasePay;
    }
}
