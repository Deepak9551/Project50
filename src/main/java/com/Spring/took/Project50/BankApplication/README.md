
# 📚 Java Console Library Management System

A simple **Java Console-Based Library Management System** that allows users to manage books and users through a clean terminal interface. Developed using core Java principles like object-oriented programming and exception handling.

---

## 🚀 Features

- 📖 Add new books
- 👤 Register new users
- 🔍 Search books
- 📝 Issue books to users
- 📦 Return books
- ❌ Handle invalid input using custom exceptions
- 💾 Simple in-memory structure for books and users

---

## 💡 Tech Stack

- **Java (Core)**
- Object-Oriented Programming
- Exception Handling
- Console-based input/output

---

## 💻 Technologies Used

- Java
- Custom Exceptions
- `Scanner` for console input
- `ArrayList` and `HashMap` for managing data

---

## 📁 Project Structure

com.library.console
│
├── LibraryApp.java      # Entry point (Main class)
├── Library.java         # Core logic for managing library
├── Book.java            # Book entity
├── User.java            # User entity
└── InvalidInput.java    # Custom exception class

---

## 📦 Installation

### 1. Clone the repository

```bash
git clone https://github.com/Deepak9551/java-library-console-app.git
cd java-library-console-app
```

### 2. Compile and Run

```bash
javac -d bin src/com/library/console/*.java
java -cp bin com.library.console.LibraryApp
```

> Ensure Java is installed and properly set in PATH

---

## 🛠️ Usage

Run the application and interact with the console-based menu:

```
========= Welcome to Library Management System =========

1. Add Book
2. Register User
3. Issue Book
4. Return Book
5. Search Book
6. Exit
```

---

## 🧑‍💻 Author

**Deepak Kumar**

- 🔗 [GitHub: @Deepak9551](https://github.com/Deepak9551)
- 💼 [LinkedIn: deepak-kumar-a09a63205](https://www.linkedin.com/in/deepak-kumar-a09a63205/)

---

## 📈 Future Enhancements

- Save and load data from files
- Add fine calculation for overdue returns
- GUI version using JavaFX or Swing
- Book category and availability filters

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
