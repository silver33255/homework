package postgres;

import dao.CarDAOFactory;
import dao.DAOFactory;
import dao.InvoiceDAOFactory;

public class PostgresDAOFactory extends DAOFactory {
    public PostgresDAOFactory() {
        
    }

    @Override
    public CarDAOFactory reciveCarDAO() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public InvoiceDAOFactory reciveInvoiceDAO() {
        // TODO Auto-generated method stub
        return null;
    }
}
