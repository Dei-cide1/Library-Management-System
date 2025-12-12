package Main;

import java.io.*;

public class User extends Account{
    private int ID;
    private String fullname;
    private String phonenumber;

    public User(String username, String password, String fullname, String phonenumber ) throws IOException {
        super(username,password);
        this.fullname = fullname;
        this.phonenumber = phonenumber;
        setRole(Role.USER);
    }

    public User(int ID, String username, String password, String fullname, String phonenumber ) throws IOException {
        super(username,password);
        this.ID = ID;
        this.fullname = fullname;
        this.phonenumber = phonenumber;
        setRole(Role.USER);
    }

    public void setFullname(String fullname){
        this.fullname = fullname;
    }
    public void setPhonenumber(String phonenumber){
        this.phonenumber = phonenumber;
    }
    public void setID(int ID){
        this.ID = ID;
    }

    public String getFullname(){
        return fullname;
    }
    public String getPhonenumber(){
        return phonenumber;
    }
    public int getID(){
        return ID;
    }
}
