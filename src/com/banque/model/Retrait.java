package com.banque.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Retrait extends Operation {
private String distination;
	
	Retrait (UUID numero,LocalDateTime date,double montant, String distination){
		super(numero,date,montant);
		this.distination=distination;
	}
	
	  @Override
	    public void Afficher() {
	        System.out.println("Versement [" + getMontant() + " de " + distination + " le " + getDate() + "]");
	    }
	
	//getters & setters
	
	public String getDistination() {return distination;}
	public void setDistination(String distination) {this.distination=distination;}

}
