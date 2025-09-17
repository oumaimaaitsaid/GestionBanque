package com.banque.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public abstract class Compte {

    private String code;
    private double solde;
    private List<Operation> listOperations =new ArrayList<>();
    public Compte(String code, double soldeInitial) {
        
        this.code = generateCode();
        this.solde = soldeInitial;
    }
    
    //generateCode.Automaticly
    public String generateCode() {
    	long value =Math.abs(UUID.randomUUID().getMostSignificantBits());
    	long fiveDigits =value % 100000;
    	return String.format("CPT-%05d",fiveDigits);
    }
    //methods abstract
    public abstract void retirer(double montant);
    public abstract void afficherDetails();
    public abstract double calculerInteret();

  

    

   
  
   


}
