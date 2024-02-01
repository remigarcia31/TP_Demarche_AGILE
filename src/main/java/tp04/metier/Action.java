/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp04.metier;

import java.util.Objects;
import java.util.List;

/**
 *
 * @author Mohamed abderramhane
 */
public abstract class Action {
    
    private String libelle;
    private String entreprise;
    private String domaine;
    private List<Float> cours;

    public Action(String libelle, String entreprise, String domaine) {
        this.libelle = libelle;
        this.entreprise = entreprise;
        this.domaine = domaine;
    }
    
    public Action(String libelle) {
        this.libelle = libelle;
        this.entreprise = "";
        this.domaine = "";
    }
    

    /**
     * Get the value of libelle
     *
     * @return the value of libelle
     */
    public String getLibelle() {
        return libelle;
    }
    
    /**
     * Set the value of libelle
     *
     * @param libelle new value of libelle
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
    /**
     * Get the value of entreprise
     *
     * @return the value of entreprise
     */
    public String getEntreprise() {
        return this.entreprise;
    }
    
    /**
     * Set the value of entreprise
     *
     * @param entreprise new value of entreprise
     */
    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }
    
    /**
     * Get the value of domaine
     *
     * @return the value of domaine
     */
    public String getDomaine() {
        return libelle;
    }
    
    /**
     * Set the value of domaine
     *
     * @param domaine new value of domaine
     */
    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }
    
    public abstract float getValeur();
    public abstract float getValeurJour(int jour);
    public abstract void addValeur();

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() == obj.getClass()) {
            if (this.domaine.equals(obj.domaine) & 
                this.libelle.equals(obj.libelle) & 
                this.domaine.equals(obj.domaine)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return this.getLibelle();
    }
}
