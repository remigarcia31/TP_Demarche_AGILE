/*
 * 
 */

package tp04.metier;

/**
 * La classe Jour représente une journée spécifique définie par une année et un numéro de jour.
 * Elle contient des méthodes pour obtenir les valeurs de l'année et du numéro de jour, ainsi que
 * des méthodes pour calculer le code de hachage, comparer l'égalité et construire une instance de Jour.
 * 
 * @author M2 IDA 2024
 */
public class Jour {

    private int annee;
    private int noJour;

    /**
     * Renvoie la valeur de l'année.
     * @return la valeur de l'année
     */
    public int getAnnee() {
        return annee;
    }

    /**
     * Renvoie la valeur du numéro de jour.
     * @return la valeur du numéro de jour
     */
    public int getNoJour() {
        return noJour;
    }

    /**
     * Constructeur de la classe Jour.
     * @param annee L'année de la journée
     * @param noJour Le numéro de jour dans l'année
     */
    public Jour(int annee, int noJour) {
        this.annee = annee;
        this.noJour = noJour;
    }

    /**
     * Calcule et renvoie le code de hachage de l'instance Jour.
     * @return le code de hachage calculé
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.annee;
        hash = 61 * hash + this.noJour;
        return hash;
    }

    /**
     * Vérifie si l'objet spécifié est égal à cette instance de Jour.
     * @param obj L'objet à comparer
     * @return true si les instances sont égales, sinon false
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jour other = (Jour) obj;
        if (this.annee != other.annee) {
            return false;
        }
        if (this.noJour != other.noJour) {
            return false;
        }
        return true;
    }
  
}