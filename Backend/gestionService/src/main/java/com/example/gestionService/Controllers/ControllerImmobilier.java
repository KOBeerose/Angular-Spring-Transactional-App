package com.example.gestionService.Controllers;


import com.example.gestionService.Dao.ImmobilierRepository;
import com.example.gestionService.Entities.Immobilier;
import com.example.gestionService.Entities.Transaction;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/immobilier")
public class ControllerImmobilier {

    @Autowired
    ImmobilierRepository immobilierRepository;

        @GetMapping("/listImmobilier/{address}")
        public List<Immobilier> listImmobilier(@PathVariable("address") String address){
            List<Immobilier> listImm=new ArrayList<Immobilier>();
            List<Immobilier> listImmobilier= (List<Immobilier>) immobilierRepository.findAll();
            for(int i=0;i<listImmobilier.size();i++){
                if(listImmobilier.get(i).getAddressOwner().equals(address)){
                    listImm.add(listImmobilier.get(i));
                }
            }
            return listImm;
        }
        @GetMapping("/listVisibleImmobilier")
        public List<Immobilier> listVisibleImmobilier(){
            List<Immobilier> listImm=new ArrayList<Immobilier>();
            List<Immobilier> listImmobilier= (List<Immobilier>) immobilierRepository.findAll();
            for(int i=0;i<listImmobilier.size();i++){
                if(listImmobilier.get(i).isAnnounced()==true){
                    listImm.add(listImmobilier.get(i));
                }
            }
            return listImm;
        }

    @GetMapping("/immobilierDetails/{id}")
    public Optional<Immobilier> ImmobilierDetails(@PathVariable("id") Long id){
        return this.immobilierRepository.findById(id);
    }


    @GetMapping("/transactions/{id}")
    public Collection<Transaction> getTransactionsOfImmobilier(@PathVariable("id") Long id){
        Immobilier immobilier=new Immobilier();
        List<Immobilier> listImmobilier= (List<Immobilier>) immobilierRepository.findAll();
        for(int i=0;i<listImmobilier.size();i++){
            if(listImmobilier.get(i).getId()==id){
                immobilier=listImmobilier.get(i);
                break;
            }
        }
        return immobilier.getTransactions();
    }

    @GetMapping("/allImmobilier")
    public List<Immobilier> allImmobilier(){
        return (List<Immobilier>) immobilierRepository.findAll();
    }
    @PostMapping("/saveImmobilier")
    public Immobilier saveImmobilier(@RequestBody Immobilier immobilier){
        // immobilier.setAnnounced(true);
        immobilierRepository.save(immobilier);
        return immobilier;
    }
    @GetMapping("/changeAnnouncement/{id}")
    public void changeAnnouncement(@PathVariable("id") Long id){
        List<Immobilier> immobilierList=(List<Immobilier>) immobilierRepository.findAll();
        for(int i=0;i<immobilierList.size();i++){
            if(immobilierList.get(i).getId()==id){
                if(immobilierList.get(i).isAnnounced()==false) immobilierList.get(i).setAnnounced(true);
                if(immobilierList.get(i).isAnnounced()==true) immobilierList.get(i).setAnnounced(false);
                immobilierRepository.save(immobilierList.get(i));
            }
        }
    }
    @PutMapping("/changeOwner/{id}")
    public void changeOwner(@PathVariable("id") Long id,@RequestBody String newOwner){
        List<Immobilier> immobilierList=(List<Immobilier>) immobilierRepository.findAll();
        for(int i=0;i<immobilierList.size();i++){
            if(immobilierList.get(i).getId()==id){
                immobilierList.get(i).setAddressOwner(newOwner);
                immobilierList.get(i).setAnnounced(false);
                immobilierRepository.save(immobilierList.get(i));
            }
        }
    }


    @PutMapping("/setPrice/{id}")
    public Immobilier setPriceImmobilier(@PathVariable("id") Long id,@RequestBody Immobilier immobilier){
        List<Immobilier> immobilierList=(List<Immobilier>) immobilierRepository.findAll();
        for(int i=0;i<immobilierList.size();i++){
            if(immobilierList.get(i).getId()==id){
                immobilierList.get(i).setPrice(immobilier.getPrice());
                return immobilierRepository.save(immobilierList.get(i));
            }
        }
        return null;
    }

    @PutMapping("/modifyImombilier/{id}")
    public Immobilier modifyImmobilier(@PathVariable("id") Long id,@RequestBody Immobilier immobilier) throws IntrospectionException, InvocationTargetException, IllegalAccessException {

        Optional<Immobilier> currentimmobilier = immobilierRepository.findById(id);

        if (currentimmobilier.isPresent()){
            for (PropertyDescriptor pd : Introspector.getBeanInfo(Immobilier.class).getPropertyDescriptors()) {
                if (pd.getReadMethod() != null && !"class".equals(pd.getName())){
                    Method getterMethod = pd.getReadMethod();
                    Method setterMethod = pd.getWriteMethod();
                    if(getterMethod.invoke(immobilier) != null){
                        setterMethod.invoke(currentimmobilier.get(),getterMethod.invoke(immobilier));
                    }
                };
            }

            immobilierRepository.save(currentimmobilier.get());
            return currentimmobilier.get();
        }else{
            return null;
        }


    }

    @DeleteMapping("/deleteImombilier/{id}")
    public void deleteImmobilier(@PathVariable("id") Long id){
        List<Immobilier> immobilierList=(List<Immobilier>) immobilierRepository.findAll();
        for(int i=0;i<immobilierList.size();i++){
            if(immobilierList.get(i).getId()==id){
                immobilierRepository.delete(immobilierList.get(i));
            }
        }
    }
}
