package com.school;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
// no unused imports

public class AttendanceService {
    private List<AttendanceRecord> attendanceLog;
    private FileStorageService storageService;

    public AttendanceService(FileStorageService storageService) {
        this.attendanceLog = new ArrayList<>();
        this.storageService = storageService;
    }

    // Mark attendance with actual objects
    public void markAttendance(Student student, Course course, String status) {
        AttendanceRecord record = new AttendanceRecord(student, course, status);
        attendanceLog.add(record);
        System.out.println("Marked attendance: " + record.toDataString());
    }

    // Mark attendance by IDs - look up Student and Course from provided lists
    public void markAttendance(int studentId, int courseId, String status, List<Student> allStudents, List<Course> allCourses) {
        Student s = findStudentById(studentId, allStudents);
        Course c = findCourseById(courseId, allCourses);
        if (s == null || c == null) {
            System.err.println("Cannot mark attendance: student or course not found (" + studentId + ", " + courseId + ")");
            return;
        }
        markAttendance(s, c, status);
    }

    private Student findStudentById(int id, List<Student> allStudents) {
        if (allStudents == null) return null;
        Optional<Student> opt = allStudents.stream().filter(st -> st.getId() == id).findFirst();
        return opt.orElse(null);
    }

    private Course findCourseById(int id, List<Course> allCourses) {
        if (allCourses == null) return null;
        Optional<Course> opt = allCourses.stream().filter(c -> c.getCourseId() == id).findFirst();
        return opt.orElse(null);
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
