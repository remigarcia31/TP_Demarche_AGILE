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
public class Portefeuille {

    Map<Action, LignePortefeuille> mapLignes;

    private class LignePortefeuille {

        private Action action;

        private int qte;

        public int getQte() {
            return qte;
        }

        public void setQte(int qte) {
            this.qte = qte;
        }

        public Action getAction() {
            return this.action;
        }

        public LignePortefeuille(Action action, int qte) {
            this.action = action;
            this.qte = qte;
        }

        public String toString() {
            return Integer.toString(qte);
        }
    }

    public Portefeuille() {
        this.mapLignes = new HashMap();
    }

    /**
     * Fonction permettant l'achat d'une ou plusieurs même action.
     *
     * @param a action que l'on souhaite acheter.
     * @param q quantité de l'action souhaiter.
     */
    public final void acheter(final Action a, final int q) {
        if (q < 1) {
            throw new IllegalArgumentException("La quantité est "
                    + "inférieur à 1.");
        } else {
            LignePortefeuille lignePortefeuille = this.mapLignes.get(a);
            if (lignePortefeuille == null) {
                this.mapLignes.put(a, new LignePortefeuille(a, q));
            } else {
                lignePortefeuille.setQte(lignePortefeuille.getQte() + q);
            }
        }
    }
    
    public void vendre(Action a, int q) {
        if (this.mapLignes.containsKey(a) == true) {
            if (this.mapLignes.get(a).getQte() > q) {
                this.mapLignes.get(a).setQte(this.mapLignes.get(a).getQte() - q);
            } else if (this.mapLignes.get(a).getQte() == q) {
                this.mapLignes.remove(a);
            }
        }
    }

    public String toString() {
        return this.mapLignes.toString();
    }

    public float valeur(Jour j) {
        float total = 0;
        for (LignePortefeuille lp : this.mapLignes.values()) {
            total = total + (lp.getQte() * lp.getAction().valeur(j));
        }
        return total;
    }
}
