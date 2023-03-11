package com.java.study.task1.entity;

import java.util.ArrayList;
import java.util.List;

public class BunchTariffs {
    private List<Tariff> tariffs;

    public BunchTariffs(){
        tariffs = new ArrayList<>();
    }
    public void addTariff(Tariff tariff){
        tariffs.add(tariff);
    }
    public List<Tariff> getTariffs(){
        return tariffs;
    }
    public List<Tariff> getTariffsByParameters(double priceFrom, double priceTo){
        List<Tariff> result = new ArrayList<>();
        for (Tariff tariff : tariffs) {
            if (tariff.getPrice() >= priceFrom && tariff.getPrice() <= priceTo){
                result.add(tariff);
            }
        }
        return result;
    }



    @Override
    public String toString() {
        return "BunchTariffs{" +
                "tariffs=" + tariffs +
                '}';

    }
}
