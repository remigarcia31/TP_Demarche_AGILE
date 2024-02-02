/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp04.metier;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * La classe Portefeuille représente un portefeuille d'investissement qui contient des actions.
 * Elle permet de gérer les ordres d'achat et de vente, ainsi que de mettre à jour le solde et la valeur du portefeuille.
 * 
 * @author gaboche
 */
public class Portefeuille {
    
    /**
     * Liste des actions contenues par le portefeuille (action, quantité).
     */
    Map<Action, Integer> actions; // liste des actions contenues par le portefeuille (action , quantité)
    
    /**
     * Valeur liquide du portefeuille.
     */
    double solde; // Valeur liquide du portefeuille
    
    /**
     * Valeur totale du portefeuille.
     */
    double valeur; // Valeur totale du portefeuille
    
    /**
     * Constructeur par défaut de la classe Portefeuille.
     */
    public Portefeuille(double solde) {
        this.solde = solde;
    }
    
    /**
     * Obtient la liste des actions contenues par le portefeuille.
     * 
     * @return La liste des actions avec leur quantité.
     */
    public Map<Action, Integer> getActions() {
        return actions;
    }

    /**
     * Définit la liste des actions contenues par le portefeuille.
     * 
     * @param actions La nouvelle liste des actions avec leur quantité.
     */
    public void setActions(Map<Action, Integer> actions) {
        this.actions = actions;
    }

    /**
     * Obtient la valeur liquide du portefeuille.
     * 
     * @return La valeur liquide du portefeuille.
     */
    public double getSolde() {
        return solde;
    }

    /**
     * Définit la valeur liquide du portefeuille.
     * 
     * @param solde La nouvelle valeur liquide du portefeuille.
     */
    public void setSolde(double solde) {
        this.solde = solde;
    }

    /**
     * Obtient la valeur totale du portefeuille.
     * 
     * @return La valeur totale du portefeuille.
     */
    public double getValeur() {
        return valeur;
    }

    /**
     * Définit la valeur totale du portefeuille.
     * 
     * @param valeur La nouvelle valeur totale du portefeuille.
     */
    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    /**
     * Crée un ordre limite d'achat ou de vente sur le marché.
     * 
     * @param estAchat      Indique s'il s'agit d'un ordre d'achat (true) ou de vente (false).
     * @param action        L'action concernée par l'ordre.
     * @param prixUnit      Le prix unitaire de l'action.
     * @param quantite      La quantité d'actions à acheter ou vendre.
     * @param dateCloture   La date de clôture de l'ordre.
     * @param portefeuille  Le portefeuille associé à l'ordre.
     */
    public void createOrderLimite(
        boolean estAchat,
        Action action,
        double prixUnit,
        int quantite, 
        int dateCloture,
        Portefeuille portefeuille)
    {
        boolean validite = true;
        double total = prixUnit * quantite;
        
        if (estAchat) validite = testSolde(total);
        if (!estAchat) validite = testQuantiteAction(quantite, action);
        
        if (validite) {
            System.out.println("ordre ajouté au marché");
            this.solde -= total ;
            Marche.getInstance().addOrder(new Ordre(estAchat, action, prixUnit, quantite, dateCloture, this));// Créé un ordre en vérifiant que le solde est suffisant et que le nombre d'actions            
        }
    }

    /**
     * Crée un ordre au marché d'achat ou de vente sur le marché.
     * 
     * @param estAchat      Indique s'il s'agit d'un ordre d'achat (true) ou de vente (false).
     * @param action        L'action concernée par l'ordre.
     * @param quantite      La quantité d'actions à acheter ou vendre.
     * @param dateCloture   La date de clôture de l'ordre.
     * @param portefeuille  Le portefeuille associé à l'ordre.
     */    
    public void createOrderMarche(
        boolean estAchat,
        Action action,
        int quantite, 
        int dateCloture,
        Portefeuille portefeuille)
    {
        boolean validite = true;
        double total = action.derniere_valeur() * quantite;
        
        if (estAchat) validite = testSolde(total);
        if (!estAchat) validite = testQuantiteAction(quantite, action);
        
        if (validite) {
            System.out.println("ordre ajouté au marché");
            this.solde -= total ;
            Marche.getInstance().addOrder(new Ordre(
                    estAchat,
                    action,
                    action.derniere_valeur(),
                    quantite,
                    dateCloture,
                    this));// Créé un ordre en vérifiant que le solde est suffisant et que le nombre d'actions            
        }
    }
    
    /**
     * Vérifie si le solde est suffisant pour effectuer une opération financière.
     * 
     * @param valeur La valeur à comparer avec le solde du portefeuille.
     * @return true si le solde est suffisant, false sinon.
     */
    public boolean testSolde(double valeur) {
        if (valeur > solde) {
            System.out.println("Prix total supérieur au solde disponible");
            return false;
        }
        return true;
    }

    /**
     * Vérifie si la quantité d'une action à vendre est inférieure ou égale à la quantité possédée dans le portefeuille.
     * 
     * @param quantite La quantité à vendre.
     * @param a L'action concernée par la vente.
     * @return true si la quantité est valide, false sinon.
     */
    public boolean testQuantiteAction(int quantite, Action a) {
        if (quantite > this.actions.get(a)) {
            System.out.println("Quantité à vendre supérieure à la quantité possédée");
            return false;
        }
        return true;
    }

    
    /**
     * Met à jour le solde du portefeuille.
     * 
     * @param valeur La valeur à ajouter au solde.
     */
    public void updateSolde(double valeur)
    {
        this.solde += valeur;
    }
    
    /**
     * Met à jour la quantité d'une action dans le portefeuille.
     * 
     * @param action    L'action à mettre à jour.
     * @param quantite  La quantité à ajouter (peut être négative pour une vente).
     */
    public void updateQteAction(Action action, int quantite)
    {
        int qte = this.actions.get(action); // quantité
        this.actions.put(action, qte + quantite);
    }
    
    /**
     * Met à jour la liste des actions en supprimant celles dont la quantité est égale à zéro.
     */
    public void updateActions() {
        for (Action a: this.actions.keySet()){
            if (this.actions.get(a) == 0) {
                this.actions.remove(a);
            }
        }
    }
    
    /**
     * Génère une représentation textuelle du portefeuille.
     * 
     * @return Une chaîne de caractères représentant le portefeuille.
     */
    @Override
    public String toString()
    {
        return "";
    }
    
    /**
     * Met à jour le portefeuille en recalculant sa valeur totale en fonction des actions détenues.
     */
    public void update()
    {
        this.updateActions();
        
        int temp = 0;
        
        for (Action a: this.actions.keySet()){
            temp += this.actions.get(a) * a.derniere_valeur();
        }
        
        this.valeur = temp;
    }
}