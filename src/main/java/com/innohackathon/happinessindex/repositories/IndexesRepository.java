package com.innohackathon.happinessindex.repositories;

import com.innohackathon.happinessindex.models.DataPackage;
import com.innohackathon.happinessindex.models.IndexPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IndexesRepository extends JpaRepository<IndexPackage, Long> {
    @Query(nativeQuery =true, value = "SELECT * FROM indexes WHERE id = (:id)")
    List<IndexPackage> find(@Param("id") Long id);
}

