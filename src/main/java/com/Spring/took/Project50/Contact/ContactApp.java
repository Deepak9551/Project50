package com.Spring.took.Project50.Contact;

import java.util.Random;
import java.util.Scanner;
import java.util.random.RandomGenerator;

import java.util.Scanner;
import java.util.UUID;

public class ContactApp {

    private static boolean flag = true;

    public static void main(String[] args) {

        ContactManager contactManager = new ContactManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("================= Contact Manager App =================");

        while (flag) {
            System.out.println("\nChoose an option:");
            System.out.println("1 → Add Contact");
            System.out.println("2 → Search By Number");
            System.out.println("3 → Edit Contact");
            System.out.println("4 → Delete Contact");
            System.out.println("5 → Show All Contacts");
            System.out.println("6 → Exit");
            System.out.print("Enter your choice: ");

            String option = scanner.nextLine().trim();

            switch (option) {
                case "1" -> {
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String phoneNo = scanner.nextLine();

                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();

                    String contactId = "ID" + UUID.randomUUID().toString().substring(0, 8);
                    Contact contact = new Contact(contactId, name, phoneNo, email);
                    contactManager.addContact(contact);
                }

                case "2" -> {
                    System.out.print("Enter Phone Number to Search: ");
                    String number = scanner.nextLine();
                    contactManager.searchByNumber(number);
                }

                case "3" -> {
                    System.out.print("Enter Name of Contact to Edit: ");
                    String oldName = scanner.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter New Phone Number: ");
                    String newPhone = scanner.nextLine();

                    contactManager.editContact(oldName, newName, newPhone);
                }

                case "4" -> {
                    System.out.print("Enter Phone Number to Delete: ");
                    String number = scanner.nextLine();
                    contactManager.deleteContact(number);
                }

                case "5" -> {
                    contactManager.showAllContact();
                }

                case "6" -> {
                    System.out.println("Exiting Contact Manager. Goodbye!");
                    contactManager.storeContact();
                    flag = false;
                }

                default -> System.out.println("Invalid option. Please choose from 1 to 6.");
            }
        }

        scanner.close();
    }
}
