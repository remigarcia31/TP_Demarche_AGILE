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
    
    // constructeur
    public ActionSimple(String libelle) {
        // Action simple initialisée comme 1 action
        super(libelle);
    }
        // constructeur
    public ActionSimple(String libelle, String entreprise, String domaine) {
        // Action simple initialisée comme 1 action
        super(libelle, entreprise, domaine);
    }
    
    @Override
    public float getValeur() {
        return Marche.getInstance().getActions().get(this);
    }
    
    
}
