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
import java.util.List;

/**
 * Classe représentant une action simple héritant de la classe Action.
 * Cette classe stocke des informations spécifiques à une action simple,
 * telles que son identifiant, le nom de l'entreprise associée, le domaine,
 * et les valeurs de cours enregistrées.
 * Elle offre des méthodes pour enregistrer de nouvelles valeurs de cours,
 * obtenir des informations sur l'action,
 * et mettre à jour les valeurs de cours de manière aléatoire.
 * 
 * @author M2 IDA
 */
public class ActionSimple extends Action {

    // Attributs

    /**
     * Identifiant unique pour l'action simple.
     */
    private int id;

    /**
     * Nom de l'entreprise associée à l'action simple.
     */
    private String entreprise;

    /**
     * Domaine de l'action simple.
     */
    private String domaine;

    /**
     * Liste pour stocker les valeurs de cours associées à l'action simple.
     */
    private List<Double> listeCours;

    // Constructeurs

    /**
     * Constructeur par défaut avec un paramètre pour le libellé de 
     * l'action simple.
     * @param libelle Le libellé de l'action simple.
     */
    public ActionSimple(String libelle) {
        super(libelle);
    }

    /**
     * Constructeur avec des paramètres pour initialiser 
     * les attributs spécifiques de l'action simple.
     * @param id Identifiant unique de l'action simple.
     * @param entreprise Nom de l'entreprise associée à l'action simple.
     * @param domaine Domaine de l'action simple.
     * @param libelle Le libellé de l'action simple.
     */
    public ActionSimple(int id, String entreprise, String domaine, String libelle) {
        super(libelle);
        this.id = id;
        this.entreprise = entreprise;
        this.domaine = domaine;
        this.listeCours = new ArrayList();
    }

    // Méthode pour enregistrer les valeurs de cours

    /**
     * Enregistre une nouvelle valeur de cours pour cette action simple.
     * @param v La valeur de cours à enregistrer.
     */
    public void enrgCours(Double v) {
        this.listeCours.add(v);
    }

    // Méthodes d'accès (Getters et Setters) pour les attributs

    /**
     * Obtient l'identifiant de l'action simple.
     * @return L'identifiant de l'action simple.
     */
    public int getId() {
        return id;
    }

    /**
     * Modifie l'identifiant de l'action simple.
     * @param Id Le nouvel identifiant de l'action simple.
     */
    public void setId(int Id) {
        this.id = Id;
    }

    /**
     * Obtient le nom de l'entreprise associée à l'action simple.
     * @return Le nom de l'entreprise associée à l'action simple.
     */
    public String getEntreprise() {
        return entreprise;
    }

    /**
     * Modifie le nom de l'entreprise associée à l'action simple.
     * @param Entreprise Le nouveau nom de l'entreprise.
     */
    public void setEntreprise(String Entreprise) {
        this.entreprise = Entreprise;
    }

    /**
     * Obtient le domaine de l'action simple.
     * @return Le domaine de l'action simple.
     */
    public String getDomaine() {
        return domaine;
    }

    /**
     * Modifie le domaine de l'action simple.
     * @param Domaine Le nouveau domaine de l'action simple.
     */
    public void setDomaine(String Domaine) {
        this.domaine = Domaine;
    }

    /**
     * Obtient la liste des valeurs de cours associées à l'action simple.
     * @return La liste des valeurs de cours.
     */
    public List<Double> getListeCours() {
        return listeCours;
    }

    /**
     * Modifie la liste des valeurs de cours associées à l'action simple.
     * @param listeCours La nouvelle liste des valeurs de cours.
     */
    public void setListeCours(List<Double> listeCours) {
        this.listeCours = listeCours;
    }

    // Méthodes pour obtenir des informations sur les valeurs de cours

    /**
     * Obtient la valeur de cours pour un jour spécifique.
     * @param indice L'indice représentant le jour 
     * pour lequel on souhaite obtenir la valeur.
     * @return La valeur de cours pour le jour spécifié.
     */
    public double valeur(int indice) {
        return this.listeCours.get(indice);
    }

    /**
     * Obtient la dernière valeur de cours enregistrée.
     * @return La dernière valeur de cours enregistrée.
     */
    @Override
    public double derniere_valeur() {
        return this.listeCours.get(this.listeCours.size()-1);
    }

    // Méthode pour mettre à jour les valeurs de cours

    /**
     * Met à jour les valeurs de cours en générant 
     * une nouvelle valeur aléatoire entre 2 et -2,
     * puis l'ajoute à la dernière valeur enregistrée.
     */
    public void Update(){
        double dernier_value = this.listeCours.get(this.listeCours.size()-1);
        this.listeCours.add(dernier_value + (Math.random() * 4) - 2);
    }
}