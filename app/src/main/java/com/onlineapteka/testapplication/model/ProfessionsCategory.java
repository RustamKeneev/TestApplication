package com.onlineapteka.testapplication.model;

public class ProfessionsCategory {
    private String professionsName;
    private int professionsId;



    public ProfessionsCategory(String professionsName, int professionsId) {
        this.professionsName = professionsName;
        this.professionsId = professionsId;
    }

    public String getProfessionsName() {
        return professionsName;
    }

    public void setProfessionsName(String professionsName) {
        this.professionsName = professionsName;
    }

    public int getProfessionsId() {
        return professionsId;
    }

    public void setProfessionsId(int professionsId) {
        this.professionsId = professionsId;
    }
}
