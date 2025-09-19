package com.banque.service;

import java.util.List;
import com.banque.exception.CompteException;
import com.banque.model.*;
import com.banque.repository.CompteRepository;

public class CompteService {

    private final CompteRepository repo;

    public CompteService(CompteRepository repo) {
        this.repo = repo;
    }

  

    public String createCompteCourant(double solde, double decouvert) {
    	
        CompteCourant c = new CompteCourant( solde, decouvert);
        repo.save(c);
        return c.getCode();
    }

    public String createCompteEpargne(double solde, double taux) {
        CompteEpargne c = new CompteEpargne( solde, taux);
        repo.save(c);
        return c.getCode();
    }
   
    public void verser(String code, double montant, String source) throws CompteException {
        Compte c = getCompte(code);
        c.verser(montant, source);
    }

    public void retirer(String code, double montant) throws CompteException {
        Compte c = getCompte(code);
        c.retirer(montant);
    }

    public void virement(String from, String to, double montant) throws CompteException {
        Compte src = getCompte(from);
        Compte dest = getCompte(to);
        src.retirer(montant);
        dest.verser(montant, "Virement interne depuis " + from);
    }

  
  
  
}
