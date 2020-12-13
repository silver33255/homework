import dao.DAOFactory;

public class Runner {

    public static void main(String[] args) {
        Connection con = DAOFactory.getInstance("Postgres").ge;

    }

}
