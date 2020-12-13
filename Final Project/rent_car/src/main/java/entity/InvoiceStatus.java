package entity;

public class InvoiceStatus {
    private long id;
    private String statusName;
    
    public InvoiceStatus(long id, String statusName) {
        super();
        this.id = id;
        this.statusName = statusName;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}