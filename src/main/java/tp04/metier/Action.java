/*
 * Pour modifier les en-têtes de licence, choisissez les en-têtes 
de licence dans les propriétés du projet.
 * Pour modifier ce fichier modèle, choisissez Outils | Modèles
 * et ouvrez le modèle dans l'éditeur.
 */

package tp04.metier;

import java.util.Objects;

/**
 * Classe abstraite représentant une action.
 * Cette classe sert de base pour les classes dérivées représentant 
 * des actions simples ou composées.
 * Elle définit les propriétés communes à toutes les actions, 
 * telles que le libellé.
 * Elle fournit également des méthodes de comparaison et de représentation.
 * 
 * @author perussel
 */
public abstract class Action {

    // Attributs

    /**
     * Le libellé de l'action.
     */
    private String libelle;

    // Constructeur

    /**
     * Constructeur avec un paramètre pour initialiser le libellé de l'action.
     * @param libelle Le libellé de l'action.
     */
    public Action(String libelle) {
        this.libelle = libelle;
    }

    // Méthodes d'accès (Getters et Setters) pour les attributs

    /**
     * Obtient le libellé de l'action.
     * @return Le libellé de l'action.
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * Modifie le libellé de l'action.
     * @param Libelle Le nouveau libellé de l'action.
     */
    public void setLibelle(String Libelle) {
        this.libelle = Libelle;
    }

    /**
     * Elle est abstraite pour s'assurer pour qu'elle soit imlementee partout.
     * @return derniere valeur
     */
    public abstract double derniere_valeur();

    // Méthodes pour la gestion des comparaisons et la représentation

    /**
     * Calcule et retourne le code de hachage de l'action.
     * @return Le code de hachage de l'action.
     */
    @Override
    public int hashCode() {
        int hash;
        hash = 3;
        hash = 53 * hash + Objects.hashCode(this.libelle);
        return hash;
    }

    /**
     * Compare l'objet actuel avec un autre objet 
     * pour l'égalité basée sur le libellé.
     * @param obj L'objet à comparer avec l'action actuelle.
     * @return true si les objets sont égaux, false sinon.
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
     * Retourne une représentation textuelle de l'action (le libellé).
     * @return Le libellé de l'action sous forme de chaîne de caractères.
     */
    @Override
    public String toString() {
        return this.getLibelle();
    }
}
