package com.example.postgresql.models;

public class RecordForm {
    public String keyword;
    public String diseaseCode;
    public String comparisonOperationD;
    public String comparisonOperationD2;
    public Integer total_deaths;
    public Integer total_deaths2;
    public String joinOperationD;
    public String comparisonOperationP;
    public String comparisonOperationP2;
    public Integer total_patients;
    public Integer total_patients2;
    public String joinOperationP;
    public String country;
    public String sortBy;
    public String sortDirection;

    public RecordForm(String keyword, String diseaseCode, String comparisonOperationD, String comparisonOperationD2, Integer total_deaths, Integer total_deaths2, String joinOperationD, String comparisonOperationP, String comparisonOperationP2, Integer total_patients, Integer total_patients2, String joinOperationP, String country, String sortBy, String sortDirection) {
        this.keyword = keyword;
        this.diseaseCode = diseaseCode;
        this.comparisonOperationD = comparisonOperationD;
        this.comparisonOperationD2 = comparisonOperationD2;
        this.total_deaths = total_deaths;
        this.total_deaths2 = total_deaths2;
        this.joinOperationD = joinOperationD;
        this.comparisonOperationP = comparisonOperationP;
        this.comparisonOperationP2 = comparisonOperationP2;
        this.total_patients = total_patients;
        this.total_patients2 = total_patients2;
        this.joinOperationP = joinOperationP;
        this.country = country;
        this.sortBy = sortBy;
        this.sortDirection = sortDirection;
    }

    public RecordForm(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getComparisonOperationD() {
        return comparisonOperationD;
    }

    public void setComparisonOperationD(String comparisonOperationD) {
        this.comparisonOperationD = comparisonOperationD;
    }

    public String getComparisonOperationD2() {
        return comparisonOperationD2;
    }

    public void setComparisonOperationD2(String comparisonOperationD2) {
        this.comparisonOperationD2 = comparisonOperationD2;
    }

    public Integer getTotal_deaths() {
        return total_deaths;
    }

    public void setTotal_deaths(Integer total_deaths) {
        this.total_deaths = total_deaths;
    }

    public Integer getTotal_deaths2() {
        return total_deaths2;
    }

    public void setTotal_deaths2(Integer total_deaths2) {
        this.total_deaths2 = total_deaths2;
    }

    public String getJoinOperationD() {
        return joinOperationD;
    }

    public void setJoinOperationD(String joinOperationD) {
        this.joinOperationD = joinOperationD;
    }

    public String getComparisonOperationP() {
        return comparisonOperationP;
    }

    public void setComparisonOperationP(String comparisonOperationP) {
        this.comparisonOperationP = comparisonOperationP;
    }

    public String getComparisonOperationP2() {
        return comparisonOperationP2;
    }

    public void setComparisonOperationP2(String comparisonOperationP2) {
        this.comparisonOperationP2 = comparisonOperationP2;
    }

    public Integer getTotal_patients() {
        return total_patients;
    }

    public void setTotal_patients(Integer total_patients) {
        this.total_patients = total_patients;
    }

    public Integer getTotal_patients2() {
        return total_patients2;
    }

    public void setTotal_patients2(Integer total_patients2) {
        this.total_patients2 = total_patients2;
    }

    public String getJoinOperationP() {
        return joinOperationP;
    }

    public void setJoinOperationP(String joinOperationP) {
        this.joinOperationP = joinOperationP;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }

    public String getDiseaseCode() {
        return diseaseCode;
    }

    public void setDiseaseCode(String diseaseCode) {
        this.diseaseCode = diseaseCode;
    }
}
