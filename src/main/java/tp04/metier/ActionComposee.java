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
    // attribut lien
    Map<ActionSimple, Float> mapPanier;

    public ActionComposee(String libelle) {
        super(libelle);
        this.mapPanier = new HashMap();
    }
    
    public ActionComposee(String libelle, String entreprise, String domaine) {
        // Action simple initialisée comme 1 action
        super(libelle, entreprise, domaine);
    }
    
    public void enrgComposition(ActionSimple as, float pourcentage) {
        this.mapPanier.put(as, pourcentage);
    }
    
    @Override
    public float getValeur() {
        long value = 0;
        this.mapPanier.forEach((ac, pr) -> value += Marche.getInstance().getActions().get(ac) * pr);
        return value;
    }
    
    @Override
    public void addValeur() {};
}
