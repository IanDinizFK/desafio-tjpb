package com.example.springboot.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.models.SolicitationModel;

@Repository
public interface SolicitationRepository extends JpaRepository<SolicitationModel, Long> {
    Optional<SolicitationModel> findById(Long id);
}
