package com.java.study.task2.dao;

import com.java.study.task2.entity.Tariff;

import java.util.List;

public interface TariffDAO {
    void addTariff(Tariff tariff);
    List<Tariff> getAllTariffs();
    void getByParameters(double priceFrom, double priceTo);

}
