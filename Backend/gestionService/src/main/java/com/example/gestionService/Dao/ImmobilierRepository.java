package com.example.gestionService.Dao;

import com.example.gestionService.Entities.Immobilier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImmobilierRepository extends CrudRepository<Immobilier,Long> {
}
