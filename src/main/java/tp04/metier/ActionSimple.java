/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp04.metier;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author perussel
 */
public class ActionSimple extends Action {

    
    private int Id;
    
    private String Entreprise;
    
    private String Domaine;
    // attribut lien

    /**
     *
     */
    public Map<Jour, Cours> mapCours;
    // constructeur

    public ActionSimple(String libelle) {
        super(libelle);
    }
    
    public ActionSimple(int Id, String Entreprise, String Domaine
            , String libelle) {
        // Action simple initialisée comme 1 action
        super(libelle);
        this.Id = Id;
        this.Entreprise = Entreprise;
        this.Domaine = Domaine;
        // init spécifique
        this.mapCours = new HashMap();
    }

    /**
     *
     * @param j
     * @param v
     * enrg possible si pas de cours pour ce jour
     */
    public void enrgCours(Jour j, float v) {
        if(this.mapCours.containsKey(j) == false) {
            this.mapCours.put(j, new Cours(j, v));
        } else {
        }
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getEntreprise() {
        return Entreprise;
    }

    public void setEntreprise(String Entreprise) {
        this.Entreprise = Entreprise;
    }

    public String getDomaine() {
        return Domaine;
    }

    public void setDomaine(String Domaine) {
        this.Domaine = Domaine;
    }

    public Map<Jour, Cours> getMapCours() {
        return mapCours;
    }

    public void setMapCours(Map<Jour, Cours> mapCours) {
        this.mapCours = mapCours;
    }

    /**
     *
     * @param j
     * pour un jour donnee retourne la valeur 
     * @return valeur 
     */
    public float valeur(Jour j) {
        if(this.mapCours.containsKey(j) == true)
            return this.mapCours.get(j).getValeur();
        else 
            return 0; // definition d'une constante possible
    }
  
    // encapsulation de la définition de la classe Cours
    private class Cours {
    /**
     *
     * @param jour
     * la propriete du jour
     */
        private final Jour jour;

     /**
     *
     * @param valeur
     * la valeur du cours
     */
        private final float valeur;

        /**
     *
     * 
     * @return valeur
     * Constructeur d'une action composee
     */
        public float getValeur() {
            return valeur;
        }

     /**
     *
     * @return Jour
     * Constructeur d'une action composee
     */
        public Jour getJour() {
            return jour;
        }

        /**
     *
     * @param jour
     * @param valeur
     * Constructeur d'un cours
     */
        public Cours(Jour jour, float valeur) {
            this.jour = jour;
            this.valeur = valeur;
        }
    }
}
