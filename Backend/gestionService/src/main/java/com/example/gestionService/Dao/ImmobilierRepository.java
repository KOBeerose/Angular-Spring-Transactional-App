package com.example.gestionService.Dao;

import com.example.gestionService.Entities.Immobilier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImmobilierRepository extends JpaRepository<Immobilier,Long> {
}
