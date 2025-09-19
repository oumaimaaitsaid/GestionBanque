package com.banque.repository;
import java.util.*;
import com.banque.model.Compte;
public class CompteRepository {
	
	private Map<String, Compte> comptes =new HashMap<>();
	
	public void save(Compte compte) {
		comptes.put(compte.getCode(), compte);
	}
	
	public Optional<Compte> findByCode(String code){
		return Optional.ofNullable(comptes.get(code));
	}
	
	public void delete (String code) {
		comptes.remove(code);
	}

}
