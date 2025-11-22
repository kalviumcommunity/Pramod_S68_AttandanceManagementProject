package com.school;

public class AttendanceRecord implements Storable {
    private Student student;
    private Course course;
    private String status;

    public AttendanceRecord(Student student, Course course, String status) {
        this.student = student;
        this.course = course;
        // Accept only "Present" or "Absent", otherwise set as "Invalid"
        if ("Present".equalsIgnoreCase(status) || "Absent".equalsIgnoreCase(status)) {
            this.status = status;
        } else {
            this.status = "Invalid";
            System.out.println("[Warning] Attendance status '" + status + "' is invalid for studentId=" + student.getId() + ", courseId=C" + course.getCourseId() + ". Marked as 'Invalid'.");
        }
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String getStatus() {
        return status;
    }

    public void displayRecord() {
        System.out.println("Student: " + student.getName() + " (ID: " + student.getId() + ") - Course: " + course.getCourseName() + " (C" + course.getCourseId() + ") - Status: " + status);
    }

    @Override
    public String toDataString() {
        return this.student.getId() + "," + this.course.getCourseId() + "," + this.status;
    }
}
