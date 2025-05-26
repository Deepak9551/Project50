# 📝 Java Console Todo App

A simple yet effective **Java Console-Based Todo List Application** that allows you to manage your daily tasks directly from the terminal. Built with core Java, file handling, and object-oriented principles.

---


## 🚀 Features

- ✅ Add new tasks with title and description
- 📋 View all current tasks
- ✏️ Update task description by title
- 🔍 Search tasks by title
- ☑️ Mark tasks as done
- ❌ Delete tasks
- 💾 Auto-save tasks on exit
- 📂 Show previously saved tasks (file-based persistence)

---

## 💡 Tech Stack

- **Java** (Core)
- File Handling for persistent storage
- Console-based UI

---
## 💻 Technologies Used

- Java (OOP & File I/O)
- Collections (ArrayList)
- `Scanner` for console input
- `LocalDateTime` for timestamps
- File-based storage using `.txt`

---
## 📁 Project Structure

com.Spring.took.Project50.Todo_List
│
├── TodoApplication.java # Main application file with menu
├── TodoOperation.java # Core logic for managing tasks
└── Task.java # Task entity (POJO)

---
## 📦 Installation

### 1. Clone the repository

```bash
git clone https://github.com/Deepak9551/todo-console-app.git
cd todo-console-app
```

### 2. Compile and Run the Project

```bash
javac -d bin src/com/Spring/took/Project50/Todo_List/*.java
java -cp bin com.Spring.took.Project50.Todo_List.TodoApplication
```

> Make sure Java is installed and added to PATH

---

## 🛠️ Usage

Upon running the app, you will see:

```
===================== Welcome to Deepak Todo App =================

1 Add Task
2 Show Tasks
3 Marks a Task Done
4 Delete a Task
5 To See Previous Saved Task
6 Search Task By Title
7 Update Task By Title
8 Exit (Data will be saved Automatically)
```

Follow the numbered instructions to perform operations.

---

## 🧑‍💻 Author

**Deepak Kumar**

- 🔗 [GitHub: @Deepak9551](https://github.com/Deepak9551)
- 💼 [LinkedIn: deepak-kumar-a09a63205](https://www.linkedin.com/in/deepak-kumar-a09a63205/)

---

## 📈 Future Enhancements

- Add priority levels to tasks (High, Medium, Low)
- Add due dates and reminders
- GUI version using Swing or JavaFX
- Export/Import JSON or CSV

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
