package com.Spring.took.Project50.InventoryManagement;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class ItemList {
    private static final long serialVersionUID = 2L;
    static List<Item> itemList = new ArrayList<>();
    final static String FILE_PATH = "item.ser";
    static File file = new File(FILE_PATH);

    public static void fillInventory() {
        Random random = new Random();
        try (BufferedReader bf = new BufferedReader(new FileReader("itemlist.txt"))) {

            String line = bf.readLine();
            while (line != null) {
                String i = "item" + random.nextInt(101, 999);
                String[] s = line.split(" ");
                Item item = new Item(i, s[0], s[1], s[2]);
                itemList.add(item);
                line = bf.readLine();
            }
            System.out.println(itemList);

        } catch (IOException e) {
            System.out.println("Error while Reading Inventory");
        }

    }

    public void saveInventory() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            objectOutputStream.writeObject(itemList);
            objectOutputStream.flush();
            System.out.println("Inventory SAVED !!");
        } catch (IOException e) {
            System.out.println("Error while saving the File : " + e.getMessage());
        }
    }

    public void loadDefaultData() {
        itemList.clear();
        itemList.add(new Item("item101", "Pen", "Stationery", "50"));
        itemList.add(new Item("item102", "Notebook", "Stationery", "100"));
        itemList.add(new Item("item103", "Mouse", "Electronics", "30"));
        saveInventory(); // 🧠 save default to file
    }

    public List<Item> getInventory() {
        if (file.exists()) {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
                itemList = (List<Item>) objectInputStream.readObject();
                System.out.println("Inventory Load From the File");

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("Error loading inventory, falling back to default.");
                loadDefaultData();
            }
        } else {
            System.out.println("No inventory file found. Creating default inventory.");
            loadDefaultData();
        }
        return itemList;
    }


//    public static void main(String[] args) throws IOException {
//        File file = new File("itemlist.txt");
//        file.createNewFile();
//        ItemList.fillInventory();
//
//        System.out.println("end");
//    }

    public void showInventory() {
        for (Item item : itemList) {
            System.out.println(
                    "🆔 " + item.getItem_id() +
                            " | 📦 Name: " + item.getItem_name() +
                            " | 📂 Category: " + item.getCategory() +
                            " | 🔢 Quantity: " + item.getQuantity());
        }
    }

    public void sortItem(String sortBy) {
        switch (sortBy.toLowerCase()) {
            case "name" -> Collections.sort(itemList, Comparator.comparing(Item::getItem_name));
            case "quantity" -> Collections.sort(itemList, Comparator.comparing(Item::getQuantity));
            case "category" -> Collections.sort(itemList, Comparator.comparing(Item::getCategory));
            default -> System.out.println("Invalid Sorting ");
        }
        System.out.println("Date sorted Successfully");
    }

    public void filterItem(String filter) {
        List<Item> collect = itemList.stream().filter(item -> item.getCategory().equalsIgnoreCase(filter)).toList();
        collect.stream().forEach(System.out::println);
    }


    public void updateQuantity(String itemId, String addedQuantity) {

        int addedqun = Integer.parseInt(addedQuantity);
        if(addedqun < 0 ){
            System.out.println("Invalid Input negative");
            return;
        }

        List<Item> collect = itemList.stream().filter(item -> item.getItem_id().equalsIgnoreCase(itemId)).toList();
        if (collect.isEmpty()) {
            System.out.println("❌ Item ID not found!");
            return;
        }
        Item item = collect.getFirst();
        item.setQuantity(addedQuantity);
        System.out.println("Update Quantity SuccessFully");
        System.out.println(item);
    }
    public void addQuantity(String itemId , String addedQuantity){

        List<Item> collect = itemList.stream().filter(item -> item.getItem_id().equalsIgnoreCase(itemId)).toList();
        if(collect.isEmpty()){
            System.out.println("❌ Item ID not found!");
            return;
        }
       Item item = collect.getFirst();
       int currentQuantity = Integer.parseInt(item.getQuantity());
        int added = Integer.parseInt(addedQuantity);
        int total = currentQuantity + added;

        item.setQuantity(Integer.toString(total));
        System.out.println("Update Added QUANTITY");
        System.out.println(item);
    }
    public Item searchItem(String itemId){

        List<Item> list = itemList.stream().filter(item -> item.getItem_id().equals(itemId)).toList();
       if (list != null) {

         return list.getFirst();
       }
        System.out.println("Item not found");
       return null;

    }
}