package model;

import java.sql.Timestamp;

public class User {
    private int idUser;
    private String phoneNumber;
    private String password;
    private String salt;
    private String name;
    private Timestamp registTime;
    private Timestamp lastLoginTime;

    public User(
            int idUser,
            String phoneNumber,
            String password,
            String salt,
            String name,
            Timestamp registTime,
            Timestamp lastLoginTime){
        this.idUser = idUser;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.salt = salt;
        this.name = name;
        this.registTime = registTime;
        this.lastLoginTime = lastLoginTime;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRegistTime(Timestamp registTime) {
        this.registTime = registTime;
    }
}
