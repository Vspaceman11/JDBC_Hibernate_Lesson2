package com.java.study.task2.entity;

public class Consumer {
    private long id;
    private String consumerName;
    private String phoneNumber;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
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
                "id=" + id +
                ", consumerName='" + consumerName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
