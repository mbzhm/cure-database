package com.example.postgresql.models.disease;

import javax.persistence.*;

@Entity
@Table(name="disease")
public class Disease {
    @Id
    @Column(name="disease_code")
    private String diseaseCode;

    @Column(name="pathogen")
    private String pathogen;

    @Column(name="description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id")
    private DiseaseType diseaseType;

    public Disease() {

    }

    public String getDiseaseCode() {
        return diseaseCode;
    }

    public void setDiseaseCode(String diseaseCode) {
        this.diseaseCode = diseaseCode;
    }

    public String getPathogen() {
        return pathogen;
    }

    public void setPathogen(String pathogen) {
        this.pathogen = pathogen;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DiseaseType getDiseaseType() {
        return diseaseType;
    }

    public void setDiseaseType(DiseaseType diseaseType) {
        this.diseaseType = diseaseType;
    }

    public Disease(String diseaseCode, String pathogen, String description, DiseaseType diseaseType) {
        this.diseaseCode = diseaseCode;
        this.pathogen = pathogen;
        this.description = description;
        this.diseaseType = diseaseType;
    }
}
