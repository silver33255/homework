package com.epam.panaskin.runner;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Car;
import resource.Constants;

import java.sql.Connection;

public class DBManager {
    private static String URL = "jdbc:postgresql://localhost/car_rent" 
            + "?user=postgres&password=admin";
    
    private static DBManager instance;

    private DBManager() {
        super();
    }

    public static synchronized DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }
    
    Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
    
    public List<Car>selectAllCars() throws SQLException{
        List<Car> allCars = new ArrayList<>();
        Statement stmp = getConnection().createStatement();
        stmp.execute(Constants.SELECT_ALL_CARS);
        ResultSet rs = stmp.getResultSet();
        while (rs.next()) {
            allCars.add(new Car(rs.getLong(1), rs.getString(2)));
        }
        return allCars;
    }
    
    public List<Car>selectCarsByModel(String model) throws SQLException{
        List<Car> allCars = new ArrayList<>();
        Connection con = getConnection();
        PreparedStatement stmp = null;
        ResultSet rs = null;
        try {
            stmp = con.prepareStatement(Constants.SELECT_CARS_BY_MODEL);
            stmp.setString(1, model);
            rs = stmp.executeQuery();
            while (rs.next()) {
                allCars.add(new Car(rs.getLong(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        } finally {
            rs.close();
            stmp.close();
            con.close();
        }
        return allCars;
    }
    
    public List<Car>selectCarsByClass(String carClass) throws SQLException{
        List<Car> allCars = new ArrayList<>();
        Connection con = getConnection();
        PreparedStatement stmp = null;
        ResultSet rs = null;
        try {
            stmp = con.prepareStatement(Constants.SELECT_CARS_BY_CLASS);
            stmp.setString(1, carClass);
            rs = stmp.executeQuery();
            while (rs.next()) {
                allCars.add(new Car(rs.getLong(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        } finally {
            rs.close();
            stmp.close();
            con.close();
        }
        return allCars;
    }
}
