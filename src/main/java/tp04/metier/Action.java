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

import java.util.Objects;

/**
 * Classe abstraite représentant une action.
 * Cette classe sert de base pour les classes dérivées représentant 
 * des actions simples ou composées.
 * Elle définit les propriétés communes à toutes les actions, 
 * telles que le libellé.
 * Elle fournit également des méthodes de comparaison et de représentation.
 * 
 * @author M2 IDA
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
