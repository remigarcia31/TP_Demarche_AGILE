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
package tp04.exec;

import tp04.metier.Action;
import tp04.metier.ActionComposee;
import tp04.metier.ActionSimple;
import tp04.metier.Marche;
import tp04.metier.Ordre;
import tp04.metier.Portefeuille;
import java.util.Scanner;

public class Run {

    public static void main(String[] args) {
        ActionSimple axa = new ActionSimple("AXA", "AXA Banque", "finance");
        ActionSimple bnp = new ActionSimple("BNP", "bnp pariba", "finance");
        ActionSimple afi = new ActionSimple("AFI", "Air France Industries", "transport");
        ActionSimple tis = new ActionSimple("TIS", "TISSEO", "transport");
        ActionSimple abs = new ActionSimple("ABS", "Air Bus", "aerospace");
        ActionSimple tas = new ActionSimple("TAS", "Thales ALenia Space", "aerospace");
        ActionSimple ats = new ActionSimple("ATS", "Atos", "services numérique");
        ActionSimple spr = new ActionSimple("SPR", "Sopra Steria", "services numérique");
        ActionSimple cap = new ActionSimple("CAP", "Capgemini", "services numérique");
        
        ActionComposee ar = new ActionComposee("AR", "", "aero");
        ar.enrgComposition(abs, 0.8f);
        ar.enrgComposition(tas, 0.2f);
        
        ActionComposee fi = new ActionComposee("FI", "", "finance");
        ar.enrgComposition(ats, 0.08f);
        ar.enrgComposition(spr, 0.5f);
        ar.enrgComposition(cap, 0.42f);
        
        ActionComposee sn = new ActionComposee("SN", "", "Services numériques");
        ar.enrgComposition(abs, 0.8f);
        ar.enrgComposition(tas, 0.2f);

        Marche marche = Marche.getInstance();
        
        marche.addActions(axa, 5000);           // Ajoute une action avec une quantité
        marche.addActions(bnp, 7500);
        marche.addActions(afi, 3000);
        marche.addActions(tis, 10700);
        marche.addActions(abs, 5000);
        marche.addActions(tas, 5000);
        marche.addActions(ats, 5000);
        marche.addActions(spr, 5000);
        marche.addActions(cap, 5000);
        marche.addActions(ar);                  // Ajoute une action composée sans qt (elle est caclulée
        marche.addActions(fi);
        marche.addActions(sn);
        
        int jour = 0;                           // premier jours de la simulation on par du principe qu'on utilise que les jours
        boolean run = true;                     // état de l'execution
        String prompt;                          // capture les saisies user
        Scanner in = new Scanner(System.in);    // Scanner retourne les saisie user
        
        while (run) {                           // tant qu'on tourne
            if (jour == 0) {                    // si premier jour 
                System.out.println("Bienvenue dans la simulation de bourse\n");
            }
            else {                              // sinon
                System.out.println("Jour " + String.valueOf(jour) + " de la simulation");
            }
            
            System.out.println("saisissez GO pour continuer STOP pour sortir");
            
            prompt = in.nextLine();
            
            if (prompt.toLowerCase().equals("stop")) {run = false;} // Stop on stope
            
            if (run) {
                System.out.println("Vous êtes au jour" + String.valueOf(jour)); // quel jour
            
                Marche.updateActions(); // fonction mettant a jours le prix journalier du marché (append prix journalier dans Action)
            
                System.out.println("Liste des actions disponibles : "); // liste des actions disponibles
                for (int i = 0; i < Marche.getInstance().actions.length()) {    // parcours la liste et to string avec qte
                    System.out.println("Action      : \n" + 
                                        Action.toString() + 
                                        "\nquantité : \n" + qte);
                }
                
                system.out.println("liste des commandes disponibles : "  // fonctionalités us
                        + "voir action : voir -a <libelle action>"
                        + "voir ...")
            
                Marche.tryOrders(); // fonction qui essaye de passer les ordres et générer les transactions
                
                jour += 1;  
            }
 
        }
 
    }

}
