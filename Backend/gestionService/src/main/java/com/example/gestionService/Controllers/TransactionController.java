package com.example.gestionService.Controllers;

import com.example.gestionService.Dao.ImmobilierRepository;
import com.example.gestionService.Dao.TranactionRepository;
import com.example.gestionService.Entities.Immobilier;
import com.example.gestionService.Entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TranactionRepository tranactionRepository;
    @Autowired
    ImmobilierRepository immobilierRepository;

    @GetMapping("/allTransactions")
    public List<Transaction> allTransactions(){
        return tranactionRepository.findAll();
    }
    @PostMapping("/addTransaction/{id}")
    public Transaction addTransaction(@RequestBody Transaction transaction,@PathVariable("id") Long id){
        List<Immobilier> listImmobilier= (List<Immobilier>) immobilierRepository.findAll();
        for(int i=0;i<listImmobilier.size();i++){
            if(listImmobilier.get(i).getId()==id){
                transaction.setImmobilier(listImmobilier.get(i));
            }
        }
        return tranactionRepository.save(transaction);
    }


}
