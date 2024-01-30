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
 */
public class Ordre {
    
    /**
     * L'utilisateur crée un ordre qui teste le marché (prix quantité) pour 
     * permettre la réalisation d'une transaction
     */
    enum Statut {
        OUVERT,
        VALIDER,
        REFUSER
    };

    private Statut statut;
    private long prixUnit;
    
    private boolean estAchat; // achat vente
    private Action action;
    private int quantite;
    private String dateOuverture;
    private String dateCloture;
    private Portefeuille portefeuille;
    private boolean estAuMarche;

    public Ordre (
            boolean estAchat, Action action,
            long prixUnit, int quantite, 
            String dateCloture, Portefeuille portefeuille,
            boolean estAuMarche
    )
    {
        this.statut = statut.OUVERT;
        this.prixUnit = prixUnit;
        this.estAchat = estAchat;
        this.action = action;
        this.quantite = quantite;
        this.dateCloture = dateCloture; 
        this.portefeuille = portefeuille;
        this.estAuMarche = estAuMarche;
    }
    
    /**
     * Get the value of statut
     *
     * @return the value of statut
     */
    public Statut getStatut() {
        return this.statut;
    }

    /**
     * Set the value of statut
     *
     * @param statut new value of statut
     */
    public void setStatut(Statut statut) {
        this.statut = statut;
    }
    
    /**
     * Get the value of prixUnit
     *
     * @return the value of prixUnit
     */
    public long getPrixUnit() {
        return this.prixUnit;
    }

    /**
     * Set the value of prixUnit
     *
     * @param prixUnit new value of prixUnit
     */
    public void setPrixUnit(long prixUnit) {
        this.prixUnit = prixUnit;
    }
    
    /**
     * Get the value of estAchat
     *
     * @return the value of estAchat
     */
    public boolean getEstAchat() {
        return this.estAchat;
    }

    /**
     * Set the value of estAchat
     *
     * @param estAchat new value of estAchat
     */
    public void setPrix(boolean estAchat) {
        this.estAchat = estAchat;
    }
    
    /**
     * Get the value of action
     *
     * @return the value of action
     */
    public Action getAction() {
        return this.action;
    }

    /**
     * Set the value of action
     *
     * @param action new value of action
     */
    public void setAction(Action action) {
        this.action = action;
    }
    
    /**
     * Get the value of quantite
     *
     * @return the value of quantite
     */
    public int getQuantite() {
        return this.quantite;
    }

    /**
     * Set the value of quantite
     *
     * @param quantite new value of quantite
     */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
    /**
     * Get the value of dateOuverture
     *
     * @return the value of dateOuverture
     */
    public String getDateOuverture() {
        return this.dateOuverture;
    }

    /**
     * Set the value of dateOuverture
     *
     * @param dateOuverture new value of dateOuverture
     */
    public void setDateOuverture(String dateOuverture) {
        this.dateOuverture = dateOuverture;
    }
    
    /**
     * Get the value of dateCloture
     *
     * @return the value of dateCloture
     */
    public String getdateCloture() {
        return this.dateCloture;
    }

    /**
     * Set the value of dateCloture
     *
     * @param dateCloture new value of dateCloture
     */
    public void setDateCloture(String dateCloture) {
        this.dateCloture = dateCloture;
    }   

    /**
     * Get the value of portefeuille
     *
     * @return the value of portefeuille
     */
    public Portefeuille getPortefeuille() {
        return this.portefeuille;
    }

    /**
     * Set the value of portefeuille
     *
     * @param portefeuille new value of portefeuille
     */
    public void setPortefeuille(Portefeuille portefeuille) {
        this.portefeuille = portefeuille;
    } 

    /**
     * Get the value of estAuMarche
     *
     * @return the value of typeOrdre
     */
    public boolean getEstAuMarche() {
        return this.estAuMarche;
    }

    /**
     * Set the value of estAuMarche
     *
     * @param estAuMarche new value of estAuMarche
     */
    public void setEstAuMarche(boolean estAuMarche) {
        this.estAuMarche = estAuMarche;
    } 

    @Override
    public String toString() {
        return String.join("\n"
                , (this.estAchat ? "Achat"  : "Vente") +  "de" +this.action.toString()
                , "Statut de l'ordre : " + this.statut
                , "Marché/limit ?    : " + (this.estAuMarche ? "Marché"  : "Limit")
                , "Prix Unitaire     : " + this.prixUnit
                , "Quantité          : " + this.quantite
                , "Date ouverture    : " + this.dateOuverture
                , "Date cloture      : " + this.dateCloture 
       );
    }
    
    
    
}
 