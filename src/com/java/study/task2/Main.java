package com.java.study.task2;


import com.java.study.task2.dao.*;
import com.java.study.task2.entity.Consumer;
import com.java.study.task2.entity.Tariff;

public class Main {
    public static void main(String[] args) {
        IDAOFactory factory = DAOFactory.getInstance();
        TariffDAO tariffDAO = factory.getTariffDAO();
        ConsumerDAO consumerDAO = factory.getConsumerDAO();

        Tariff tariff1 = new Tariff();
        tariff1.setTariffName("Joice");
        tariff1.setPrice(99.9);
        tariff1.setPhoneTime(100);
        tariff1.setInternet(5000);
        tariff1.setSms(100);
        tariffDAO.addTariff(tariff1);

        Tariff tariff2 = new Tariff();
        tariff2.setTariffName("Super");
        tariff2.setPrice(120.0);
        tariff2.setPhoneTime(150);
        tariff2.setInternet(7000);
        tariff2.setSms(120);
        tariffDAO.addTariff(tariff2);

        String allTariffs = tariffDAO.getAllTariffs().toString();
        System.out.println("All tariffs:");
        System.out.println(allTariffs);
        System.out.println("Searching by parameters from - to:");
        tariffDAO.getByParameters(100, 120);

        Consumer consumer1 = new Consumer();
        consumer1.setConsumerName("Alex");
        consumer1.setPhoneNumber("(090)2677182");
        consumerDAO.addConsumer(consumer1);

        Consumer consumer2 = new Consumer();
        consumer2.setConsumerName("Dave");
        consumer2.setPhoneNumber("(090)2163426");
        consumerDAO.addConsumer(consumer2);

        String allConsumers = consumerDAO.getAllConsumers().toString();
        System.out.println("All Consumers: ");
        System.out.println(allConsumers);

        long sumOfConsumers = consumerDAO.getSumOfConsumers();
        System.out.println("Number of consumers: " + sumOfConsumers);
    }
}
