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

    // attribut lien
    private Map<Jour, Cours> mapCours;
    // constructeur
    public ActionSimple(String libelle) {
        // Action simple initialisée comme 1 action
        super(libelle);
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
     * Constructeur d'une action composee
     */
        public Cours(Jour jour, float valeur) {
            this.jour = jour;
            this.valeur = valeur;
        }
    }
}
