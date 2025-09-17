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

    //method verser
    public void verser(double montant, String source) {
        if (montant <= 0) throw new IllegalArgumentException("Montant doit être > 0");
        solde += montant;
       listOperations.add(new Versement(UUID.randomUUID(),LocalDateTime.now(),montant,source));
    }

    //method ajouterOperation
      public void ajouterOperation(Operation op) {
    	  listOperations.add(op);
      }

     //method consulerSolde
    public double consulterSolde() {
        return solde;
    }
  
    //method consulterListeOperation
   public List<Operation> consulterListeOperations(){
	   return listOperations;
   }

    // Getters & Setters
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public double getSolde() { return solde; }
    public void setSolde(double solde) { this.solde = solde; }
}
