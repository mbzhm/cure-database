package com.example.postgresql.services;

import com.example.postgresql.models.Records;
import com.example.postgresql.repo.RecordRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class RecordService {
    private final RecordRepository recordsRepository;

    public RecordService(RecordRepository recordsRepository) {
        this.recordsRepository = recordsRepository;
    }

    public List<Records> getAllRecords() {
        return recordsRepository.getAllRecords();
    }

    public List<Records> findByKeyword(String keyword) {
        return recordsRepository.findByKeyword(keyword);
    }

    public Records findRecordBy(String email, String country, String diseaseCode) {
        return recordsRepository.findByEmailCAndCountryAndDiseaseCode(email, country, diseaseCode);
    }

    public void delete(Records records) {
        recordsRepository.delete(records);
    }

    public void filterByCountry(List<Records> recordss, List<Records> filteringRecords, String country) {

        for (Records records : filteringRecords) {
            if (country.equals(records.getCountry())) {
                recordss.add(records);
            }
        }
    }

    public void filterByD(List<Records> filteredByIntegerRecords, List<Records> recordss, String comparisonOperation, Integer integer) {
        for (Records records : recordss) {
            switch (comparisonOperation) {
                case "equal":
                    if (records.getTotal_deaths() == integer) filteredByIntegerRecords.add(records);
                    break;
                case "more":
                    if (records.getTotal_deaths() > integer) filteredByIntegerRecords.add(records);
                    break;
                case "less":
                    if (records.getTotal_deaths() < integer) filteredByIntegerRecords.add(records);
                    break;
                case "notLess":
                    if (records.getTotal_deaths() >= integer) filteredByIntegerRecords.add(records);
                    break;
                case "noMore":
                    if (records.getTotal_deaths() <= integer) filteredByIntegerRecords.add(records);
                    break;
            }
        }
    }

    public void filterByP(List<Records> filteredByIntegerRecords, List<Records> records, String comparisonOperation, Integer integer) {
        for (Records record : records) {
            switch (comparisonOperation) {
                case "equal":
                    if (record.getTotal_patients() == integer) filteredByIntegerRecords.add(record);
                    break;
                case "more":
                    if (record.getTotal_patients() > integer) filteredByIntegerRecords.add(record);
                    break;
                case "less":
                    if (record.getTotal_patients() < integer) filteredByIntegerRecords.add(record);
                    break;
                case "notLess":
                    if (record.getTotal_patients() >= integer) filteredByIntegerRecords.add(record);
                    break;
                case "noMore":
                    if (record.getTotal_patients() <= integer) filteredByIntegerRecords.add(record);
                    break;
            }
        }
    }

    public void sortingBy(List<Records> recordss, String sortBy, String sortDirection) {
        switch (sortBy) {
            case "email":
                if (sortDirection.equals("asc")) {
                    recordss.sort(new RecordService.SortByEmail());
                } else {
                    recordss.sort(new RecordService.SortByEmailDesc());
                }
                break;
            case "total_patients":
                if (sortDirection.equals("asc")) {
                    recordss.sort(new RecordService.SortByD());
                } else {
                    recordss.sort(new RecordService.SortByDDesc());
                }
            case "total_deaths":
                if (sortDirection.equals("asc")) {
                    recordss.sort(new RecordService.SortByP());
                } else {
                    recordss.sort(new RecordService.SortByPDesc());
                }
                break;
            case "country":
                if (sortDirection.equals("asc")) {
                    recordss.sort(new RecordService.SortByCountry());
                } else {
                    recordss.sort(new RecordService.SortByCountryDesc());
                }
                break;

        }
    }

    public Records findRecord(String email, String country, String disease) {
        return recordsRepository.findByEmailCAndCountryAndDiseaseCode(email, country, disease);
    }

    public void save(Records record) {
        recordsRepository.save(record);
    }

    public void filterByCode(List<Records> filteredByDiseaseCodeRecords, List<Records> records, String diseaseCode) {
        for (Records record : records) {
            if (diseaseCode.equals(record.getDiseaseCode())) {
                filteredByDiseaseCodeRecords.add(record);
            }
        }
    }

    static class SortByEmail implements Comparator<Records> {
        public int compare(Records a, Records b) {
            return a.getEmail().compareTo(b.getEmail());
        }
    }

    static class SortByEmailDesc implements Comparator<Records> {
        public int compare(Records a, Records b) {
            return b.getEmail().compareTo(a.getEmail());
        }
    }

    static class SortByP implements Comparator<Records> {
        public int compare(Records a, Records b) {
            return a.getTotal_patients() - b.getTotal_patients();
        }
    }

    static class SortByPDesc implements Comparator<Records> {
        public int compare(Records a, Records b) {
            return b.getTotal_patients() - a.getTotal_patients();
        }
    }

    static class SortByD implements Comparator<Records> {
        public int compare(Records a, Records b){return a.getTotal_deaths()-b.getTotal_deaths();}
    }

    static class SortByDDesc implements Comparator<Records> {
        public int compare(Records a, Records b){return b.getTotal_deaths()-a.getTotal_deaths();}
    }

    static class SortByCountry implements Comparator<Records> {
        public int compare(Records a, Records b){return a.getCountry().compareTo(b.getCountry());}
    }

    static class SortByCountryDesc implements Comparator<Records> {
        public int compare(Records a, Records b){return b.getCountry().compareTo(a.getCountry());}
    }
}
