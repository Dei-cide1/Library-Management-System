package Main;

public class Admin extends Account{
    private String fullname;
    private String phonenumber;

    public Admin(){
        super("Admin","Admin");
        this.fullname = "Juan De Luna";
        this.phonenumber = "01234567891";
        setRole(Role.ADMIN);
    }

    public void setFullname(String fullname){
        this.fullname = fullname;
    }
    public void setPhonenumber(String phonenumber){
        this.phonenumber = phonenumber;
    }

    public String getFullname(){
        return fullname;
    }
    public String getPhonenumber(){
        return phonenumber;
    }
}
