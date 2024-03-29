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

package metier;
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
 * @author M2 IDA
 */
public class ActionComposee extends Action {

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
        this.mapPanier = new HashMap<ActionSimple, Double>();
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
        Double valeur = Double.valueOf(0);
        
        for (Map.Entry<ActionSimple, Double> entry: this.mapPanier.entrySet()) {
            valeur += entry.getKey().getListeCours().get(j) * entry.getValue();
        }
        
        return valeur;
    }
    /**
    * Calcule et retourne la dernière valeur de l'action composée, 
    * mise à jour avec les dernières valeurs des actions simples.
    * en utilisant les dernières valeurs enregistrées des actions simples 
    * dans la composition.
    * Elle calcule ensuite la valeur totale de l'action composée en combinant 
    * les valeurs des actions simples
    * en utilisant les pourcentages associés.
    * @return La dernière valeur de l'action composée.
    */
    @Override
    public double derniereValeur() {


    // Initialise la valeur à 0.
    Double valeur = Double.valueOf(0);

    // Calcule la valeur totale de l'action composée en combinant 
    //les valeurs des actions simples avec les pourcentages.
    for (Map.Entry<ActionSimple, Double> entry: this.mapPanier.entrySet()) {
        valeur = valeur + (entry.getKey().derniereValeur() * entry.getValue());
    }
    
    return valeur; // Retourne la valeur totale de l'action composée.
}


    /**
     * Met à jour les pourcentages de composition en utilisant 
     * les dernières valeurs enregistrées
     * des actions simples dans la composition.
     */
    public void update() {
        for (ActionSimple action : this.mapPanier.keySet()) {
            action.update();
        }
    }
}
