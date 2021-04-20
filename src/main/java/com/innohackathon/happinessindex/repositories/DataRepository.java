package com.innohackathon.happinessindex.repositories;

import com.innohackathon.happinessindex.models.DataPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DataRepository extends JpaRepository<DataPackage, Long> {
    @Query(nativeQuery =true, value = "SELECT * FROM " +
            "user_info WHERE first_name = (:first_name) AND last_name = (:last_name)")
    List<DataPackage> findAll(@Param("first_name") String first_name,
                                     @Param("last_name") String last_name
    );

    @Query(nativeQuery =true, value = "SELECT * FROM " +
            "user_info WHERE first_name = (:first_name)")
    List<DataPackage> findAll_name(@Param("first_name") String first_name);

    @Query(nativeQuery =true, value = "SELECT * FROM " +
            "user_info WHERE last_name = (:last_name)")
    List<DataPackage> findAll_sur(@Param("last_name") String last_name);

    @Query(nativeQuery =true, value = "SELECT * FROM " +
            "user_info WHERE id = (:id)")
    List<DataPackage> find(@Param("id") Long id);
}

