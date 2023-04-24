package com.example.qlsv;

import java.io.Serializable;

public class Course extends Student implements Serializable {
    private String name;
    private String studentId;
    private String semester;
    private String course1;
    private String course2;
    private String course3;
    private String course4;
    private float score1;
    private float score2;
    private float score3;
    private float score4;
    private float GPA;
    public Course(String name, String studentId, String semester, String course1, String course2, String course3, String course4, float score1, float score2, float score3, float score4, float GPA) {
        this.name = name;
        this.studentId = studentId;
        this.semester = semester;
        this.course1 = course1;
        this.course2 = course2;
        this.course3 = course3;
        this.course4 = course4;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
        this.score4 = score4;
        this.GPA = GPA;
    }

    public Course() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) { this.semester = semester; }

    public String getCourse1() {
        return course1;
    }

    public void setCourse1(String course1) { this.course1 = course1; }

    public String getCourse2() {
        return course2;
    }

    public void setCourse2(String course2) {
        this.course2 = course2;
    }

    public String getCourse3() {
        return course3;
    }

    public void setCourse3(String course3) { this.course3 = course3; }

    public String getCourse4() {
        return course4;
    }

    public void setCourse4(String course4) { this.course4 = course4; }

    public float getScore1() { return score1; }

    public void setScore1(float score1) { this.score1 = score1; }

    public float getScore2() { return score2; }

    public void setScore2(float score2) { this.score2 = score2; }

    public float getScore3() { return score3; }

    public void setScore3(float score3) { this.score3 = score3; }

    public float getScore4() { return score4; }

    public void setScore4(float score4) { this.score4 = score4; }

    public float getGPA() { return GPA; }

    public void setGPA(float GPA) { this.GPA = GPA; }
}
