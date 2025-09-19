package com.banque.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class CompteCourant extends Compte{
	
	private double decouvert;
	
	public CompteCourant (double solde,double decouvert){
		super(null,solde);
		this.decouvert=decouvert;
	}
	
	//methode_afficherDétails
	@Override
	public void afficherDetails() {
        System.out.println("CompteCourant [code=" + getCode()
                + ", solde=" + getSolde()
                + ", decouvert=" + decouvert + "]");
    }
	
	//methodeRetirer
	@Override
	public void retirer(double montant) {
		if (montant <=0) throw new IllegalArgumentException("Montant doit étre >0");
		double nouveauSolde =getSolde() - montant;
		if (nouveauSolde < -decouvert)
			throw new IllegalArgumentException("tu dépasse le découvert autorisé ");
		setSolde(nouveauSolde); 
		
		ajouterOperation(new Retrait(UUID.randomUUID(), LocalDateTime.now(), montant,"Distributeur"));
	}
	
	//methodeCalculerInteret
	@Override
	 public double calculerInteret(){return 0.0;}
	
	//getter && setters
	public double getDecouvert() {return decouvert;}
	public void setDecouvert(double decouvert) {this.decouvert=decouvert;}
	

}
