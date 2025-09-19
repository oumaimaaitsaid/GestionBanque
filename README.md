# 💰 GestionBanques

Application Java de gestion de comptes bancaires (épargne, courant) avec interface console.

## 🛠️ Fonctionnalités

- ✅ Création de comptes bancaires (épargne, courant)
- 💸 Dépôt, retrait, versement et transfert
- 🧾 Suivi des opérations bancaires
- 🧠 Gestion des exceptions personnalisées (`CompteException`)
- 🧪 Tests unitaires personalisés

## 🚀 Technologies utilisées

- Java
- Eclipse IDE
- Tests unitaires personnalisés (implémentation via la classe abstraite `TestBase`)
- Export en `.jar`

## ▶️ Lancement de l'application

### Via le terminal

1. Ouvrir un terminal
2. Aller dans le dossier contenant le fichier `Banque.jar`
3. Lancer la commande :

```bash
java -jar Banque.jar
```
⚠️ Assurez-vous que Java est installé (java -version).

----
## 📁 Structure du projet

src/
├── com.banque.exception
│   └── CompteException.java
├── com.banque.model
│   ├── Compte.java
│   ├── CompteCourant.java
│   ├── CompteEpargne.java
│   ├── Operation.java
│   ├── Retrait.java
│   └── Versement.java
├── com.banque.repository
│   └── CompteRepository.java
├── com.banque.service
│   └── CompteService.java
├── com.banque.UI
│   └── ConsoleMain.java
└── test
    ├── CompteServiceTest.java
    └── TestBase.java




## Diagramme De Classe 
![Diagramme de Classe](images/diagrammeDeClasse.png)


👩‍💻 Auteur

[Oumaima Ait Said]
