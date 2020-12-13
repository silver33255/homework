package dao;
import java.util.List;

import entity.Car;

public interface CarDAOFactory {
    
    public List<Car> selectAllCars();
    public List<Car> selectCarsByModel();
    public List<Car> selectCarsByClass(String model);
    public List<Car> selectCarsByModelAndClas(String carClass);
}
