package model;

import enums.Qualification;

public class Applicant extends Person{
    private Integer applicationId;
    private Qualification qualification;

    public Applicant() {
    }

    public Applicant(String fullName, String phoneNumber, Integer applicationId, Qualification qualification) {
        super(fullName, phoneNumber);
        this.applicationId = applicationId;
        this.qualification = qualification;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "applicationId=" + applicationId +
                ", qualification=" + qualification +
                '}';
    }
}
