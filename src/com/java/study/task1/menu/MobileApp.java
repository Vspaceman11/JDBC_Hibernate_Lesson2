package com.java.study.task1.menu;

import com.java.study.task1.entity.BunchConsumers;
import com.java.study.task1.entity.BunchTariffs;
import com.java.study.task1.entity.Consumer;
import com.java.study.task1.entity.Tariff;

import java.util.*;

public class MobileApp {
    private Consumer consumer;
    private BunchTariffs bunchTariffs;
    private BunchConsumers bunchConsumers;
    public MobileApp() {
        consumer = new Consumer();
        bunchTariffs = new BunchTariffs();
        bunchConsumers = new BunchConsumers();
    }
    private void addTariff(Scanner sc){
        System.out.print("Name: ");
        String name = sc.next();
        System.out.print("Price: ");
        double price = sc.nextDouble();
        System.out.print("Phone Time in min.: ");
        int phoneTime = sc.nextInt();
        System.out.print("Internet in Mb/s: ");
        int internet = sc.nextInt();
        System.out.print("SMS: ");
        int sms = sc.nextInt();

        Tariff tariff = new Tariff();
        tariff.setName(name);
        tariff.setPrice(price);
        tariff.setPhoneTime(phoneTime);
        tariff.setInternet(internet);
        tariff.setSms(sms);

        bunchTariffs.addTariff(tariff);
    }
    private void addConsumer(Scanner sc){
        System.out.print("Name: ");
        String name = sc.next();
        System.out.print("Phone number: ");
        String phoneNumber = sc.next();

        Consumer consumer = new Consumer();
        consumer.setConsumerName(name);
        consumer.setPhoneNumber(phoneNumber);

        bunchConsumers.addConsumer(consumer);
    }

    private void findByPrice(Scanner sc){
        System.out.print("From: ");
        double from = sc.nextInt();
        System.out.print("To: ");
        double to = sc.nextInt();
        List<Tariff> tariffsByPrice = bunchTariffs.getTariffsByParameters(from, to);
        System.out.println(tariffsByPrice);
    }
    private void sort() {
        List<Tariff> tariffs = bunchTariffs.getTariffs();
        tariffs.sort(Comparator.comparing(Tariff::getPrice));
    }
    public static void main(String[] args) {
        System.out.println("Menu:" +
                "\nPress - 1 to add Tariff." +
                "\nPress - 2 to add Consumer." +
                "\nPress - 3 to check count of Consumers." +
                "\nPress - 4 to sort Tariff by price." +
                "\nPress - 5 to find Tariff by Price." +
                "\nPress - 6 to exit.");

        Scanner sc = new Scanner(System.in);
        MobileApp mobileApp = new MobileApp();
        boolean isMobileApp = true;
        while (isMobileApp){
            int res = sc.nextInt();
            switch (res){
                case 1 :
                    mobileApp.addTariff(sc);
                    System.out.println(mobileApp.bunchTariffs);
                    break;
                case 2 :
                    mobileApp.addConsumer(sc);
                    System.out.println(mobileApp.bunchConsumers);
                    break;
                case 3 :
                    System.out.println(mobileApp.bunchConsumers);
                    System.out.println("Count: " + mobileApp.bunchConsumers.sumOfConsumers());
                    break;
                case 4 :
                    mobileApp.sort();
                    System.out.println(mobileApp.bunchTariffs);
                    break;
                case 5 :
                    mobileApp.findByPrice(sc);
                    break;
                case 6 :
                    isMobileApp = false;
                    sc.close();

            }
        }
        System.out.println("Thanks for using :)");
    }
}
