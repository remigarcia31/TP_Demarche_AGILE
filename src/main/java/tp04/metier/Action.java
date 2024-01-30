/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp04.metier;

import java.util.Objects;

/**
 *
 * @author perussel
 */
public abstract class Action {
/**
 * Bien sûr les methodes setter et getter pour l'ensemble des propriétés.
 * et Creation des proprietes de la classe
**/    
    /**
     *
     * @param libelle
     * Le libelle de l'action en question
     * */
    private String libelle;
    /**
     *
     * @param libelle
     */
    public Action(String libelle) {
        this.libelle = libelle;
    }

    /**
     *
     * @return
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     *
     * @param Libelle
     * Cette fonction nous permet de set Libelle d'une action
     */
    public void setLibelle(String Libelle) {
        this.libelle = Libelle;
    }
  
    /**
     *
     * @return the hash code 
     */
    @Override
    public int hashCode() {
        int hash;
        hash = 3;
        hash = 53 * hash + Objects.hashCode(this.libelle);
        return hash;
    }

    /**
     *
     * @param obj
     * @return boolean
     */
    @Override
    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Action other = (Action) obj;
        return Objects.equals(this.libelle, other.libelle);
    }

    /**
     *
     * @return libelle de l'action
     */
    @Override
    public String toString() {
        return this.getLibelle();
    }
}
