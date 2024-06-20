package com.java.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.java.api.model.Intervention;


@Repository
public interface InterventionRepository extends JpaRepository<Intervention, Long> {
}
