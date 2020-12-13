package resource;

public class Constants {
    
    public static final String SELECT_ALL_CARS = "SELECT * FROM car";
    public static final String SELECT_CARS_BY_MODEL = SELECT_ALL_CARS + " WHERE model = ?";
    public static final String SELECT_CARS_BY_CLASS = SELECT_ALL_CARS + " WHERE car_class = ?";

}
