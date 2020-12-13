package com.epam.rd.java.basic.practice8;

import com.epam.rd.java.basic.practice8.db.DBManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class BasicTest {
    protected static final DBManager DB_MANAGER = DBManager.getInstance();
    private static final Logger LOGGER = Logger.getGlobal();

    protected void executeSql(String sql) {
        try (Connection connection = DB_MANAGER.getConnection("");
             Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "", e);
        }
    }

    protected boolean executeSqlQuery(String sql) {
        try (Connection connection = DB_MANAGER.getConnection("");
             Statement statement = connection.createStatement()) {
            return statement.executeQuery(sql).next();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "", e);
            return false;
        }
    }
}
