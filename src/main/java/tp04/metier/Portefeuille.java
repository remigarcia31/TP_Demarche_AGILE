/*
 * Copyright 2024
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tp04.metier;

import java.util.ArrayList;

/**
 * <p>
 * Descriptions de la classe portefeuille<p>
 * <p>
 * La classe Portefeuille contient des informations sur les actions détenues,
 * les transactions effectuées. et les ordres en attente pour un investisseur
 * donné.</p>
 *
 * @author M2 IDA 2024
 */
public final class Portefeuille {

    /**
     * Nom du propriétaire du portefeuille.
     */
    private String nomProprietaire = new String();

    /**
     * Solde actuel du portefeuille.
     */
    private double solde = 0.0;

    /**
     * Liste des actions détenues dans le portefeuille.
     */
    private ArrayList<Action> listeAction = new ArrayList<>();

    /**
     * Constructeur avec l'initialisation du nom du Propriétaire et du solde du
     * portefeuille.
     *
     * @param designationProprietaire Nom du propriétaire.
     * @param montant Solde initial du portefeuille.
     */
    public Portefeuille(final double montant,
            final String designationProprietaire) {
        this.nomProprietaire = designationProprietaire;
        this.solde = montant;
    }

    /**
     * Définit le nom du propriétaire du portefeuille.
     *
     * @param designationProprietaire Nom du propriétaire du portefeuille.
     */
    public void definirNomProprietaire(final String designationProprietaire) {
        this.nomProprietaire = designationProprietaire;
    }

    /**
     * Définit le solde du portefeuille.
     *
     * @param montant Solde du portefeuille.
     */
    public void definirSolde(final double montant) {
        this.solde = montant;
    }

    /**
     * Ajoute une action à la liste des actions détenues dans le portefeuille.
     *
     * @param action Action à ajouter.
     */
    public void ajouterAction(final Action action) {
        this.listeAction.add(action);
    }

    /**
     * Obtient le nom du propriétaire du portefeuille.
     *
     * @return Nom du propriétaire du portefeuille.
     */
    public String obtenirNomProprietaire() {
        return nomProprietaire;
    }

    /**
     * Obtient le solde du portefeuille.
     *
     * @return Solde actuel du portefeuille.
     */
    public double obtenirSolde() {
        return this.solde;
    }

    /**
     * Obtient la liste des actions détenues dans le portefeuille.
     *
     * @return Liste des actions détenues.
     */
    public ArrayList<Action> obtenirListeAction() {
        return this.listeAction;
    }

    /**
     * Permet d'enlever une action au portefeuille.
     *
     * @param action action que nous voulons supprimer au portefeuille.
     */
    public void enleverAction(final Action action) {
        this.listeAction.remove(action);
    }

    /**
     * Permet d'enlever une quantité d'acion du portefeuille.
     *
     * @param action action à enlever du portefeuille.
     * @param quantite quantité de l'action que nous souhaitons enlever.
     */
/*    public void enleverQuantiteAction(final Action action, final int quantite) {
        for (Action actionPortefeuille : this.listeAction) {
            if (actionPortefeuille.equals(action)) {
                actionPortefeuille.enleverQuantite(quantite);
                if (actionPortefeuille.quantite < 1) {
                    actionPortefeuille.enleverAction(action);
                }
            }
        }
    }*/

    /**
     * Affiche les détails du portefeuille : le nom du Proprietaire, le solde, 
     * la liste des actions détenues.
     * et la liste des ordres en attente.
     */
    @Override
    public String toString() {
        return "Portefeuille{" + "nomProprietaire=" + nomProprietaire + 
                ", solde=" + solde + ", listeAction=" + listeAction + '}';
    }
}