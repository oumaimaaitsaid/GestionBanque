package com.banque.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class CompteEpargne extends Compte {
	
	private double tauxInteret;
	
	CompteEpargne (String code,double solde,double tauxInteret){
		super(code,solde);
		this.tauxInteret=tauxInteret;
	}

	
	
	
	
	
	

}
