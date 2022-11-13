package Servlet;

import java.util.ArrayList;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="login")
@SessionScoped
public class LoginBean implements Serializable {
    private static final long serialVersionUID = -5433850275008415405L;
    
    private String email = "";
    private String password = "";

    private static Users users = new Users();

    public String getEmail() {
        System.out.println("getEmail : " + this.email);
        return this.email;
    }

    public void setEmail(String email){
        System.out.println("setEmail : " + email);
        System.out.println("this.email : " + this.email);
        this.email = email;
    }

    public String getPassword(){
        System.out.println("getPassword : " + this.password);
        return this.password;
    }

    public void setPassword(String password) {
        System.out.println("setPassword : " + password);
        System.out.println("this.password : " + this.password);
        this.password = password;
    }

    public String connect() {
        System.out.println("connect");
        System.out.println("this.email : " + this.email);
        System.out.println("this.password : " + this.password);
        if (this.users.contains(this.email, this.password)) {
            return "success";
        } else {
            return "failure";
        }
    }

    public String quit() {
        System.out.println("quitter");
        return "bye";
    }

    public String home() {
        System.out.println("home");
        return "index";
    }

    public String restart() {
        System.out.println("restart");
        this.email = "";
        this.password = "";
        return "login";
    }

}

class User {
    private String email;
    private String password;

    User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean equals(String email, String password) {
        // verif email is mail adress
        if (this.isMail(email)){
            return this.email.equals(email) && this.password.equals(password);
        } else {
            return false;
        }
    }

    public static boolean isMail(String email) {
        return email.matches("^[a-zA-Z0-9._-]+@[a-z0-9._-]{2,}\\.[a-z]{2,4}$");
    }
}

class Users {
    private static ArrayList<User> users = new ArrayList<User>();
    

    Users() {
        users.add(new User("ali.baba@mail.com", "baba"));
        users.add(new User("lanc.sagon@mail.com", "sagon"));
        users.add(new User("timo.bon@mail.com", "bon"));
    }

    public static void addUser(User u) {
        users.add(u);
    }

    public static void addUser(String email, String password) {
        if (!User.isMail(email)) {
        } else {
            users.add(new User(email, password));
        }
    }

    public static boolean contains(User u) {
        return users.contains(u);
    }

    public static boolean contains(String email, String password) {
        for (User u : users) {
            if (u.equals(email, password)) {
                return true;
            }
        }
        return false;
    }
}