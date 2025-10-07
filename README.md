# 🧭 Java Utils Project

A set of Java utilities to work with **directories**, **text files**, and **object serialization**, implemented with a simple **MVC pattern**.

---

## 📌 Exercises

1. **Exercise 1** – List contents of a directory alphabetically.  
2. **Exercise 2** – Recursively list a directory tree with type (D/F) and last modification date.  
3. **Exercise 3** – Save the directory tree to a `.txt` file.  
4. **Exercise 4** – Read any `.txt` file and display its content on the console.  
5. **Exercise 5** – Serialize a directory object to `.ser` and deserialize it back.

---

## 📂 Project Structure

src/
├─ main/
│ ├─ java/
│ │ ├─ model/
│ │ │ ├─ DirectoryManager.java
│ │ │ ├─ FileManager.java
│ │ │ └─ SerDesDirectory.java
│ │ ├─ view/
│ │ │ ├─ DirectoryView.java
│ │ │ └─ FileView.java
│ │ └─ level1/
│ │ ├─ Ex1.java
│ │ ├─ Ex2.java
│ │ ├─ Ex3.java
│ │ ├─ Ex4.java
│ │ └─ Ex5.java
└─ resources/
└─ config.properties


---

## ⚙️ Configuration (Exercise 3)

Optional: you can configure the directory and output file using `config.properties`:

properties:
directoryPath=newFolder
outputFile=directoryTree.txt
recursive=true

# File Explorer Exercises 🚀

This project contains exercises for working with directories and files in Java.

---

## How to Run

1. **Build the project with Maven:**

bash
mvn clean package

2. Navigate to compiled classes:
cd target/classes

3. Run any main class:
java level1.Ex1   # Exercise 1
java level1.Ex2   # Exercise 2
java level1.Ex3   # Exercise 3
java level1.Ex4   # Exercise 4
java level1.Ex5   # Exercise 5






