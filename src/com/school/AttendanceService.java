package com.school;

import java.util.ArrayList;
import java.util.List;
// no unused imports
// no unused imports

public class AttendanceService {
    private List<AttendanceRecord> attendanceLog;
    private FileStorageService storageService;
    private RegistrationService registrationService;

    public AttendanceService(RegistrationService registrationService, FileStorageService storageService) {
        this.attendanceLog = new ArrayList<>();
        this.storageService = storageService;
        this.registrationService = registrationService;
    }

    // Mark attendance with actual objects
    public void markAttendance(Student student, Course course, String status) {
        AttendanceRecord record = new AttendanceRecord(student, course, status);
        attendanceLog.add(record);
        System.out.println("Marked attendance: " + record.toDataString());
    }

    // Mark attendance by IDs - lookup via RegistrationService
    public void markAttendance(int studentId, int courseId, String status) {
        Student s = registrationService.findStudentById(studentId);
        Course c = registrationService.findCourseById(courseId);
        if (s == null || c == null) {
            System.err.println("Cannot mark attendance: student or course not found (" + studentId + ", " + courseId + ")");
            return;
        }
        markAttendance(s, c, status);
    }

    public void displayAttendanceLog() {
        System.out.println("\nAttendance Log (all):");
        attendanceLog.forEach(AttendanceRecord::displayRecord);
    }

    public void displayAttendanceLog(Student student) {
        System.out.println("\nAttendance for: " + student.getName() + " (ID: " + student.getId() + ")");
        attendanceLog.stream()
                .filter(r -> r.getStudent().getId() == student.getId())
                .forEach(AttendanceRecord::displayRecord);
    }

    public void displayAttendanceLog(Course course) {
        System.out.println("\nAttendance for Course: " + course.getCourseName() + " (C" + course.getCourseId() + ")");
        attendanceLog.stream()
                .filter(r -> r.getCourse().getCourseId() == course.getCourseId())
                .forEach(AttendanceRecord::displayRecord);
    }

    public void saveAttendanceData() {
        storageService.saveData(attendanceLog, "attendance_log.txt");
    }

    public List<AttendanceRecord> getAttendanceLog() {
        return attendanceLog;
    }
}
