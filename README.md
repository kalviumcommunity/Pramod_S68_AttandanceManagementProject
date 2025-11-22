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