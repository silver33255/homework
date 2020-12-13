package postgres;
import java.util.List;

import dao.CarDAOFactory;
import entity.Car;

public class PostgresCarDAO implements CarDAOFactory {

    public List<Car> selectAllCars() {
        return ;
    }

    public List<Car> selectCarsByModel() {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Car> selectCarsByClass(String model) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Car> selectCarsByModelAndClas(String carClass) {
        // TODO Auto-generated method stub
        return null;
    }

}
