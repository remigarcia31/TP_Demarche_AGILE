/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp04.metier;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author perussel
 */
public abstract class Action {
/**
 * Bien sûr les methodes setter et getter pour l'ensemble des propriétés.
 * et Creation des proprietes de la classe
 */
    /**
     *
     * @param idAction
     * L'id d'une action est une valeur constante
     * */
    private final int idAction;
     /**
     *
     * @param coursMap
     * La coursMap représente une liste des cours au fil du temps
     * */
    private Map<Date, Float> coursMap;

     /**
     *
     * @param Entreprise
     * L'Entreprise concerne l'entreprise de l'action en question
     * */
    private String Entreprise; 
    /**
     *
     * @param Domaine
     * Le domaine correspond au domaine d'activite de l'entreprise
     * */
    private String Domaine;
    /**
     *
     * @param libelle
     * Le libelle de l'action en question
     * */
    private String libelle;
    /**
     *
     * @param idAction
     * @param coursMap
     * @param Entreprise
     * @param Domaine
     * @param libelle
     */
    public Action(final int idAction, Map<Date, Float> coursMap, String Entreprise,
            String Domaine, String libelle) {
        this.idAction = idAction;
        this.coursMap = coursMap;
        this.Entreprise = Entreprise;
        this.Domaine = Domaine;
        this.libelle = libelle;
    }

    /**
     *
     * @return
     */
    public int getidAction() {
        return idAction;
    }

    /**
     *
     * @return
     */
    public Map<Date, Float> getCoursMap() {
        return coursMap;
    }

    /**
     *
     * @param coursMap
     */
    public void setCoursMap(Map<Date, Float> coursMap) {
        this.coursMap = coursMap;
    }

    /**
     *
     * @return
     */
    public String getEntreprise() {
        return Entreprise;
    }

    /**
     *
     * @param Entreprise
     */
    public void setEntreprise(String Entreprise) {
        this.Entreprise = Entreprise;
    }

    /**
     * Get the value of Domaine
     *
     * @return
     */
    public String getDomaine() {
        return Domaine;
    }

    /**
     *
     * @param Domaine
     */
    public void setDomaine(String Domaine) {
        this.Domaine = Domaine;
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
     */
    public void setLibelle(String Libelle) {
        this.libelle = Libelle;
    }
  
    /**
     *
     * @return
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
     * @return libelle 
     */
    @Override
    public String toString() {
        return this.getLibelle();
    }
}
