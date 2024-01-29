/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp04.metier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author perussel
 */
public class Portefeuille {
    
    private String id = new String();
    private double solde = 0.0;
    private ArrayList<Action> listeAction = new ArrayList<Action>();
    private ArrayList<Transaction> listeTransaction = new ArrayList<Transaction>();
    private ArrayList<Ordre> listeOrdre = new ArrayList<Ordre>();
    
    /*
     * Constructeur
     */

    public Portefeuille() {
    }

    public Portefeuille(String id, double solde) {
        this.id = id;
        this.solde = solde;
    }

    /*
    * Setters
    */

    public void definirId(String id) {
        this.id = id;
    }

    public void definirSolde(double solde) {
        this.solde = solde;
    } 

    public void ajouterAction(Action action) {
        this.listeAction.add(action);
    }

    public void ajouterTransaction(Transaction transaction) {
        this.listeTransaction.add(transaction);
    }

    public void ajouterOrdre(Ordre ordre) {
        this.listeOrdre.add(ordre);
    }

    /*
     * Getters
     */

    public String obtenirId() {
        return this.id;
    }

    public double obtenirSolde() {
        return this.solde;
    }

    public ArrayList<Action> obtenirListeAction() {
        return this.listeAction;
    }

    public ArrayList<Transaction> obtenirListeTransaction() {
        return this.listeTransaction;
    }

    public ArrayList<Ordre> obtenirListeOrdre() {
        return this.listeOrdre;
    }

    /*
     * Méthodes
     */

    public void afficherPortefeuille() {
        System.out.println("Portefeuille : " + this.id);
        System.out.println("Solde : " + this.solde);
        System.out.println("Liste des actions : ");
        for (Action action : this.listeAction) {
            action.afficherAction();
        }
        System.out.println("Liste des transactions : ");
        for (Transaction transaction : this.listeTransaction) {
            transaction.afficherTransaction();
        }
        System.out.println("Liste des ordres : ");
        for (Ordre ordre : this.listeOrdre) {
            ordre.afficherOrdre();
    }
}
