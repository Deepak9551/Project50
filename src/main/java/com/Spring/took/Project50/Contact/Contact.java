package com.Spring.took.Project50.Contact;

import java.util.Objects;

public class Contact {
    private String contactId;
    private String name;
    private String phone_no;
    private String email;

    @Override
    public String toString() {
        return "Contact{" +
                "contactId='" + contactId + '\'' +
                ", name='" + name + '\'' +
                ", phone_no='" + phone_no + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Contact(String contactId, String name, String phone_no, String email) {
        this.contactId = contactId;
        this.name = name;
        this.phone_no = phone_no;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)  return true;
        if (o instanceof Contact){
            if(this.phone_no.equals(((Contact) o).phone_no)){
                return true;
            }else return false;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return phone_no.hashCode();
    }
}
