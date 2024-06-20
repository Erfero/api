package com.java.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.java.api.model.Agency;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Long> {
}
