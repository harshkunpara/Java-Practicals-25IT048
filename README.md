<div align="center">

# Java Practicals — Object-Oriented Programming

**CEUE203 · Semester 3 · Academic Year 2026–27**

A collection of Java practice programs and practical implementations covering core and advanced Object-Oriented Programming concepts.

![Java](https://img.shields.io/badge/Language-Java-orange?logo=openjdk&logoColor=white)
![JDK](https://img.shields.io/badge/JDK-17%2B-blue?logo=openjdk&logoColor=white)
![Course](https://img.shields.io/badge/Course-CEUE203-informational)
![Practicals](https://img.shields.io/badge/Practicals-01--14-success)

</div>

---

##  About

This repository contains the source code for the **Object-Oriented Programming (CEUE203)** practical course. It is organized practical-wise so that each lab's programs can be explored and executed independently.

The repository includes practice programs from Practical 1–13 and the Practical 14 layered application/testing work, as present in the project folders. The official practical-list PDF is also included for reference.

## Practical Index

| Practical | Main topics / programs | Folder |
|---|---|---|
| 01 | Vending Machine, Toll Booth, Rock-Paper-Scissors-Lizard-Spock | [`Practical 1/`](Practical%201/) |
| 02 | Smart Thermostat, Cinema Show, Parking Lot | [`Practical 2/`](Practical%202/) |
| 03 | Points, Cards and object-oriented class exercises | [`Practical 3/`](Practical%203/) |
| 04 | Password Strength Checker, Chat Filter | [`Practical 4/`](Practical%204/) |
| 05 | Shape hierarchy and Employee types | [`Practical 5/`](Practical%205/) |
| 06 | Interfaces, Remote Control and Notification Senders | [`Practical 6/`](Practical%206/) |
| 07 | Custom annotations, Reflection and Form Validation | [`Practical 7/`](Practical%207/) |
| 08 | Exception Handling, Guarded Calculator and Try-with-Resources | [`Practical 8/`](Practical%208/) |
| 09 | Multithreading, Shared Counters and Race Conditions | [`Practical 9/`](Practical%209/) |
| 10 | Thread Pools, Producer–Consumer and Deadlock | [`Practical 10/`](Practical%2010/) |
| 11 | File Handling, Serialization, Log Analysis and Folder Reports | [`Practical 11/`](Practical%2011/) |
| 12 | Collections: HashMap, Sets and Sorting | [`Practical 12/`](Practical%2012/) |
| 13 | Generics, Generic Containers and Generic Stack | [`Practical 13/`](Practical%2013/) |
| 14 | Layered Application, ArrayList and JUnit Testing | [`Practical 14/`](Practical%2014/) |

> Refer to [`OOP_CEUE203_Practical_List (1).pdf`](OOP_CEUE203_Practical_List%20(1).pdf) for the official problem statements, expected work and evaluation details.

## Repository Structure

```text
Java Practical/
├── Practical 1/
├── Practical 2/
├── Practical 3/
├── Practical 4/
├── Practical 5/
├── Practical 6/
├── Practical 7/
├── Practical 8/
├── Practical 9/
├── Practical 10/
├── Practical 11/
├── Practical 12/
├── Practical 13/
├── Practical 14/
└── OOP_CEUE203_Practical_List (1).pdf
```

Some practicals contain multiple exercises or subfolders. Open the relevant practical directory to view its Java source files and supporting resources.

## Technologies

- **Java (JDK 17 or later)** — programming language and runtime
- **Object-Oriented Programming** — classes, objects, encapsulation, inheritance and polymorphism
- **Java Collections Framework** — lists, sets and maps
- **Exception and File Handling**
- **Multithreading and Concurrency**
- **Generics, Annotations and Reflection**
- **Git and GitHub** — version control

## How to Run

1. Install JDK 17 or later.
2. Clone this repository:
   ```bash
   git clone <your-repository-url>
   ```
3. Open the required `Practical N` folder.
4. Compile the Java source file. For a single-file program:
   ```bash
   javac FileName.java
   ```
5. Run the class containing `main()`:
   ```bash
   java ClassName
   ```

**For programs with multiple source files:** compile the required `.java` files together from the appropriate folder. For Practical 14's Maven-based exercise, open the folder containing `pom.xml` and run:

```bash
mvn test
```

> The exact class name and run command depend on the exercise. Check the source files and package declarations before compiling.

## Concepts Covered

- Java program structure, enums, records and switch expressions
- Classes, objects, constructors and encapsulation
- Static and final members
- Inheritance, abstract classes and polymorphism
- Interfaces, functional interfaces and lambda expressions
- Annotations and Reflection API
- Exception handling and custom exceptions
- File I/O and object serialization
- Threads, synchronization and concurrency utilities
- Collections Framework and Generics
- Layered application design and unit testing

## Official Practical List

The course practical-list PDF is available in the repository:

**[Open the CEUE203 Practical List](OOP_CEUE203_Practical_List%20(1).pdf)**

## 👨‍💻 Author

**Harsh Kunpara**  
B.Tech — Information Technology  
CHARUSAT University  
Student ID: `25IT048`

---
<div align="center">

**Made as part of the Object-Oriented Programming (CEUE203) practical coursework.**

</div>
