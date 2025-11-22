package com.school;

public class Student extends Person implements Storable {
    private String gradeLevel;

    public Student(String name, String gradeLevel) {
        super(name);
        this.gradeLevel = gradeLevel;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Student, Grade: " + this.gradeLevel);
    }

    @Override
    public String toDataString() {
        return this.getId() + "," + this.getName() + "," + this.gradeLevel;
    }
}