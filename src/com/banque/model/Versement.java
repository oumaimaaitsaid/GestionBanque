package com.banque.model;

import java.util.UUID;
import java.time.LocalDateTime;
public class Versement extends Operation {
	
	private String source;
	
	Versement (UUID numero,LocalDateTime date,double montant, String source){
		super(numero,date,montant);
		this.source=source;
	}
	
	  @Override
	    public void Afficher() {
	        System.out.println("Versement [" + getMontant() + " de " + source + " le " + getDate() + "]");
	    }
	
	//getters & setters
	
	public String getSource() {return source;}
	public void setSource(String source) {this.source=source;}

}
