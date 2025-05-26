# 📚 Java Console Projects (Library & Bank)

This repository includes two Java-based console applications:
- 📖 **Library Management System**: Manage books and users.
- 🏦 **Bank Management System**: Perform banking operations like account creation, deposit, withdrawal, etc.

---

## 🚀 Features

### 📖 Library App
- Add books and users
- Borrow and return books
- View available and borrowed books
- Handle invalid inputs with custom exceptions

### 🏦 Bank App
- Create new bank accounts
- Deposit and withdraw money
- Check account balance
- Handle invalid amount and account number with custom exceptions

---

## 💻 Technologies Used

- **Java** (OOP principles)
- **Exception Handling** (Custom Exceptions)
- Console Input with `Scanner`
- Collections like `ArrayList` and `HashMap`
- Simple class-based structure (POJOs & Operations)

---

## 📁 Project Structure

### 📖 Library App

LibraryApp.java // Main runner class with menu
Library.java // Manages book/user operations
Book.java // POJO for Book
User.java // POJO for User
InvalidInput.java // Custom Exception

shell
Copy
Edit

### 🏦 Bank App

BankOperation.java // Core logic for banking
Account.java // POJO for account info
InvalidAmountException.java // Custom Exception
InvalidAccountNumber.java // Custom Exception

yaml
Copy
Edit

---

## 📦 How to Run

### 1. Clone the Repository

```bash
git clone https://github.com/Deepak9551/java-console-projects.git
cd java-console-projects
2. Compile and Run (for Library)
bash
Copy
Edit
javac -d bin src/Library/*.java
java -cp bin LibraryApp
3. Compile and Run (for Bank)
bash
Copy
Edit
javac -d bin src/Bank/*.java
java -cp bin BankOperation
Make sure Java is installed and configured in your system

🧑‍💻 Author
Deepak Kumar

🔗 GitHub: @Deepak9551

💼 LinkedIn: deepak-kumar-a09a63205

🌱 Future Enhancements
📊 GUI version using Swing or JavaFX

📁 Save and load data from files or database

🛡️ User authentication and roles (admin/user)

📈 More reporting and analytics

