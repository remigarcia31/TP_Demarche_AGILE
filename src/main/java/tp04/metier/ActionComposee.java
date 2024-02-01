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
public class ActionComposee extends Action {
/**
     *
     * @param mapPanier
     * La liste d'actions simples et price
     */
    Map<ActionSimple, Float> mapPanier;
    /**
     *
     * @param libelle
     * Constructeur d'une action composee
     */
    public ActionComposee(String libelle) {
        super(libelle);
        this.mapPanier = new HashMap();
    }

    /**
     *
     * @param as
     * @param pourcentage
     * cette methode permet d'enregistrer dans la liste
     * une nouvelle action simple
     */
    public void enrgComposition(ActionSimple as, float pourcentage) {
        this.mapPanier.put(as, pourcentage);
    }
    /**
     *
     * @return
     */
    public Map<ActionSimple, Float> getMapPanier() {
        return mapPanier;
    }

    /**
     *
     * @param mapPanier
     */
    public void setMapPanier(Map<ActionSimple, Float> mapPanier) {
        this.mapPanier = mapPanier;
    }
    /**
     *
     * @param j
     * @return valeur action composee
     */
    public float valeur(Jour j) {
        float valeur;
        valeur = 0;
        for (ActionSimple as : this.mapPanier.keySet()) {
            valeur = valeur + (as.valeur(j) * this.mapPanier.get(as));
        }
        return valeur;
    }
}