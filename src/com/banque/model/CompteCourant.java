package com.banque.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class CompteCourant extends Compte{
	
	private double decouvert;
	
	CompteCourant (String code,double solde,double decouvert){
		super(code,solde);
		this.decouvert=decouvert;
	}
	
	//methode_afficherDétails
	@Override
	public void afficherDetails() {
        System.out.println("CompteCourant [code=" + getCode()
                + ", solde=" + getSolde()
                + ", decouvert=" + decouvert + "]");
    }
	

	
	
	
	

}
