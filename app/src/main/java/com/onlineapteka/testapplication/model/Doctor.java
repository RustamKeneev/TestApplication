package com.onlineapteka.testapplication.model;

public class Doctor {
    private String id;
    private String firstName;
    private String secondName;
    private String lastName;
    private String doctorImage;
    private String doctorStatus;
    private String doctorWorkLocation;
    private String phoneNumber;
    private String doctorEducation;
    private String doctorInfo;
    private String doctorFullName;
    private String type;
    private String doctor_type;

    public Doctor() {
    }

    public Doctor(String id, String firstName, String secondName, String lastName, String doctorImage,
                  String doctorStatus, String doctorWorkLocation, String phoneNumber,
                  String doctorEducation, String doctorInfo, String doctorFullName, String type,
                  String doctor_type) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.doctorImage = doctorImage;
        this.doctorStatus = doctorStatus;
        this.doctorWorkLocation = doctorWorkLocation;
        this.phoneNumber = phoneNumber;
        this.doctorEducation = doctorEducation;
        this.doctorInfo = doctorInfo;
        this.doctorFullName = doctorFullName;
        this.type = type;
        this.doctor_type = doctor_type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDoctorImage() {
        return doctorImage;
    }

    public void setDoctorImage(String doctorImage) {
        this.doctorImage = doctorImage;
    }

    public String getDoctorStatus() {
        return doctorStatus;
    }

    public void setDoctorStatus(String doctorStatus) {
        this.doctorStatus = doctorStatus;
    }

    public String getDoctorWorkLocation() {
        return doctorWorkLocation;
    }

    public void setDoctorWorkLocation(String doctorWorkLocation) {
        this.doctorWorkLocation = doctorWorkLocation;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDoctorEducation() {
        return doctorEducation;
    }

    public void setDoctorEducation(String doctorEducation) {
        this.doctorEducation = doctorEducation;
    }

    public String getDoctorInfo() {
        return doctorInfo;
    }

    public void setDoctorInfo(String doctorInfo) {
        this.doctorInfo = doctorInfo;
    }

    public String getDoctorFullName() {
        return doctorFullName;
    }

    public void setDoctorFullName(String doctorFullName) {
        this.doctorFullName = doctorFullName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDoctor_type() {
        return doctor_type;
    }

    public void setDoctor_type(String doctor_type) {
        this.doctor_type = doctor_type;
    }
}
