package com.school;

public class Staff extends Person implements Storable {
    private String role;

    public Staff(String name, String role) {
        super(name);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Staff, Staff Role: " + this.role);
    }

    @Override
    public String toDataString() {
        return this.getId() + "," + this.getName() + "," + this.role;
    }
}
