package entity;

public class Car {
    private long id;
    private String model;
    
    public Car(long id, String model) {
        this.id = id;
        this.model = model;
    }
    
    @Override
    public String toString() {
        return model;
    }
}
