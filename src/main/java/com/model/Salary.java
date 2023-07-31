package com.model;

import java.io.Serializable;

public class Salary implements Serializable {
    private int pno;
    private double basesal;
    private double postallow;
    private double lunchsub;
    private double overtimepay;
    private double fullattend;
    private double socialsec;
    private double accufund;
    private double tax;
    private double punish;
    private String date;

    public int getPno() {
        return pno;
    }

    public void setPno(int pno) {
        this.pno = pno;
    }

    public double getBasesal() {
        return basesal;
    }

    public void setBasesal(double basesal) {
        this.basesal = basesal;
    }

    public double getPostallow() {
        return postallow;
    }

    public void setPostallow(double postallow) {
        this.postallow = postallow;
    }

    public double getLunchsub() {
        return lunchsub;
    }

    public void setLunchsub(double lunchsub) {
        this.lunchsub = lunchsub;
    }

    public double getOvertimepay() {
        return overtimepay;
    }

    public void setOvertimepay(double overtimepay) {
        this.overtimepay = overtimepay;
    }

    public double getFullattend() {
        return fullattend;
    }

    public void setFullattend(double fullattend) {
        this.fullattend = fullattend;
    }

    public double getSocialsec() {
        return socialsec;
    }

    public void setSocialsec(double socialsec) {
        this.socialsec = socialsec;
    }

    public double getAccufund() {
        return accufund;
    }

    public void setAccufund(double accufund) {
        this.accufund = accufund;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getPunish() {
        return punish;
    }

    public void setPunish(double punish) {
        this.punish = punish;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
