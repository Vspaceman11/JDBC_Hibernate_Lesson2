package com.java.study.task1.entity;

public class Consumer {
    private String consumerName;
    private String phoneNumber;

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "consumerName='" + consumerName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
