# 🧾 Inventory Management System (Java + File Serialization)

This is a simple inventory management system built using Java. It reads item data from a text file, allows updates to inventory, sorts, filters, saves to a file (`item.ser`) using serialization, and loads data on next launch.

## 📁 Features

- Load inventory from `itemlist.txt` or default values.
- Save inventory to file (`item.ser`).
- Load inventory from saved file.
- Update item quantity.
- Add quantity to existing items.
- Filter items by category.
- Sort items by name, quantity, or category.
- Search items by item ID.

## 🚀 How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/Deepak9551/inventory-management.git
   cd inventory-management
Add a file named itemlist.txt in the root directory (same location as item.ser).

Add sample data to itemlist.txt:

arduino
Copy
Edit
Pen Stationery 50
Notebook Stationery 100
Mouse Electronics 30
Compile and run the program:

bash
Copy
Edit
javac -d . ItemList.java Item.java
java com.Spring.took.Project50.InventoryManagement.ItemList
##  📦 Classes
# Item.java
Represents an inventory item with fields:
inventory-management/
- ├── src/
- ├── README.md
- ├── itemlist.txt
- ├── item.ser
---
- item_id

- item_name

- category

- quantity

- Implements Serializable.
----
## ItemList.java
Manages:

- Reading from file

- Saving to file

- Sorting, filtering, updating

- Searching items
---
⚠️ Notes
If item.ser is missing or corrupted, default items will be loaded.

Make sure itemlist.txt exists before calling fillInventory().
---
## 🛠️ Tech Used
# Java

- Serialization (ObjectOutputStream/ObjectInputStream)

- Collections & Streams API

# 👨‍💻 Author
- Deepak Kumar
- 📎 LinkedIn Profile
- 📁 GitHub Profile

---Aspiring Java Developer | Focused on Spring, Hibernate, and Backend Systems.
