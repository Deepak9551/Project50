package com.Spring.took.Project50.BankApplication;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AccountHolder implements Serializable {

    private String name;
    private String father_name;



    private String address;
    private String phone_no;
    private String email;
    private LocalDateTime dob;

    public AccountHolder(String name, String father_name, String address, String phone_no, String email, LocalDateTime dob) {
        this.name = name;
        this.father_name = father_name;
        this.address = address;
        this.phone_no = phone_no;
        this.email = email;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }
}
