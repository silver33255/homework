package entity;

public class AccountRole {
    private long id;
    private String roleName;
    
    private AccountRole() {   
    }
    
    public AccountRole(long id, String roleName) {
        super();
        this.id = id;
        this.roleName = roleName;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}