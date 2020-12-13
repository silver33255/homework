package dao;

import mysql.MySqlDAOFactory;
import postgres.PostgresDAOFactory;

public abstract class DAOFactory {
    
    public static final String MY_SQL = "MySQLqwe";
    public static final String POSTGRES = "Postgres";
    
    public static DAOFactory getInstance() {
        return MySqlDAOFactory.getInstance();
    }
    
    public static DAOFactory getInstance(String nameDB)  {
        if (MY_SQL.equalsIgnoreCase(nameDB)) {
            return new MySqlDAOFactory();
        } else if (POSTGRES.equalsIgnoreCase(nameDB)) {
            return new PostgresDAOFactory();
        }
        throw new IllegalArgumentException("Unsupported base"); 
    }
    
    public abstract CarDAOFactory reciveCarDAO();
    public abstract InvoiceDAOFactory reciveInvoiceDAO();
}
