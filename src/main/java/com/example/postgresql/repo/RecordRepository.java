package com.example.postgresql.repo;

import com.example.postgresql.models.RecordId;
import com.example.postgresql.models.Records;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends CrudRepository <Records, RecordId> {

    @Query(value = "select * from record r where r.email like %:keyword% ", nativeQuery = true)
    public List<Records> findByKeyword(@Param("keyword") String keyword);

    @Query(value="select * from record r", nativeQuery = true)
    public List<Records> getAllRecords();

    @Query(value="select * from record r where r.email=:email and country=:country " +
            "and diseaseCode=:diseaseCode", nativeQuery = true)
    public Records findByEmailCAndCountryAndDiseaseCode(@Param("email") String email,
                                                        @Param("country") String country,
                                                        @Param("diseaseCode") String diseaseCode);

}