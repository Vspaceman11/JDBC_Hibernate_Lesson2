package com.java.study.task2.dao;

public interface IDAOFactory {
    TariffDAO getTariffDAO();
    ConsumerDAO getConsumerDAO();
}
