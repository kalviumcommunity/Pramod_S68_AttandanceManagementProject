package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void displaySchoolDirectory(List<Person> people) {
    System.out.println("\nSchool Directory:");
        for (Person p : people) {
            p.displayDetails();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("--- School Attendance System ---");

    Student[] students = new Student[6];
    students[0] = new Student("Alice Wonderland", "Grade 10");
    students[1] = new Student("Bob the builder", "Grade 9");
    students[2] = new Student("Charlie Chaplin", "Grade 11");
    students[3] = new Student("Dora Explorer", "Grade 8");
    // additional students to demonstrate auto-ID progression
    students[4] = new Student("Eve Polastri", "Grade 12");
    students[5] = new Student("Frank Underwood", "Grade 10");

    Course[] courses = new Course[5];
    courses[0] = new Course("Intro to programming");
    courses[1] = new Course("Linear Algebra");
    courses[2] = new Course("Physics 101");
    // additional courses to demonstrate auto-ID progression
    courses[3] = new Course("Chemistry 101");
    courses[4] = new Course("English Literature");

        System.out.println("\nRegistered Students: ");
        for(Student student : students) {
            if(student != null) student.displayDetails();
        }

        System.out.println("\nAvailable Courses: ");
        for(Course course : courses) {
            if (course != null) course.displayDetails();
        }

    // create storage and attendance service
    FileStorageService storage = new FileStorageService();
    AttendanceService attendanceService = new AttendanceService(storage);

    // prepare lists of all students and courses (for ID-based lookups)
    ArrayList<Student> allStudents = new ArrayList<>();
    for (Student s : students) if (s != null) allStudents.add(s);
    ArrayList<Course> allCourses = new ArrayList<>();
    for (Course c : courses) if (c != null) allCourses.add(c);

    // Mark attendance using object-based overload
    attendanceService.markAttendance(students[0], courses[0], "Present");
    attendanceService.markAttendance(students[1], courses[1], "Absent");
    attendanceService.markAttendance(students[2], courses[2], "Late"); // Invalid status
    attendanceService.markAttendance(students[3], courses[0], "Present");

    // Mark attendance using ID-based overload (demonstrates lookup)
    attendanceService.markAttendance(students[4].getId(), courses[3].getCourseId(), "Present", allStudents, allCourses);
    attendanceService.markAttendance(students[5].getId(), courses[4].getCourseId(), "Absent", allStudents, allCourses);

    // Create staff/teacher examples and display them
    Teacher teacher1 = new Teacher("Mr. Smith", "Mathematics");
    Staff staff1 = new Staff("Ms. Green", "Librarian");

    // Build a polymorphic list of people and display the directory
    List<Person> schoolPeople = new ArrayList<>();
    for (Student s : students) if (s != null) schoolPeople.add(s);
    schoolPeople.add(teacher1);
    schoolPeople.add(staff1);

    displaySchoolDirectory(schoolPeople);

    System.out.println("\nAttendance Records:");
        for (AttendanceRecord record : attendanceService.getAttendanceLog()) {
            record.displayRecord();
        }

        // --- Persistence: save to files using FileStorageService ---
        // Demonstrate filtering Student objects from the polymorphic people list
        ArrayList<Student> studentList = new ArrayList<>();
        for (Person p : schoolPeople) {
            if (p instanceof Student) {
                studentList.add((Student) p);
            }
        }

        ArrayList<Course> courseList = new ArrayList<>();
        for (Course c : courses) if (c != null) courseList.add(c);

    ArrayList<AttendanceRecord> recordList = new ArrayList<>(attendanceService.getAttendanceLog());

    storage.saveData(studentList, "students.txt");
    storage.saveData(courseList, "courses.txt");
    storage.saveData(recordList, "attendance_log.txt");

        System.out.println("\nSession 4: Encapsulation & Attendance Recording Complete");
    }
}