package com.java.study.task2.dao;

import com.java.study.task2.entity.Consumer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsumerJDBCDao implements ConsumerDAO{
    @Override
    public void addConsumer(Consumer consumer) {
        Connection connection = null;
        connection = getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("INSERT INTO consumer(consumerName, phoneNumber) VALUES (?,?)");
            statement.setString(1, consumer.getConsumerName());
            statement.setString(2, consumer.getPhoneNumber());

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
    public List<Consumer> getAllConsumers() {
        List<Consumer> consumers = new ArrayList<>();
        Connection connection = null;
        connection = getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM consumer");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                long id = resultSet.getLong("id");
                String name = resultSet.getString("consumerName");
                String phone = resultSet.getString("phoneNumber");

                Consumer consumer = new Consumer();
                consumer.setId(id);
                consumer.setConsumerName(name);
                consumer.setPhoneNumber(phone);
                consumers.add(consumer);
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
        return consumers;
    }

    @Override
    public long getSumOfConsumers() {
        Connection connection = null;
        connection = getConnection();
        PreparedStatement statement = null;
        long id = 0;
        try {
            statement = connection.prepareStatement("SELECT max(id) from consumer");
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            id = resultSet.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null && statement != null) {
                try {
                    connection.close();
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return id;
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
