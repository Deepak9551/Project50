package com.Spring.took.Project50.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactManager {
    private List<Contact> contacts = new ArrayList<>();
    private HashMap<String , Contact> hashMap = new HashMap<>();
    private String phoneNoRegex = "0?[789]\\d{9}$";

    public ContactManager() {
        loadContact();
    }

    public void addContact(Contact contact){
        Pattern p =  Pattern.compile(phoneNoRegex);
        Matcher matcher = p.matcher(contact.getPhone_no());
        if (contact.getPhone_no().trim().isEmpty() || !matcher.matches()) {
            System.out.println("Invalid mobile Number");

        } else if (hashMap.containsKey(contact.getPhone_no())) {
            System.out.println("Duplicate Number Already Exist");
        } else {
            contacts.add(contact);
            hashMap.put(contact.getPhone_no(),contact);
            System.out.println("Mobile number Successfully added");
            System.out.println(contact);
        }
    }
    public Contact searchByNumber(String number){
if (hashMap.containsKey(number)){
    Contact contact = hashMap.get(number);
    System.out.println("Searcher number");
    System.out.println(contact);
    return contact;
}else {
    System.out.println("Contact not exist");
return null;
}

    }

    public void editContact(String name , String newName , String newPhoneNo){
        Contact contact = searchByName(name);
        if (contact != null) {
            hashMap.remove(contact.getPhone_no());
            contacts.remove(contact);
            contact.setName(newName);
            contact.setPhone_no(newPhoneNo);
            System.out.println("Update contact ");
            System.out.println(contact);
            hashMap.put(contact.getPhone_no(),contact);
            contacts.add(contact);
        }
        else {
            System.out.println("contact not found");
        }
    }
    public Contact searchByName(String name){

        return contacts.stream()
                .filter(contact -> contact.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);

    }
    public void deleteContact(String number){
        Contact contact = searchByNumber(number);
        if(contact!=null){
            contacts.remove(contact);
            hashMap.remove(contact.getPhone_no());
            System.out.println("Delete Phone no "+number);
        }
    }
    public void showAllContact(){
        System.out.println("showing all contact");
        contacts.forEach(System.out::println);
    }
public void storeContact(){

    try( FileOutputStream fileOutputStream = new FileOutputStream("contact.ser"); ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
       objectOutputStream.writeObject(contacts);
       objectOutputStream.flush();
    } catch (IOException e) {
        System.out.println("Error while Storing the Contact");
    }
}
public  void loadContact(){
    try(FileInputStream fileInputStream = new FileInputStream("contact.ser"); ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
   contacts = (List<Contact>) objectInputStream.readObject();
    } catch (ClassNotFoundException | IOException e) {
        System.out.println("Error while loading the Contact");
    }
}
}
