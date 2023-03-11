package com.java.study.task1.entity;

import java.util.ArrayList;
import java.util.List;

public class BunchConsumers {
    private int count;
    private List<Consumer> consumers;
    public BunchConsumers(){
        consumers = new ArrayList<>();
    }
    public void addConsumer(Consumer consumer){
        consumers.add(consumer);
        count++;
    }
    public List<Consumer> getConsumers(){
        return consumers;
    }
    public int sumOfConsumers(){
        return count;
    }

    @Override
    public String toString() {
        return "consumers= " + consumers;
    }
}
