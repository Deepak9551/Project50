package com.Spring.took.Project50.InventoryManagement;

import java.util.Scanner;

public class InventoryApp {
  static   ItemList itemList = new ItemList();
static boolean flag = true;
    public static void main(String[] args) {
        System.out.println("====================Inventory App ===============");
        Scanner sc  = new Scanner(System.in);

        while (flag){
            System.out.println("1 for Display Inventory");
            System.out.println("2 for Sort Inventory");
            System.out.println("3 for Filter Inventory");
            System.out.println("4 for Update Inventory");
            System.out.println("5 for Update + Add Inventory");
            System.out.println("6 for Search Item by id");
            System.out.println("7 for exit");
         int option =    sc.nextInt();
         sc.nextLine();
            switch (option){
                case 1 -> System.out.println(itemList.getInventory());
                case 2 -> {
                    System.out.println("📦 Sorted by Name: name , quantity ,category");
                    System.out.println();
                    String sortby = sc.nextLine();
                    itemList.sortItem(sortby);
                    System.out.println("========= After Sorting =======");
                   itemList.showInventory();
                }
                case 3 -> {
                    System.out.println("📦 Filter by Category: Stationery ,Electronics");
                    String sortby = sc.nextLine();
                    itemList.filterItem(sortby);

                }
                case 4 ->{
                    System.out.println("Enter Update item Id");
                   String itemId = sc.nextLine();
                    System.out.println(" Enter Quantity for update");
                   String addedQuantity = sc.nextLine();
                   itemList.updateQuantity(itemId,addedQuantity);
                }
                case 5 -> {
                    System.out.println("Enter Update item Id");
                    String itemId = sc.nextLine();
                    System.out.println("Enter added Quantity");
                    String addedQuantity = sc.nextLine();
                    itemList.addQuantity(itemId,addedQuantity);

                }
                case 6 -> {
                    System.out.println("Enter  item Id");
                    String itemId = sc.nextLine();
                    Item item = itemList.searchItem(itemId);
                    System.out.println(item);
                }
                case 7->
                        {
                            itemList.saveInventory();
                            flag = false;
                        }
            }
        }
    }
}
