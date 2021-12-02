package com.example.postgresql.services;

import com.example.postgresql.models.User;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;

@Service
public class UserAdvancedService {

    public UserAdvancedService(){}

    public void filterByCountry(List<User> users, List<User> filteringUsers, String country){

        for(User user : filteringUsers){
            if(user.getCountry().equals(country)){
                users.add(user);
            }
        }
    }

    public void filterBySalary(List<User> filteredBySalaryUsers, List<User> users, String comparisonOperation, Integer salary) {
        for(User user : users){
            switch (comparisonOperation){
                case "equal":
                    if(user.getSalary() == salary) filteredBySalaryUsers.add(user);
                    break;
                case "more":
                    if(user.getSalary() > salary) filteredBySalaryUsers.add(user);
                    break;
                case "less":
                    if(user.getSalary() < salary) filteredBySalaryUsers.add(user);
                    break;
                case "notLess":
                    if(user.getSalary() >= salary) filteredBySalaryUsers.add(user);
                    break;
                case "noMore":
                    if(user.getSalary() <= salary) filteredBySalaryUsers.add(user);
                    break;
            }
        }
    }

    public void sortingBy(List<User> users, String sortBy, String sortDirection) {
        switch (sortBy) {
            case "name":
                if (sortDirection.equals("asc")) {
                    users.sort(new SortByName());
                } else {
                    users.sort(new SortByNameDesc());
                }
                break;
            case "surname":
                if (sortDirection.equals("asc")) {
                    users.sort(new SortBySurname());
                } else {
                    users.sort(new SortBySurnameDesc());
                }
                break;
            case "phone":
                if (sortDirection.equals("asc")) {
                    users.sort(new SortByPhone());
                } else {
                    users.sort(new SortByPhoneDesc());
                }
                break;
            case "salary":
                if (sortDirection.equals("asc")) {
                    users.sort(new SortBySalary());
                } else {
                    users.sort(new SortBySalaryDesc());
                }
                break;
            case "country":
                if (sortDirection.equals("asc")) {
                    users.sort(new SortByCountry());
                } else {
                    users.sort(new SortByCountryDesc());
                }
                break;

        }
    }

    static class SortByName implements Comparator<User> {
        public int compare(User a, User b){return a.getName().compareTo(b.getName());}
    }

    static class SortBySurname implements Comparator<User> {
        public int compare(User a, User b){return a.getSurname().compareTo(b.getSurname());}
    }

    static class SortBySalary implements Comparator<User> {
        public int compare(User a, User b){return a.getSalary()-b.getSalary();}
    }

    static class SortByPhone implements Comparator<User> {
        public int compare(User a, User b){return a.getPhone().compareTo(b.getPhone());}
    }

    static class SortByCountry implements Comparator<User> {
        public int compare(User a, User b){return a.getCountry().compareTo(b.getCountry());}
    }
    static class SortByNameDesc implements Comparator<User> {
        public int compare(User a, User b){return b.getName().compareTo(a.getName());}
    }

    static class SortBySurnameDesc implements Comparator<User> {
        public int compare(User a, User b){return b.getSurname().compareTo(a.getSurname());}
    }

    static class SortBySalaryDesc implements Comparator<User> {
        public int compare(User a, User b){return b.getSalary()-a.getSalary();}
    }

    static class SortByPhoneDesc implements Comparator<User> {
        public int compare(User a, User b){return b.getPhone().compareTo(a.getPhone());}
    }
    static class SortByCountryDesc implements Comparator<User> {
        public int compare(User a, User b){return b.getCountry().compareTo(a.getCountry());}
    }
}
