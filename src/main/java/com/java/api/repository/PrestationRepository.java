package com.java.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.java.api.model.Prestation;

@Repository
public interface PrestationRepository extends JpaRepository<Prestation, Long> {
}
