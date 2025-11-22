package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
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

    List<AttendanceRecord> attendanceLog = new ArrayList<>();
    attendanceLog.add(new AttendanceRecord(students[0].getId(), courses[0].getCourseId(), "Present"));
    attendanceLog.add(new AttendanceRecord(students[1].getId(), courses[1].getCourseId(), "Absent"));
    attendanceLog.add(new AttendanceRecord(students[2].getId(), courses[2].getCourseId(), "Late")); // Invalid status
    attendanceLog.add(new AttendanceRecord(students[3].getId(), courses[0].getCourseId(), "Present"));

    // attendance for additional students
    attendanceLog.add(new AttendanceRecord(students[4].getId(), courses[3].getCourseId(), "Present"));
    attendanceLog.add(new AttendanceRecord(students[5].getId(), courses[4].getCourseId(), "Absent"));

    // Create staff/teacher examples and display them
    System.out.println("\nStaff and Teaching Examples:");
    Teacher teacher1 = new Teacher("Mr. Smith", "Mathematics");
    Staff staff1 = new Staff("Ms. Green", "Librarian");
    teacher1.displayDetails();
    staff1.displayDetails();

    System.out.println("\nAttendance Records:");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }

        // --- Persistence: save to files using FileStorageService ---
        ArrayList<Student> studentList = new ArrayList<>();
        for (Student s : students) if (s != null) studentList.add(s);

        ArrayList<Course> courseList = new ArrayList<>();
        for (Course c : courses) if (c != null) courseList.add(c);

        ArrayList<AttendanceRecord> recordList = new ArrayList<>(attendanceLog);

        FileStorageService storage = new FileStorageService();
        storage.saveData(studentList, "students.txt");
        storage.saveData(courseList, "courses.txt");
        storage.saveData(recordList, "attendance_log.txt");

        System.out.println("\nSession 4: Encapsulation & Attendance Recording Complete");
    }
}