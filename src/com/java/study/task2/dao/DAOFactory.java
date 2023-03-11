package com.java.study.task2.dao;

public class DAOFactory implements IDAOFactory{
    private static IDAOFactory factory;
    private DAOFactory(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loading success!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized IDAOFactory getInstance() {
        if (factory == null){
            factory = new DAOFactory();
        }
        return factory;
    }
    @Override
    public TariffDAO getTariffDAO() {
        return new TariffJDBCDao();
    }

    @Override
    public ConsumerDAO getConsumerDAO() {
        return new ConsumerJDBCDao();
    }
}
