package com.Spring.took.Project50.StudentGrade;

import java.io.*;
import java.util.Scanner;

public class StudentGradeCalculation {
    public static void main(String[] args) {
        System.out.println("==============STUDENT REPORT CARD=============");
        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println("Enter Student Name :");
            String name = sc.nextLine();
            System.out.println("Enter Student Roll Number :");
            int rollNumber = sc.nextInt();
            System.out.println("Enter Physics Marks :");
            int physics =  sc.nextInt();
            System.out.println("Enter Chemistry Marks :");
            int chemistry =  sc.nextInt();
            System.out.println("Enter Maths Marks :");
            int maths =  sc.nextInt();
            System.out.println("Enter English Marks :");
            int english =  sc.nextInt();
            System.out.println("Enter Computer Science Marks :");
            int computer_science =  sc.nextInt();

            Subject subject = new Subject(physics,chemistry,maths,english,computer_science);
            Student student = new Student(name,rollNumber,subject) ;

            System.out.println("Do you want to save the report ( y / n )!!");
            String option = sc.next();
            if (option.equalsIgnoreCase("y")){
                Student.save_student_report(student);

            }
            System.out.println("Do you want to Enter Another Student  ( y / n )!! ");
            String next = sc.next();
            if (next.equalsIgnoreCase("n")){
                break;

            }
        }
        System.out.println("Do you want to see History report ( y / n )!!\"");
        String showHistory = sc.next();
        if (showHistory.equalsIgnoreCase("y")){
            Student.showHistory();

        }
    }
}
class Student{
    private String name;
    private int roll_number;
    private Subject subject;
    private int total_marks;
    private double percentage;
    private String grade;




    public Student(String name, int roll_number, Subject subject) {
        this.name = name;
        this.roll_number = roll_number;
        this.subject = subject;
        calculateTotalMarks(subject);
        percentage_calculate();
        assignGrade();
        printReportCard();

    }

    public void calculateTotalMarks(Subject subject){
        total_marks = subject.getComputer_science() + subject.getChemistry() +subject.getEnglish() + subject.getMaths() + subject.getPhysics();
        System.out.println("total marks of student = "+total_marks);
    }


    public void percentage_calculate(){
        percentage = (double) total_marks / 5 ;
    }

    public void assignGrade() {
        if (percentage >= 90) grade = "A+";
        else if (percentage >= 80) grade = "A";
        else if (percentage >= 70) grade = "B";
        else if (percentage >= 60) grade = "C";
        else grade = "F";
    }
    public void printReportCard(){

        System.out.println("================ REPORT ==============" );
        System.out.println("Name of Student :" + name);
        System.out.println("Roll Number of Student :"+ roll_number);
        System.out.println("Physics Marks = " + subject.getPhysics());
        System.out.println("Chemistry Marks = "+subject.getChemistry());
        System.out.println("Maths Marks = "+subject.getMaths());
        System.out.println("English Marks = "+subject.getEnglish());
        System.out.println("Computer Science Marks = "+subject.getComputer_science());
        System.out.println("Total Marks = "+total_marks);
        System.out.println("Percentage = "+percentage);
        System.out.println("Grade = "+grade);
        System.out.println("=====================================");

    }

    public static void save_student_report(Student s){
        try (  PrintWriter p = new PrintWriter(new FileWriter("student.txt",true))){
            String name =   s.getName();
            int rollNumber = s.getRoll_number();
            int totalMarks = s.getTotal_marks();
            double percentage = s.getPercentage();
            String grade = s.getGrade();

            p.println("student :"+name +" , "+"roll_number :"+rollNumber+" , "+"total_marks :"+totalMarks+" , "+"percentage :"+ percentage +" , "+"grade :"+grade);
            p.flush();

            System.out.println("=============DATA SAVED=============");
        } catch (IOException e) {
            System.out.println("Invalid data error "+e.getMessage());
        }


    }
    public static void showHistory(){
        System.out.println("================= REPORT HISTORY ==================");
        try(  BufferedReader bf = new BufferedReader(new FileReader("student.txt"))) {
            String line = bf.readLine();
            while (line !=null ){
                System.out.println(line);
                line = bf.readLine();
            }
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("================================================");
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoll_number() {
        return roll_number;
    }

    public void setRoll_number(int roll_number) {
        this.roll_number = roll_number;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getTotal_marks() {
        return total_marks;
    }

    public void setTotal_marks(int total_marks) {
        this.total_marks = total_marks;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }



}








class Subject{
    public Subject(int physics, int chemistry, int maths, int english, int computer_science) {
        this.physics = physics;
        this.chemistry = chemistry;
        this.maths = maths;
        this.english = english;
        this.computer_science = computer_science;
    }

    private int physics;
    private int chemistry;
    private int maths;
    private int english;
    private int computer_science;

    public int getPhysics() {
        return physics;
    }

    public void setPhysics(int physics) {
        this.physics = physics;
    }

    public int getChemistry() {
        return chemistry;
    }

    public void setChemistry(int chemistry) {
        this.chemistry = chemistry;
    }

    public int getMaths() {
        return maths;
    }

    public void setMaths(int maths) {
        this.maths = maths;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getComputer_science() {
        return computer_science;
    }

    public void setComputer_science(int computer_science) {
        this.computer_science = computer_science;
    }
}