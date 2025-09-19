package com.banque.UI;

import java.util.List;
import java.util.Scanner;

import com.banque.exception.CompteException;
import com.banque.model.Operation;
import com.banque.repository.CompteRepository;
import com.banque.service.CompteService;

public class ConsoleMain {

    public static void main(String[] args) {
        CompteRepository repo = new CompteRepository();
        CompteService service = new CompteService(repo);

      
  

    private static void afficherMenu() {
        System.out.println("\n==== MENU BANQUE ====");
        System.out.println("1 - Créer Compte Courant");
        System.out.println("2 - Créer Compte Epargne");
        System.out.println("3 - Versement");
        System.out.println("4 - Retrait");
        System.out.println("5 - Virement");
        System.out.println("6 - Consulter solde");
        System.out.println("7 - Liste opérations");
        System.out.println("0 - Quitter");
        System.out.print("Votre choix: ");
    }
}
