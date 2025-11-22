package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void displaySchoolDirectory(RegistrationService regService) {
        System.out.println("\nSchool Directory:");
        for (Person p : regService.getAllPeople()) {
            p.displayDetails();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("--- School Attendance System ---");

    // Use RegistrationService to register people and courses
    FileStorageService storage = new FileStorageService();
    RegistrationService regService = new RegistrationService(storage);

    Student[] students = new Student[6];
    students[0] = regService.registerStudent("Alice Wonderland", "Grade 10");
    students[1] = regService.registerStudent("Bob the builder", "Grade 9");
    students[2] = regService.registerStudent("Charlie Chaplin", "Grade 11");
    students[3] = regService.registerStudent("Dora Explorer", "Grade 8");
    // additional students to demonstrate auto-ID progression
    students[4] = regService.registerStudent("Eve Polastri", "Grade 12");
    students[5] = regService.registerStudent("Frank Underwood", "Grade 10");

    Course[] courses = new Course[5];
    courses[0] = regService.createCourse("Intro to programming");
    courses[1] = regService.createCourse("Linear Algebra");
    courses[2] = regService.createCourse("Physics 101");
    // additional courses to demonstrate auto-ID progression
    courses[3] = regService.createCourse("Chemistry 101");
    courses[4] = regService.createCourse("English Literature");

        System.out.println("\nRegistered Students: ");
        for(Student student : students) {
            if(student != null) student.displayDetails();
        }

        System.out.println("\nAvailable Courses: ");
        for(Course course : courses) {
            if (course != null) course.displayDetails();
        }

    // create attendance service with injected RegistrationService
    AttendanceService attendanceService = new AttendanceService(regService, storage);

    // Mark attendance using object-based overload
    attendanceService.markAttendance(students[0], courses[0], "Present");
    attendanceService.markAttendance(students[1], courses[1], "Absent");
    attendanceService.markAttendance(students[2], courses[2], "Late"); // Invalid status
    attendanceService.markAttendance(students[3], courses[0], "Present");

    // Mark attendance using ID-based overload (RegistrationService will be used for lookups)
    attendanceService.markAttendance(students[4].getId(), courses[3].getCourseId(), "Present");
    attendanceService.markAttendance(students[5].getId(), courses[4].getCourseId(), "Absent");

    // Create staff/teacher examples and register them
    Teacher teacher1 = regService.registerTeacher("Mr. Smith", "Mathematics");
    Staff staff1 = regService.registerStaff("Ms. Green", "Librarian");

    // Build a polymorphic list of people and display the directory
    List<Person> schoolPeople = new ArrayList<>();
    for (Student s : students) if (s != null) schoolPeople.add(s);
    schoolPeople.add(teacher1);
    schoolPeople.add(staff1);

    displaySchoolDirectory(regService);

    System.out.println("\nAttendance Records:");
        for (AttendanceRecord record : attendanceService.getAttendanceLog()) {
            record.displayRecord();
        }

        // Persist registrations and attendance via services
        regService.saveAllRegistrations();
        attendanceService.saveAttendanceData();

        System.out.println("\nSession 4: Encapsulation & Attendance Recording Complete");
    }
}