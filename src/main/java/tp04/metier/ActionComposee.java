/*
 * Pour modifier les en-têtes de licence, choisissez les en-têtes de licence 
dans les propriétés du projet.
 * Pour modifier ce fichier modèle, choisissez Outils | Modèles
 * et ouvrez le modèle dans l'éditeur.
 */

package tp04.metier;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe représentant une action composée héritant de la classe Action.
 * Cette classe stocke des informations spécifiques à une action composée,
 * telles que la liste d'actions simples associées à des pourcentages, 
 * permettant de composer le portefeuille.
 * Elle offre des méthodes pour enregistrer de nouvelles actions simples 
 * dans la composition,
 * obtenir la valeur de l'action composée pour un jour donné, et mettre à jour 
 * les pourcentages de composition.
 * 
 * @author perussel
 */
public class ActionComposee extends Action {

    // Attributs

    /**
     * Liste d'actions simples associées à des pourcentages de composition dans
     * l'action composée.
     */
    Map<ActionSimple, Double> mapPanier;

    // Constructeurs

    /**
     * Constructeur par défaut avec un paramètre pour le libellé 
     * de l'action composée.
     * Initialise la liste d'actions simples associées à des pourcentages.
     * @param libelle Le libellé de l'action composée.
     */
    public ActionComposee(String libelle) {
        super(libelle);
        this.mapPanier = new HashMap();
    }

    // Méthodes pour la gestion de la composition

    /**
     * Enregistre une nouvelle action simple dans la composition de 
     * l'action composée,
     * associée à un pourcentage spécifié.
     * @param as L'action simple à ajouter à la composition.
     * @param pourcentage Le pourcentage d'association de 
     * l'action simple dans la composition.
     */
    public void enrgComposition(ActionSimple as, Double pourcentage) {
        this.mapPanier.put(as, pourcentage);
    }

    /**
     * Obtient la liste d'actions simples associées à des pourcentages dans 
     * la composition de l'action composée.
     * @return La liste d'actions simples et leurs pourcentages.
     */
    public Map<ActionSimple, Double> getMapPanier() {
        return mapPanier;
    }

    /**
     * Modifie la liste d'actions simples associées à des pourcentages dans 
     * la composition de l'action composée.
     * @param mapPanier La nouvelle liste d'actions simples et 
     * leurs pourcentages.
     */
    public void setMapPanier(Map<ActionSimple, Double> mapPanier) {
        this.mapPanier = mapPanier;
    }

    // Méthode pour obtenir la valeur de l'action composée

    /**
     * Calcule et retourne la valeur de l'action composée pour un jour spécifié.
     * La valeur est obtenue en combinant les valeurs 
     * des actions simples dans la composition
     * en utilisant les pourcentages associés.
     * @param j L'indice représentant le jour pour lequel 
     * on souhaite obtenir la valeur.
     * @return La valeur de l'action composée pour le jour spécifié.
     */
    public double valeur(int j) {
        Double valeur;
        valeur = Double.valueOf(0) ;
        for (ActionSimple as : this.mapPanier.keySet()) {
            valeur = valeur + (as.getListeCours().get(j) * this.mapPanier.get(as));
        }
        return valeur;
    }

    // Méthode pour mettre à jour les pourcentages de composition

    /**
     * Met à jour les pourcentages de composition en utilisant 
     * les dernières valeurs enregistrées
     * des actions simples dans la composition.
     */
    public void Update() {
        for (ActionSimple as : this.mapPanier.keySet()) {
            this.mapPanier.put(as, as.dernier_valeur());
        }
    }
}
