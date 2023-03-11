package com.java.study.task2.entity;

public class Tariff {
    private long id;
    private String tariffName;
    private double price;
    private int phoneTime;
    private int internet;
    private int sms;


    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
    public String getTariffName() {
        return tariffName;
    }

    public void setTariffName(String tariffName) {
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
                "id=" + id +
                ", tariffName='" + tariffName + '\'' +
                ", price=" + price +
                ", phoneTime=" + phoneTime +
                ", internet=" + internet +
                ", sms=" + sms +
                '}';
    }
}