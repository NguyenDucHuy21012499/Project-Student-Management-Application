package com.example.qlsv;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private String studentId;
    private String gender;
    private String birthday;
    private String year;
    private String contactNo;
    private String address;
    public Student(String name, String studentId, String gender, String birthday, String year, String contactNo, String address) {
        this.name = name;
        this.studentId = studentId;
        this.gender = gender;
        this.birthday = birthday;
        this.year = year;
        this.contactNo = contactNo;
        this.address = address;
    }

    public Student() {
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getStudentId() { return studentId; }

    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getBirthday() { return birthday; }

    public void setBirthday(String birthday) { this.birthday = birthday; }

    public String getYear() { return year; }

    public void setYear(String year) { this.year = year; }

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }

    public String getContactNo() { return contactNo; }

    public void setContactNo(String contactNo) { this.contactNo = contactNo; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }
}
