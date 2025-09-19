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

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            afficherMenu();
            String choix = sc.nextLine();
            try {
                switch (choix) {
                    case "1":
                        
                        System.out.print("Solde initial: ");
                        double soldeC = Double.parseDouble(sc.nextLine());
                        System.out.print("Découvert autorisé: ");
                        double dec = Double.parseDouble(sc.nextLine());
                        String newCodeC=service.createCompteCourant(soldeC, dec);
                        System.out.println("Compte courant créé votre code est ! " + newCodeC);
                        break;
                    case "2":
                       
                        System.out.print("Solde initial: ");
                        double soldeE = Double.parseDouble(sc.nextLine());
                        System.out.print("Taux intérêt (ex 0.02): ");
                        double taux = Double.parseDouble(sc.nextLine());
                        String newCodeE= service.createCompteEpargne(soldeE, taux);
                        System.out.println("Compte épargne créé ! " + newCodeE);
                        break;
                    case "3":
                        System.out.print("Code compte: ");
                        String cv = sc.nextLine();
                        System.out.print("Montant: ");
                        double mv = Double.parseDouble(sc.nextLine());
                        System.out.print("Source: ");
                        String src = sc.nextLine();
                        service.verser(cv, mv, src);
                        System.out.println("Versement effectué");
                        break;
                    case "4":
                        System.out.print("Code compte: ");
                        String cr = sc.nextLine();
                        System.out.print("Montant: ");
                        double mr = Double.parseDouble(sc.nextLine());
                        service.retirer(cr, mr);
                        System.out.println("Retrait effectué");
                        break;
                    case "5":
                        System.out.print("Compte source: ");
                        String from = sc.nextLine();
                        System.out.print("Compte destinataire: ");
                        String to = sc.nextLine();
                        System.out.print("Montant: ");
                        double mvmt = Double.parseDouble(sc.nextLine());
                        service.virement(from, to, mvmt);
                        System.out.println("Virement réussi");
                        break;
                    case "6":
                        System.out.print("Code compte: ");
                        String cs = sc.nextLine();
                        System.out.println("Solde = " + service.consulterSolde(cs));
                        break;
                    case "7":
                        System.out.print("Code compte: ");
                        String cop = sc.nextLine();
                        List<Operation> ops = service.consulterOperations(cop);
                        if (ops.isEmpty()) {
                            System.out.println("Aucune opération");
                            
                        } 
                        else {
                        	System.out.println("voilà vos operatiosn de compte :" +cop);
                        	ops.forEach(System.out::println);
                        }
                        
                        break;
                    case "0":
                        running = false;
                        break;
                    default:
                        System.out.println("Choix invalide");
                }
            } catch (CompteException | NumberFormatException e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        }
        sc.close();
        System.out.println("Au revoir !");
    }

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
