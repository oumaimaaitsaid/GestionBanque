package com.banque.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class CompteEpargne extends Compte {
	
	private double tauxInteret;
	
	CompteEpargne (String code,double solde,double tauxInteret){
		super(code,solde);
		this.tauxInteret=tauxInteret;
	}
	//method_afficherDetails
	@Override
	public void afficherDetails() {
		System.out.print("CompteEpargne code=[" + getCode()
		+", solde=" + getSolde()
		+",tauxInteret=" + tauxInteret + "]");
	}
	 
	//methode_retirer
	@Override
	public void retirer(double montant) {
		if(montant <= 0) throw new IllegalArgumentException("le montant doit etre > 0");
			setSolde(getSolde()-montant);
			ajouterOperation(new Retrait(UUID.randomUUID(), LocalDateTime.now(), montant,"Virment sortant"));
	}
	
	
	
	
	
	

}
