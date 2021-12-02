package com.example.postgresql.repo;

import com.example.postgresql.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, String> {
    @Query(value="select * from users u where u.name like %:keyword% or u.surname like %:keyword% " +
            "or u.email like %:keyword% or u.phone like %:keyword%", nativeQuery = true)
    public List<User> findByKeyword(@Param("keyword") String keyword);

    @Query(value="select * from users u", nativeQuery = true)
    public List<User> getAllUsers();

}
