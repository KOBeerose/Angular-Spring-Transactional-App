package com.example.gestionService.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@Table(schema = "transaction")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String addressrecipent;
    private String addressOwner;
    private double priceTran;
    @ManyToOne
    @JoinColumn(name = "immobilier_id")
    private Immobilier immobilier;
}
