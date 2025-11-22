# MayurKSetty_S68_AttandanceManagementProject

## Overview

A simple Java-based School Attendance Management System demonstrating object-oriented programming concepts such as encapsulation, constructors, static variables, and basic validation. The system manages students, courses, and attendance records.

## Features

- Register students and courses with auto-generated unique IDs
- Display student and course details
- Record and validate attendance status ("Present" or "Absent")
- Encapsulate data with private fields and public getters
- Store and display attendance logs

## Folder Structure

```
src/
  com/school/
    Main.java
    Student.java
    Course.java
    AttendanceRecord.java
```

## Setup & Compilation

1. **Compile all Java files:**
   ```sh
   javac -d out src/com/school/*.java
   ```

2. **Run the application:**
   ```sh
   java -cp out com.school.Main
   ```

## Usage

- The application registers a set of students and courses.
- Attendance records are created and validated.
- All details and records are displayed in the console.

## Development Progress

### Part 1: Project Setup
- Initial folder structure and base files created.
- Java environment and compilation verified.

### Part 2: Student & Course Classes
- Implemented basic `Student` and `Course` classes.
- Added methods for displaying details.
- Demonstrated object creation and method usage in `Main.java`.

### Part 3: Constructors & Auto-ID
- Constructors for `Student` and `Course` with automatic unique ID generation using static variables.
- Demonstrated auto-ID by creating multiple instances in `Main.java`.

### Part 4: Data Encapsulation & Attendance Recording
- Applied encapsulation to `Student` and `Course` classes (private fields, public getters).
- Introduced `AttendanceRecord` class with private fields, constructor, and getters.
- Added validation for attendance status (only "Present" or "Absent").
- Used `ArrayList` in `Main.java` to store and display attendance records.
- Demonstrated retrieving IDs using getters when creating records.

## Session 2: Core Domain Modelling
- Defined `Student` class with `studentId`, `name`, `setDetails()`, and `displayDetails()` method.
- Defined `Course` class with `courseId`, `courseName`, `setDetails()`, and `displayDetails()` method.
- Utilized arrays of objects in `Main.java` to manage and display multiple students and courses.
- Introduced basic usage of `this` keyword.

### How to Run
1. Navigate to the project root directory.
2. Compile: `javac src/com/school/Student.java src/com/school/Course.java src/com/school/Main.java` (or `javac src/com/school/*.java`)
3. Run: `java -cp src com.school.Main`

### Submission
- Link to your Pull Request.
- Screenshot of the output of running the file.
- Screenshot of the command-line output after pushing the code.

## Part 3: Constructor Initialization & Auto-ID Generation
- Implemented parameterized constructors in `Student` and `Course` classes for object initialization.
- Utilized `private static` member variables for automatic and unique ID generation.
- Demonstrated the use of the `this` keyword to distinguish instance variables from constructor parameters.
- Changed `Course`'s `courseId` to `int` for simpler auto-generation and updated its display.
- Updated `Main.java` to use constructors and show ID progression by creating additional instances.

### How to Run (ensure this is up-to-date)
1. Navigate to the project root directory.
2. Compile: `javac src/com/school/Student.java src/com/school/Course.java src/com/school/Main.java` (or `javac src/com/school/*.java`)
3. Run: `java -cp src com.school.Main`