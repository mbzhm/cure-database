package com.example.postgresql.models.disease;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="diseasetype")
public class DiseaseType {

    @Id
    @NotNull
    @Column(name="id")
    private int id;

    @Column(name="description")
    private String description;

    public DiseaseType() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DiseaseType(int id, String description) {
        this.id = id;
        this.description = description;
    }
}
