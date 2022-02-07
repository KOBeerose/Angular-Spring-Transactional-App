package com.example.gestionService.Dao;

import com.example.gestionService.Entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranactionRepository extends JpaRepository<Transaction,Long> {
}
