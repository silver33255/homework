package entity;

public class Car {
    private long id;
    private String model;
    private long carClass;
    private double rentPrice;
    private boolean avable;

    private Car() {
    }

    public Car(long id, String model) {
        this.id = id;
        this.model = model;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getCarClass() {
        return carClass;
    }

    public void setCarClass(long carClass) {
        this.carClass = carClass;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public boolean isAvable() {
        return avable;
    }

    public void setAvable(boolean avable) {
        this.avable = avable;
    }
}