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

  
   

   

   

  
  
  
}
