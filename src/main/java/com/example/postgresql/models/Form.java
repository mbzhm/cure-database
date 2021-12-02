package com.example.postgresql.models;

public class Form {
    public String keyword;
    public String comparisonOperation;
    public Integer salary;
    public String country;
    public String sortBy;
    public String sortDirection;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getComparisonOperation() {
        return comparisonOperation;
    }

    public void setComparisonOperation(String comparisonOperation) {
        this.comparisonOperation = comparisonOperation;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
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

    public Form(String keyword, String comparisonOperation, Integer salary, String country, String sortBy,
                String sortDirection) {
        this.keyword = keyword;
        this.comparisonOperation = comparisonOperation;
        this.salary = salary;
        this.country = country;
        this.sortBy = sortBy;
        this.sortDirection = sortDirection;
    }

    public Form(String keyword) {
        this.keyword = keyword;
    }
}
