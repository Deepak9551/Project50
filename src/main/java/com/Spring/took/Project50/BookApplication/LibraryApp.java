package com.Spring.took.Project50.BookApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LibraryApp {

    private static boolean flag = false;
    private static  Library library = new Library() ;
    public static void main(String[] args) {
        System.out.println("====================== Library App ======================");
        Scanner scanner = new Scanner(System.in);
    while(true){

        System.out.println("1 for Add Books");
        System.out.println("2 for Search Books by Title");
        System.out.println("3 for Search Books by Author");
        System.out.println("4 for Borrow Book");
        System.out.println("5 for Return Book");
        System.out.println("6 for Delete Book ");
        System.out.println("7 for Show All Books");
        System.out.println("8 for Show Borrowed Books");
        System.out.println("9 for Show Book by Title");
        System.out.println("10 for show user ");
        System.out.println("11 for Add User");
        System.out.println("12 Exit");
        int op = scanner.nextInt();
        scanner.nextLine();
        switch (op){
            case 1:
                Random random = new Random();

                String i = "DK" + random.nextInt(100, 999);
                System.out.println("Enter Title name");
                String title = scanner.nextLine();
                System.out.println("Enter Author Name");
                String author = scanner.nextLine();
                System.out.println("Enter Genre");
                String genre = scanner.nextLine();

                Book book = new Book(i,title,author,genre,false,null);
               library.addBooks(book);
               break;

            case 2 :
                System.out.println("Enter Title name");
                String searchtitle = scanner.nextLine();
                Book searchBookByTitlebook = library.searchBookByTitle(searchtitle);
                System.out.println(searchBookByTitlebook);
                break;

            case 3 :
                System.out.println("Enter Author Name");
          String searchAuthor =      scanner.nextLine();
                List<Book> books = library.searchBookByAuthor(searchAuthor);
                System.out.println(books);
                break;

            case 4 :
                System.out.println("Enter UserId");
                String userIdForBorrow = scanner.nextLine();

                System.out.println("Enter Book Id");
                String bookIdForBorrow = scanner.nextLine();


                library.borrowBooks(userIdForBorrow,bookIdForBorrow);
                break;

            case 5 :
                System.out.println("Enter Book Id");
                String bookIdforBorrow = scanner.nextLine();
                library.returnBook(bookIdforBorrow);
                break;

            case 6 :
                System.out.println("Enter Book Id");
                String bookIdforDelete = scanner.nextLine();
                library.deleteBook(bookIdforDelete);
                break;
            case 10 :
                System.out.println("Enter User name");
                String showusername = scanner.nextLine();
                library.showUser(showusername);
                break;
            case  8 :
                System.out.println("List Borrowed Books");
                library.showBorrowedBooks();
            case 7 :
                System.out.println("List of All Books");
                library.listAllBooks();
                break;
            case 9  :
                System.out.println("Enter Title name");
                String booktitle = scanner.nextLine();
                library.showBook(booktitle);
                break;


            case 11 :
                System.out.println("Enter User name");
                String username = scanner.nextLine();
                System.out.println("Enter Email");
                String email = scanner.nextLine();
                Random random1 = new Random();
                int id = random1.nextInt(100, 1000);

                String userId = "ID"+ id;
                User user = new User(userId,username,email,new ArrayList<>());
                library.addUser(user);

            case 12 :
                flag = false;
                break;
        }
    }

    }
}
