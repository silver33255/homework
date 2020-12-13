package entity;

import java.util.Date;

public class Invoice {
    private long id;
    private long clientId;
    private long CarId;
    private double TotalCost;
    private boolean driver;
    private int DaysRent;
    private Date createDate;
    private Date rentToDate;

    public Invoice(long id, long CarId) {
        super();
        this.id = id;
        this.CarId = CarId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getCarId() {
        return CarId;
    }

    public void setCarId(long CarId) {
        this.CarId = CarId;
    }

    public double getTotalCost() {
        return TotalCost;
    }

    public void setTotalCost(double TotalCost) {
        this.TotalCost = TotalCost;
    }

    public boolean isDriver() {
        return driver;
    }

    public void setDriver(boolean driver) {
        this.driver = driver;
    }

    public int getDaysRent() {
        return DaysRent;
    }

    public void setDaysRent(int DaysRent) {
        this.DaysRent = DaysRent;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getRentToDate() {
        return rentToDate;
    }

    public void setRentToDate(Date rentToDate) {
        this.rentToDate = rentToDate;
    }
}