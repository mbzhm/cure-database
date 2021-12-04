package com.example.postgresql.models;

import java.util.List;

public class Form {
    public String keyword;
    public String comparisonOperation;
    public String comparisonOperation2;
    public Integer salary2;
    public Integer salary;
    public String joinOperation;
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

    public String getComparisonOperation2() {
        return comparisonOperation2;
    }

    public void setComparisonOperation2(String comparisonOperation2) {
        this.comparisonOperation2 = comparisonOperation2;
    }

    public Integer getSalary2() {
        return salary2;
    }

    public String getJoinOperation() {
        return joinOperation;
    }

    public void setJoinOperation(String joinOperation) {
        this.joinOperation = joinOperation;
    }

    public void setSalary2(Integer salary2) {
        this.salary2 = salary2;
    }

    public Form(String keyword, String comparisonOperation, Integer salary, String joinOperation,
                String comparisonOperation2, Integer salary2, String country, String sortBy, String sortDirection) {
        this.keyword = keyword;
        this.comparisonOperation = comparisonOperation;
        this.salary = salary;
        this.comparisonOperation2 = comparisonOperation2;
        this.joinOperation = joinOperation;
        this.salary2 = salary2;
        this.country = country;
        this.sortBy = sortBy;
        this.sortDirection = sortDirection;
    }

    public Form(String keyword) {
        this.keyword = keyword;
    }
}
