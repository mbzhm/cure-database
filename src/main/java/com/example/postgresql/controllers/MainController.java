package com.example.postgresql.controllers;

import com.example.postgresql.models.*;
import com.example.postgresql.services.UserAdvancedService;
import com.example.postgresql.services.UserService;
import com.example.postgresql.services.RecordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {

    private final UserService userService;
    private final UserAdvancedService userAdvancedService;
    private final RecordService recordService;


    public MainController(UserService userService, UserAdvancedService userAdvancedService, RecordService recordService) {

        this.userService = userService;
        this.userAdvancedService = userAdvancedService;
        this.recordService = recordService;
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("title", "Home page");
        return "home";
    }

    @GetMapping("/users-advanced-search")
    public String usersAdvancedSearch(String keyword,
                                      String country,
                                      String comparisonOperation,
                                      Integer salary,
                                      @RequestParam(defaultValue = "inter") String joinOperation,
                                      String comparisonOperation2,
                                      Integer salary2,
                                      @RequestParam(defaultValue = "name") String sortBy,
                                      @RequestParam(defaultValue = "asc") String sortDirection,
                                      Model model){
        model.addAttribute("title", "Advanced Search (users)");

        List<User> users;

        if(keyword != null) {
            users = userService.findByKeyword(keyword);
        }else{
            users = userService.getAllUsers();
        }

        List<User> filteredByCountryUsers;

        if(country != null && !country.equals("None")) {
            filteredByCountryUsers = new ArrayList<>();
            userAdvancedService.filterByCountry(filteredByCountryUsers, users, country);
        }else{
            filteredByCountryUsers = users;
        }

        List<User> filteredBySalaryUsers;

        if(salary != null) {
            filteredBySalaryUsers = new ArrayList<>();
            userAdvancedService.filterBySalary(filteredBySalaryUsers, filteredByCountryUsers,
                    comparisonOperation, salary);
        }else{
            filteredBySalaryUsers = filteredByCountryUsers;
        }

        List<User> filteredBySalary2Users;

        if(salary2 != null) {
            if (joinOperation.equals("inter")){
                filteredBySalary2Users = new ArrayList<>();
            userAdvancedService.filterBySalary(filteredBySalary2Users, filteredBySalaryUsers,
                    comparisonOperation2, salary2);
            }else{
                userAdvancedService.filterBySalary(filteredBySalaryUsers, filteredByCountryUsers,
                        comparisonOperation2, salary2);
                filteredBySalary2Users = filteredBySalaryUsers;
            }
        }else{
            filteredBySalary2Users = filteredBySalaryUsers;
        }

        userAdvancedService.sortingBy(filteredBySalary2Users, sortBy, sortDirection);
        model.addAttribute("users", filteredBySalary2Users);
        model.addAttribute("form", new Form(keyword, comparisonOperation, salary, joinOperation,
                comparisonOperation2, salary2, country, sortBy, sortDirection));
        return "users-advanced-search";
    }

    @GetMapping("/records-advanced-search")
    public String recordsAdvancedSearch(String email,
                                      String diseaseCode,
                                      String country,
                                      String comparisonOperationD,
                                      Integer total_deaths,
                                      @RequestParam(defaultValue = "inter") String joinOperationD,
                                      String comparisonOperationD2,
                                      Integer total_deaths2,
                                      String comparisonOperationP,
                                      Integer total_patients,
                                      @RequestParam(defaultValue = "inter") String joinOperationP,
                                      String comparisonOperationP2,
                                      Integer total_patients2,
                                      @RequestParam(defaultValue = "email") String sortBy,
                                      @RequestParam(defaultValue = "asc") String sortDirection,
                                      Model model){
        model.addAttribute("title", "Advanced Search (records)");

        List<Records> records;

        if(email != null) {
            records = recordService.findByKeyword(email);
        }else{
            records = recordService.getAllRecords();
        }

        List<Records> filteredByDiseaseCodeRecords;
        if(diseaseCode != null && !diseaseCode.equals("None")) {
            filteredByDiseaseCodeRecords = new ArrayList<>();
            recordService.filterByCode(filteredByDiseaseCodeRecords, records, diseaseCode);
        }else{
            filteredByDiseaseCodeRecords = records;
        }

        List<Records> filteredByCountryRecords;

        if(country != null && !country.equals("None")) {
            filteredByCountryRecords = new ArrayList<>();
            recordService.filterByCountry(filteredByCountryRecords, filteredByDiseaseCodeRecords, country);
        }else{
            filteredByCountryRecords = filteredByDiseaseCodeRecords;
        }

        List<Records> filteredByDRecords;

        if(total_deaths != null) {
            filteredByDRecords = new ArrayList<>();
            recordService.filterByD(filteredByDRecords, filteredByCountryRecords,
                    comparisonOperationD, total_deaths);
        }else{
            filteredByDRecords = filteredByCountryRecords;
        }

        List<Records> filteredByD2Records;

        if(total_deaths2 != null) {
            if (joinOperationD.equals("inter")){
                filteredByD2Records = new ArrayList<>();
                recordService.filterByD(filteredByD2Records, filteredByDRecords,
                        comparisonOperationD2, total_deaths2);
            }else{
                recordService.filterByD(filteredByDRecords, filteredByCountryRecords,
                        comparisonOperationD2, total_deaths2);
                filteredByD2Records = filteredByDRecords;
            }
        }else{
            filteredByD2Records = filteredByDRecords;
        }

        List<Records> filteredByPRecords;

        if(total_patients != null) {
            filteredByPRecords = new ArrayList<>();
            recordService.filterByP(filteredByPRecords, filteredByD2Records,
                    comparisonOperationP, total_patients);
        }else{
            filteredByPRecords = filteredByD2Records;
        }

        List<Records> filteredByP2Records;

        if(total_patients2 != null) {
            if (joinOperationD.equals("inter")){
                filteredByP2Records = new ArrayList<>();
                recordService.filterByP(filteredByP2Records, filteredByPRecords,
                        comparisonOperationP2, total_patients2);
            }else{
                recordService.filterByP(filteredByPRecords, filteredByD2Records,
                        comparisonOperationP2, total_patients2);
                filteredByP2Records = filteredByPRecords;
            }
        }else{
            filteredByP2Records = filteredByD2Records;
        }

        recordService.sortingBy(filteredByP2Records, sortBy, sortDirection);
        model.addAttribute("diseaseCodes", diseaseCodes);
        model.addAttribute("records", filteredByP2Records);
        model.addAttribute("recordForm", new RecordForm(email, diseaseCode, comparisonOperationD, comparisonOperationD2, total_deaths, total_deaths2, joinOperationD, comparisonOperationP, comparisonOperationP2, total_patients, total_patients2, joinOperationP, country, sortBy,sortDirection));
        return "records-advanced-search";
    }

    @GetMapping("/users")
    public String users(String keyword, Model model){
        model.addAttribute("title", "Users page");

        Iterable<User> users;
        if(keyword != null) {
            users = userService.findByKeyword(keyword);
        }else{
            users = userService.getAllUsers();
        }

        model.addAttribute("users", users);
        model.addAttribute("form", new Form(keyword));
        return "users";
    }

    @GetMapping("/records")
    public String records(String keyword, Model model){
        model.addAttribute("title", "Records page");

        Iterable<Records> records;
        if(keyword != null) {
            records = recordService.findByKeyword(keyword);
        }else{
            records = recordService.getAllRecords();
        }

        model.addAttribute("records", records);
        model.addAttribute("recordForm", new RecordForm(keyword));
        return "records";
    }

    @PostMapping("/users-add")
    public String addUser(@Valid User user, Model model) {
        model.addAttribute("title", "Add user");
        return "add-user";
    }

    @PostMapping("/records-add")
    public String addRecords(@Valid Records record, Model model) {

        model.addAttribute("diseaseCodes", diseaseCodes);
        model.addAttribute("title", "Add record");
        return "add-record";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "add-user";
        }

        userService.save(user);
        return "redirect:/users";
    }

    @PostMapping("/addrecord")
    public String addRecord(@Valid Records record, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "add-record";
        }

        model.addAttribute("records", record);

        recordService.save(record);
        return "redirect:/records";
    }

    @GetMapping("/edit/{email}")
    public String showUpdateForm(@PathVariable("email") String email, Model model) {
        User user = userService.findUser(email);

        model.addAttribute("user", user);
        return "update-user";
    }

    @GetMapping("/editRecord/{email}/{country}/{diseaseCode}")
    public String showUpdateForm(@PathVariable("email") String email,
                                 @PathVariable("country") String country,
                                 @PathVariable("diseaseCode") String diseaseCode, Model model) {
        Records record = recordService.findRecordBy(email, country, diseaseCode);

        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);

        model.addAttribute("diseaseCodes", diseaseCodes);

        model.addAttribute("records", record);
        return "update-record";
    }

    @PostMapping("/update/{email}")
    public String updateUser(@PathVariable("email") String email, @Valid User user,
                             BindingResult result, Model model) {

        if (result.hasErrors()) {
            user.setEmail(email);
            return "users";
        }

        if(user.getEmail() != email){
            User old_user = userService.findUser(email);
            userService.delete(old_user);
        }

        userService.save(user);
        return "redirect:/users";
    }

    @PostMapping("/updateRecord/{email}/{country}/{diseaseCode}")
    public String updateUser(@PathVariable("email") String email,
                             @PathVariable("country") String country,
                             @PathVariable("diseaseCode") String diseaseCode,
                             @Valid Records record,
                             BindingResult result, Model model) {

        model.addAttribute("diseaseCodes", diseaseCodes);

        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);

        if (result.hasErrors()) {
            record.setEmail(email);
            return "records";
        }
        if (result.hasErrors()) {
            record.setCountry(country);
            return "records";
        }
        if (result.hasErrors()) {
            record.setDiseaseCode(diseaseCode);
            return "records";
        }

        if(record.getEmail() != email || record.getCountry() != country
                || record.getDiseaseCode() != diseaseCode){
            Records old_record = recordService.findRecord(email, country, diseaseCode);
            recordService.delete(old_record);
        }

        recordService.save(record);
        return "redirect:/records";
    }

    @GetMapping("/delete/{email}")
    public String deleteUser(@PathVariable("email") String email, Model model) {
        User user = userService.findUser(email);
        userService.delete(user);
        return "redirect:/users";
    }

    @GetMapping("/deleteRecord/{email}/{country}/{diseaseCode}")
    public String deleteRecord(@PathVariable("email") String email,
                               @PathVariable("country") String country,
                               @PathVariable("diseaseCode")String diseaseCode, Model model) {
        Records record = recordService.findRecordBy(email, country, diseaseCode);
        recordService.delete(record);
        return "redirect:/records";
    }

    @GetMapping("/form")
    public String showForm(@Valid User user) {
        return "add-user";
    }

    @GetMapping("/recordForm")
    public String showForm(@Valid Records record, Model model) {

        model.addAttribute("records", record);

        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);

        model.addAttribute("diseaseCodes", diseaseCodes);
        return "add-record";
    }

    public static List<String> diseaseCodes = new ArrayList<String>(
            Arrays.asList("A15.7", "U07.1", "A00.9", "C80.1", "G30.9", "F32.0", "487,0",
            "B20.0", "B44.9", "J18.9"));
}
