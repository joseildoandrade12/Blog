package domain;


import java.sql.Date;

public class User {
    private final String id;
    private String email;
    private String password;
    private String userName;
    private final Date date;

    public User(String id, String email, String password, String userName, Date date) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", date=" + date +
                '}';
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getpassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public Date getDate() {
        return date;
    }
}
