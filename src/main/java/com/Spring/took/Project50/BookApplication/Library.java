package com.Spring.took.Project50.BookApplication;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<User> users =  new ArrayList<>();


    public void addBooks(Book book){
        try {
            if (book.getTitle() == null || book.getTitle().trim().isEmpty()){
                throw new InvalidInput("User name can not be Empty or null");
            }
            books.add(book);
            System.out.println(
                    "Book_Id :"
                            + book.getId() +  "  |  "+
                    "Book_name :"
                            + book.getTitle() +  "  |  "+
                            "Author :"
                            + book.getAuthor() +  "  |  "+
                            "Genre :"
                            +book.getGenre() +  "  |  "+

                            " is successfully added to our Library !! "
            );
        } catch (InvalidInput e) {
            System.out.println(e.getMessage());
        }



    }

    public void addUser(User user){

        try {
            if (user.getUsername()==null || user.getUsername().trim().isEmpty()){
                throw new InvalidInput("User name can not be Empty or null");
            }
            users.add(user);
            System.out.println(
                    "User_Id :"
                            +user.getUserId() +  "  |  "+
                    "User_name :"
                    +user.getUsername() +  "  |  "+
                     "Email :"
                    +user.getEmail()

            );
        } catch (InvalidInput e) {
            System.out.println(e.getMessage());
        }
    }

    public void borrowBooks(String userId , String bookId) {
        if (bookId == null || bookId.trim().isEmpty()) {
            System.out.println("Invalid Book ID");
            return;
        }
        if (userId == null || userId.trim().isEmpty()) {
            System.out.println("Invalid User ID");
            return;
        }
        Book book = searchBookById(bookId);
        User user = searchUser(userId);
        if (book != null && user != null) {
            if (book.isBorrowed()) {
                System.out.println("Book is already borrowed.");
                return;
            }
            book.setBorrowed(true);
            book.setBorrowedByUserId(userId);
            user.getBorrowedBookIds().add(bookId);
            System.out.println("Book '" + book.getTitle() + "' successfully borrowed by " + user.getUsername());
        } else {
            System.out.println("Book or User not Exist ");
        }
    }
    public Book searchBookById(String bookId){
//        Book foundBook = null ;
        for (Book book : books) {
            if (book.getId().equals(bookId)) {
//            foundBook = book ;
//            break;
                return book;
            }
        }
        return null;
    }
    public Book searchBookByTitle(String title){

        if(title ==null || title.trim().isEmpty()){
            System.out.println("Invalid Book Title.........");

            return null ;
        }
//        Book foundBook = null;
        for (Book book : books){
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
    public List<Book> searchBookByAuthor(String author){

        if(author==null || author.trim().isEmpty()){
            System.out.println("Invalid Book Author.........");

            return new ArrayList<>();
        }
        List<Book> foundBook = new ArrayList<>();
        for (Book book : books){
            if (book.getAuthor().equalsIgnoreCase(author)) {
                foundBook.add(book);

            }
        }
        return foundBook;
    }
    public void deleteBook(String bookId) {
        if (bookId == null || bookId.trim().isEmpty()) {
            System.out.println("Invalid Book ID");
            return;
        }
        Book book = searchBookById(bookId);
        if (book != null) {
            books.remove(book);
            System.out.println("Book '" + book.getTitle() + "' deleted successfully.");
        } else {
            System.out.println("Book Does Not Exist");
        }
    }
    public void listAllBooks(){
        for (Book book : books){
            System.out.println(
                    "Book_name :"
                            + book.getTitle() +  "  |  "+
                            "Author :"
                            + book.getAuthor() +  "  |  "+
                            "Genre :"
                            +book.getGenre() +  "  |  "+

                            " is successfully added to our Library !! "
            );
        }
    }


    public User searchUser(String userId){

        for (User user : users){
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    public void returnBook(String bookId) {
        if (bookId == null || bookId.trim().isEmpty()) {
            System.out.println("Invalid Book ID");
            return;
        }

        Book book = searchBookById(bookId);

        if (book != null && book.isBorrowed()) {

            book.setBorrowed(false);

            String userId = book.getBorrowedByUserId();
            book.setBorrowedByUserId(null);

            User user = searchUser(userId);

            if (user != null) {
                List<String> bookIds = user.getBorrowedBookIds();
                bookIds.remove(bookId);
                System.out.println("Book Returned Successfully");
            }
            else {
                System.out.println("User not found while returning book.");
            }
        }else {
            System.out.println("Book not found or already returned ");
        }
    }
public void showBorrowedBooks(){
        for (Book book : books){
            if (book.isBorrowed()){
                System.out.println(
                        "Book_name :"
                                + book.getTitle() +  "  |  "+
                                "Author :"
                                + book.getAuthor() +  "  |  "+
                                "Genre :"
                                +book.getGenre() +  "  |  "+

                                " is successfully added to our Library !! "
                );
            }
        }
}
public void showUser(String name){
        for(User user : users){
            if(user.getUsername().equals(name)){
                System.out.println(user);
                return;
            }
        }

}
    public void showBook(String title){
        for(Book book : books){
            if(book.getTitle().equals(title)){
                System.out.println(book);
                return;
            }
        }

    }


}
