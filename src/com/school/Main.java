package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- School Attendance System ---");

        Student[] students = new Student[4];
        students[0] = new Student("Alice Wonderland");
        students[1] = new Student("Bob the builder");
        students[2] = new Student("Charlie Chaplin");
        students[3] = new Student("Dora Explorer");

        Course[] courses = new Course[3];
        courses[0] = new Course("Intro to programming");
        courses[1] = new Course("Linear Algebra");
        courses[2] = new Course("Physics 101");

        System.out.println("\nRegistered Students: ");
        for(Student student : students) {
            if(student != null) student.displayDetails();
        }

        System.out.println("\nAvailable Courses: ");
        for(Course course : courses) {
            if (course != null) course.displayDetails();
        }

        List<AttendanceRecord> attendanceLog = new ArrayList<>();
        attendanceLog.add(new AttendanceRecord(students[0].getStudentId(), courses[0].getCourseId(), "Present"));
        attendanceLog.add(new AttendanceRecord(students[1].getStudentId(), courses[1].getCourseId(), "Absent"));
        attendanceLog.add(new AttendanceRecord(students[2].getStudentId(), courses[2].getCourseId(), "Late")); // Invalid status
        attendanceLog.add(new AttendanceRecord(students[3].getStudentId(), courses[0].getCourseId(), "Present"));

        System.out.println("\nAttendance Records:");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }

        System.out.println("\nSession 4: Encapsulation & Attendance Recording Complete");
    }
}