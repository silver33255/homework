package com.epam.panaskin.runner;

import java.sql.SQLException;

public class Runner {    

    public static void main(String[] args) throws SQLException {
        DBManager dm = DBManager.getInstance();
        dm.getConnection();
        System.out.println(dm.selectCarsByModel("Chevrolet"));
    }

}
