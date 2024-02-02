/*
 * Copyright 2024 gaboche.
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

/**
 *
 * @author gaboche
 * 
 * 
 */

/**
 * Représente un ordre qui teste le marché (prix quantité) pour permettre la réalisation d'une transaction.
 */
public class Ordre {

    /**
     * Enumération des statuts possibles d'un ordre.
     */
    enum Statut {
        OUVERT,
        VALIDER,
        REFUSER
    };

    /** Le statut actuel de l'ordre. */
    private Statut statut;

    /** Le prix unitaire de l'ordre. */
    private double prixUnit;
    
    /** Indique s'il s'agit d'un ordre d'achat (true) ou de vente (false). */
    private boolean estAchat;

    /** L'action associée à l'ordre. */
    private Action action;

    /** La quantité de l'ordre. */
    private int quantite;

    /** La date d'ouverture de l'ordre. */
    private String dateOuverture;

    /** La date de clôture de l'ordre. */
    private String dateCloture;

    /** Le portefeuille associé à l'ordre. */
    private Portefeuille portefeuille;

    /** Indique si l'ordre est au marché (true) ou en limite (false). */
    private boolean estAuMarche;

    /**
     * Constructeur de la classe Ordre pour créer un ordre limite une vente
     * génerera un ordre avec prix plancher un achat génerera un aordre avec
     * prix plafond.
     *
     * @param estAchat      true si c'est un ordre d'achat, false si c'est un ordre de vente
     * @param action        l'action associée à l'ordre
     * @param prixUnit      le prix unitaire de l'ordre
     * @param quantite      la quantité de l'ordre
     * @param dateCloture   la date de clôture de l'ordre
     * @param portefeuille  le portefeuille associé à l'ordre
     */
    public Ordre(
            boolean estAchat,
            Action action,
            double prixUnit,
            int quantite, 
            String dateCloture,
            Portefeuille portefeuille
    ) {
        this.statut = Statut.OUVERT;
        this.prixUnit = prixUnit;
        this.estAchat = estAchat;
        this.action = action;
        this.quantite = quantite;
        this.dateCloture = dateCloture; 
        this.portefeuille = portefeuille;
        this.estAuMarche = false;
    }

    /**
     * Constructeur de la classe Ordre pour créer un ordre au prix du marché
     *
     * @param estAchat      true si c'est un ordre d'achat, false si c'est un ordre de vente
     * @param action        l'action associée à l'ordre
     * @param quantite      la quantité de l'ordre
     * @param dateCloture   la date de clôture de l'ordre
     * @param portefeuille  le portefeuille associé à l'ordre
     */
    public Ordre(
            boolean estAchat,
            Action action,
            int quantite, 
            String dateCloture,
            Portefeuille portefeuille
    ) {
        this.statut = Statut.OUVERT;
        this.prixUnit = action.derniere_valeur;
        this.estAchat = estAchat;
        this.action = action;
        this.quantite = quantite;
        this.dateCloture = dateCloture; 
        this.portefeuille = portefeuille;
        this.estAuMarche = true;
    }
    
    /**
     * Obtient le statut de l'ordre.
     *
     * @return le statut de l'ordre
     */
    public Statut getStatut() {
        return this.statut;
    }

    /**
     * Modifie le statut de l'ordre.
     *
     * @param statut le nouveau statut de l'ordre
     */
    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    /**
     * Obtient le prix unitaire de l'ordre.
     *
     * @return le prix unitaire de l'ordre
     */
    public double getPrixUnit() {
        return this.prixUnit;
    }

    /**
     * Modifie le prix unitaire de l'ordre.
     *
     * @param prixUnit le nouveau prix unitaire de l'ordre
     */
    public void setPrixUnit(long prixUnit) {
        this.prixUnit = prixUnit;
    }

    /**
     * Obtient si l'ordre est un ordre d'achat ou de vente.
     *
     * @return true si c'est un ordre d'achat, false si c'est un ordre de vente
     */
    public boolean getEstAchat() {
        return this.estAchat;
    }

    /**
     * Modifie si l'ordre est un ordre d'achat ou de vente.
     *
     * @param estAchat true si c'est un ordre d'achat, false si c'est un ordre de vente
     */
    public void setEstAchat(boolean estAchat) {
        this.estAchat = estAchat;
    }

    /**
     * Obtient l'action associée à l'ordre.
     *
     * @return l'action associée à l'ordre
     */
    public Action getAction() {
        return this.action;
    }

    /**
     * Modifie l'action associée à l'ordre.
     *
     * @param action la nouvelle action associée à l'ordre
     */
    public void setAction(Action action) {
        this.action = action;
    }

    /**
     * Obtient la quantité de l'ordre.
     *
     * @return la quantité de l'ordre
     */
    public int getQuantite() {
        return this.quantite;
    }

    /**
     * Modifie la quantité de l'ordre.
     *
     * @param quantite la nouvelle quantité de l'ordre
     */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    /**
     * Obtient la date d'ouverture de l'ordre.
     *
     * @return la date d'ouverture de l'ordre
     */
    public String getDateOuverture() {
        return this.dateOuverture;
    }

    /**
     * Modifie la date d'ouverture de l'ordre.
     *
     * @param dateOuverture la nouvelle date d'ouverture de l'ordre
     */
    public void setDateOuverture(String dateOuverture) {
        this.dateOuverture = dateOuverture;
    }

    /**
     * Obtient la date de clôture de l'ordre.
     *
     * @return la date de clôture de l'ordre
     */
    public String getDateCloture() {
        return this.dateCloture;
    }

    /**
     * Modifie la date de clôture de l'ordre.
     *
     * @param dateCloture la nouvelle date de clôture de l'ordre
     */
    public void setDateCloture(String dateCloture) {
        this.dateCloture = dateCloture;
    }

    /**
     * Obtient le portefeuille associé à l'ordre.
     *
     * @return le portefeuille associé à l'ordre
     */
    public Portefeuille getPortefeuille() {
        return this.portefeuille;
    }

    /**
     * Modifie le portefeuille associé à l'ordre.
     *
     * @param portefeuille le nouveau portefeuille associé à l'ordre
     */
    public void setPortefeuille(Portefeuille portefeuille) {
        this.portefeuille = portefeuille;
    }

    /**
     * Obtient si l'ordre est au marché ou en limite.
     *
     * @return true si l'ordre est au marché, false s'il est en limite
     */
    public boolean getEstAuMarche() {
        return this.estAuMarche;
    }

    /**
     * Modifie si l'ordre est au marché ou en limite.
     *
     * @param estAuMarche true si l'ordre est au marché, false s'il est en limite
     */
    public void setEstAuMarche(boolean estAuMarche) {
        this.estAuMarche = estAuMarche;
    }

    /**
     * Obtient une représentation textuelle de l'ordre.
     *
     * @return une représentation textuelle de l'ordre
     */
    @Override
    public String toString() {
        return String.join("\n"
                , (this.estAchat ? "Achat"  : "Vente") +  " de " + this.action.toString()
                , "Statut de l'ordre : " + this.statut
                , "Marché/limit ?    : " + (this.estAuMarche ? "Marché"  : "Limit")
                , "Prix Unitaire     : " + this.prixUnit
                , "Quantité          : " + this.quantite
                , "Date ouverture    : " + this.dateOuverture
                , "Date cloture      : " + this.dateCloture 
       );
    }
}