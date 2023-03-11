package com.java.study.task2.dao;

import com.java.study.task2.entity.Consumer;

import java.util.List;

public interface ConsumerDAO {
    void addConsumer(Consumer consumer);
    List<Consumer> getAllConsumers();
    long getSumOfConsumers();
}
