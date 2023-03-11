package com.java.study.task2.dao;

import com.java.study.task2.entity.Tariff;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TariffJDBCDao implements TariffDAO {

    @Override
    public void addTariff(Tariff tariff){
        Connection connection = null;
        connection = getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("INSERT INTO tariff(tariffName, price, phoneTime, internet, sms)" +
                    "VALUES (?,?,?,?,?)");
            statement.setString(1, tariff.getTariffName());
            statement.setDouble(2, tariff.getPrice());
            statement.setInt(3, tariff.getPhoneTime());
            statement.setInt(4, tariff.getInternet());
            statement.setInt(5, tariff.getSms());

            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null && statement != null){
                try{
                    connection.close();
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public List<Tariff> getAllTariffs() {
        List<Tariff> allTariffs = new ArrayList<>();
        Connection connection = null;
        connection = getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM tariff");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
            long id = resultSet.getLong("id");
            String name = resultSet.getString("tariffName");
            double price = resultSet.getDouble("price");
            int phoneTime = resultSet.getInt("phoneTime");
            int internet = resultSet.getInt("internet");
            int sms = resultSet.getInt("sms");

            Tariff tariff = new Tariff();
            tariff.setId(id);
            tariff.setTariffName(name);
            tariff.setPrice(price);
            tariff.setPhoneTime(phoneTime);
            tariff.setInternet(internet);
            tariff.setSms(sms);

            allTariffs.add(tariff);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null && statement != null){
                try{
                    connection.close();
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return allTariffs;
    }

    @Override
    public void getByParameters(double priceFrom, double priceTo) {
        Connection connection = null;
        PreparedStatement statement = null;
        connection = getConnection();
        try {
            statement = connection.prepareStatement("SELECT * FROM tariff WHERE price >= ? and price <= ?");
            statement.setDouble(1,priceFrom);
            statement.setDouble(2,priceTo);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                long id = resultSet.getInt("id");
                String name = resultSet.getString("tariffName");
                double price = resultSet.getDouble("price");
                int phoneTime = resultSet.getInt("phoneTime");
                int internet = resultSet.getInt("internet");
                int sms = resultSet.getInt("sms");

                System.out.println("Id: " + id + " Name: " + name + " Price: " + price
                        + " Phone time:" + phoneTime + " Internet: " + internet + " SMS: " + sms);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null && statement != null){
                try{
                    connection.close();
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private int getTariffId(String name, Connection connection){
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT id FROM tariff where name = ?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }
    private Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tariffs", "root", "admin");
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
