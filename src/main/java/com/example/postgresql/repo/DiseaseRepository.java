package com.example.postgresql.repo;

import com.example.postgresql.models.Disease;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiseaseRepository {

    List<Disease> findAll();

    @Query(value="select * from disease d, diseaseType dt, discover dc " +
            "where d.disease_code like %:keyword% " +
            "or d.pathogen like %:keyword% " +
            "or d.description like %:keyword% " +
            "or dt.description like %:keyword% " +
            "or dc.country like %:keyword%", nativeQuery = true)
    List<Disease> findByKeyword(@Param("keyword") String keyword);
}
