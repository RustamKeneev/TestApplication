package com.onlineapteka.testapplication.model;

public class Professions {
    private String id;
    private int professionsImage;
    private String professionsTitle;
    private String professionsDescription;
    private String medicalProfessions;
//
//    public Professions(String id, int ic_logotype_auth, String аллерголог, String специалист_по_аллергии, String medicalProfessions) {
//    }

    public Professions(String id, int professionsImage, String professionsTitle, String professionsDescription, String medicalProfessions) {
        this.id = id;
        this.professionsImage = professionsImage;
        this.professionsTitle = professionsTitle;
        this.professionsDescription = professionsDescription;
        this.medicalProfessions = medicalProfessions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getProfessionsImage() {
        return professionsImage;
    }

    public void setProfessionsImage(int professionsImage) {
        this.professionsImage = professionsImage;
    }

    public String getProfessionsTitle() {
        return professionsTitle;
    }

    public void setProfessionsTitle(String professionsTitle) {
        this.professionsTitle = professionsTitle;
    }

    public String getProfessionsDescription() {
        return professionsDescription;
    }

    public void setProfessionsDescription(String professionsDescription) {
        this.professionsDescription = professionsDescription;
    }

    public String getMedicalProfessions() {
        return medicalProfessions;
    }

    public void setMedicalProfessions(String medicalProfessions) {
        this.medicalProfessions = medicalProfessions;
    }
}
