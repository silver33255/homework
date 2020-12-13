package entity;

public class ClassCar {
    private long id;
    private String classAuto;
    
    public ClassCar(long id, String classAuto) {
        super();
        this.id = id;
        this.classAuto = classAuto;
    }
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getClassAuto() {
        return classAuto;
    }
    
    public void setClassAuto(String classAuto) {
        this.classAuto = classAuto;
    }
}