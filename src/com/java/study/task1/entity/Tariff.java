package com.java.study.task1.entity;

public class Tariff {
    private String tariffName;
    private double price;
    private int phoneTime;
    private int internet;
    private int sms;

    public String getName() {
        return tariffName;
    }

    public void setName(String tariffName) {
        this.tariffName = tariffName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPhoneTime() {
        return phoneTime;
    }

    public void setPhoneTime(int phoneTime) {
        this.phoneTime = phoneTime;
    }

    public int getInternet() {
        return internet;
    }

    public void setInternet(int internet) {
        this.internet = internet;
    }

    public int getSms() {
        return sms;
    }

    public void setSms(int sms) {
        this.sms = sms;
    }

    @Override
    public String toString() {
        return "Tariff{" +
                "name='" + tariffName + '\'' +
                ", price=" + price +
                ", phoneTime=" + phoneTime +
                ", internet=" + internet +
                ", sms=" + sms +
                '}';
    }

}
