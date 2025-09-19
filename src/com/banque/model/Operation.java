package com.banque.model;

import java.util.UUID;
import java.time.LocalDateTime;

public abstract class Operation {

	private UUID numero;
	private LocalDateTime date;
	private double montant;
	
	Operation(UUID numero ,LocalDateTime date, double montant){
		this.numero =numero;
		this.date=date;
		this.montant=montant;
	}
	
	public abstract void Afficher();
	@Override
	public String toString() {
	    return "[" + this.getClass().getSimpleName() + "] " +
	           "ID: " + getNumero() + ", " +
	           "Date: " + getDate() + ", " +
	           "Montant: " + getMontant() ;}
	
	//getter
	public UUID getNumero() {return numero;}
	public LocalDateTime getDate() {return date;}
	public double getMontant() {return montant;}
	
}
