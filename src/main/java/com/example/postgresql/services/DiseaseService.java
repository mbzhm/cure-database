package com.example.postgresql.services;

import com.example.postgresql.models.Disease;
import com.example.postgresql.repo.DiseaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiseaseService {
    private DiseaseRepository diseaseRepository;

    public DiseaseService(DiseaseRepository diseaseRepository) {
        this.diseaseRepository = diseaseRepository;
    }

    public List<Disease> findAllDiseases(){
        return diseaseRepository.findAll();
    }

    public List<Disease> findByKeyword(String keyword) {
        return diseaseRepository.findByKeyword(keyword);
    }
}
