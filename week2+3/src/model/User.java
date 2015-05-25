package model;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

    private String userName,email,password,realName,address,country;
    private ArrayList<BlogPost> blogPosts;

    public User(String userName, String email, String password, String realName, String address, String country) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.realName = realName;
        this.address = address;
        this.country = country;
        this.blogPosts = new ArrayList<>();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ArrayList<BlogPost> getBlogPosts() {
        return blogPosts;
    }

    public void setBlogPosts(ArrayList<BlogPost> blogPosts) {
        this.blogPosts = blogPosts;
    }

    @Override
    public String toString() {
        return userName;
    }
}
