package com.Spring.took.Project50.Todo_List;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TodoOperation {
    ArrayList<Task> taskList = new ArrayList<>(25);


    public String addTask(String title, String description) {
        if (title == null || title.trim().isEmpty()) {
            return "Task Cannot Be Added ";
        }
        for (Task task : taskList) {
            if (task.getTitle().equalsIgnoreCase(title)) {
                return "Task Already Exist !!";
            }
        }
        LocalDateTime dateTime = LocalDateTime.now();
        Task task = new Task(title.trim(), description, false, dateTime);
        taskList.add(task);
        return "Task Add Successfully";
    }

    public void showTask() {
        if (taskList.isEmpty()) {
            System.out.println("Task is Not Available");
            return;
        }
        Iterator<Task> iterator = taskList.iterator();
        System.out.println("============Your Tasks============");
        while (iterator.hasNext()) {
            Task task = iterator.next();
            String title = task.getTitle();
            String description = task.getDescription();
//           boolean done = task.isDone();
//           String state = "Pending";
//           if(done){
//               state = "Done";
//           }
            String status = task.isDone() ? " Done " : " Pending ";
            System.out.println("Title : " + title + " | " + " description : " + description + " | " + "state " + status);
        }
    }

    public String markTaskDone(int id) {
        if (id <= 0 || id > taskList.size()) return "Invalid Task Number";
        int taskNUmber = id - 1;
        Task task = taskList.get(taskNUmber);
        if (task.isDone()) {
            return "Task Already Marked Done";
        }
        task.setDone(true);
        return "Task Number " + id + "Marked Done !!";
    }

    public String deleteTask(int id) {
        if (id <= 0 || id > taskList.size()) return "Invalid Task Number";
        int taskNUmber = id - 1;
        Task task = taskList.remove(taskNUmber);
        return "Task : " + task.getTitle() + " Deleted Successfully";
    }

    public void exit() {


        try (PrintWriter printWriter = new PrintWriter(new FileWriter("todo", true))) {
            for (Task task : taskList) {
                String title = task.getTitle();
                String description = task.getDescription();
                String status = task.isDone() ? "Done" : "Pending";

                String createdAt = task.getCreatedAt().format(DateTimeFormatter.ofPattern("E, MMM dd yyyy"));
                String msg = "Task : " + title + " | description : " + description + " | status : " + status + " | created-At :" + createdAt;
                printWriter.println(msg);
                printWriter.flush();

            }
        } catch (IOException e) {
            System.out.println("Error : Data Not Saved :" + e.getMessage());
        }

    }

    public void showPreviousTask() {
        try (BufferedReader bf = new BufferedReader(new FileReader("todo"))) {
            String line = bf.readLine();
            while (line != null) {
                System.out.println(line);
                line = bf.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error : Data Not See :" + e.getMessage());
        }

    }

    public String search(String search_title) {
        for (Task task : taskList) {
            if (task.getTitle().equalsIgnoreCase(search_title)) {
                String status = task.isDone() ? "Done" : "Pending";
                String createdAt = task.getCreatedAt().format(DateTimeFormatter.ofPattern("E, MMM dd yyyy"));
                return "Task: " + task.getTitle()
                        + " | Description: " + task.getDescription()
                        + " | Status: " + status
                        + " | Created At: " + createdAt;
            }
        }
        return " Task not found!";
    }

    public String update(String title, String description) {
        for (Task task : taskList) {
            if (task.getTitle().equalsIgnoreCase(title)) {
                String status = task.isDone() ? "Done" : "Pending";
                String createdAt = task.getCreatedAt().format(DateTimeFormatter.ofPattern("E, MMM dd yyyy"));
                task.setDescription(description);
                System.out.println("Update Successfully");
                return "Task: " + task.getTitle()
                        + " | Description: " + task.getDescription()
                        + " | Status: " + status
                        + " | Created At: " + createdAt;

            }
        }

return "Invalid Title";
    }

}
