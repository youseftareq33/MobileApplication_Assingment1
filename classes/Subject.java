package com.example.assingment_1.classes;

public class Subject {

    // Attributes for Subject
    private String subject_name;


    //---------------------------------------------------------------------------------
    // Constructor for Subject
    public Subject(String subject_name) {
        this.subject_name = subject_name;
    }


    //---------------------------------------------------------------------------------
    // Getter and Setter

    // for Subject Name
    public String getSubjectName() {
        return subject_name;
    }

    public void setSubjectName(String subject_name) {
        this.subject_name = subject_name;
    }

}
