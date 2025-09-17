package com.banque.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class CompteCourant extends Compte{
	
	private double decouvert;
	
	CompteCourant (String code,double solde,double decouvert){
		super(code,solde);
		this.decouvert=decouvert;
	}
	
	
	

	
	
	
	

}
