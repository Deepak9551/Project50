package com.Spring.took.Project50.Todo_List;

import java.util.Scanner;

public class TodoApplication {
   private static TodoOperation todoOperation = new TodoOperation();

  static boolean flag = true;
    public static void main(String[] args) {
        System.out.println("===================== Welcome to Deepak Todo App =================");
        System.out.println();
        while (flag) {
            System.out.println("1 Add Task ");
            System.out.println("2 Show Tasks ");
            System.out.println("3 Marks a Task Done (input task number ) ");
            System.out.println("4 Delete a Task (input task number");
            System.out.println("5 To see Previous Saved Task ");
            System.out.println("6 Search Task By Title");
            System.out.println("7 Update Task By Title");
            System.out.println("8 Exit (date will be saved Automatically)");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            sc.nextLine();
            switch (option){
                case 1:
                    System.out.println("Enter Title ");
                    String title = sc.nextLine();
                    System.out.println("Enter Description ");
                    String description =  sc.nextLine();
                    String msg = todoOperation.addTask(title, description);
                    System.out.println(msg);
                    break;

                case 2:
                    todoOperation.showTask();
                    break;
                case 3:
                    System.out.println("Enter Task Number : ");
                    int i = Integer.parseInt(sc.next());

                    System.out.println( todoOperation.markTaskDone(i));

                    break;
                case 4:
                    System.out.println("Enter Task Number : ");
               int idx =     Integer.parseInt(sc.next());
                    System.out.println(todoOperation.deleteTask(idx));;
                    break;

                case 5:
                    todoOperation.showPreviousTask();
                    break;

                case 6 :
                    System.out.println("Search Title");
                 String searchTitle =   sc.nextLine();
                    System.out.println(todoOperation.search(searchTitle));
                    break;

                case 7 :
                    System.out.println("Update Description");
                    System.out.println("Enter Title ");
                    String titleforUpdate = sc.nextLine();
                    System.out.println("Enter Description ");
                    String descriptionforUpate =  sc.nextLine();
                    System.out.println(todoOperation.update(titleforUpdate,descriptionforUpate));;
               break;
                case 8:
                    todoOperation.exit();
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid INPUT !! ");
                    break;
            }


        }


    }
}
