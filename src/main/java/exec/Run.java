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
package exec;

import metier.ActionComposee;
import metier.ActionSimple;
import metier.Marche;
import metier.Portefeuille;
import java.util.Scanner;

public class Run {

    public static void main(String[] args) {
        
        final String ESN = "services numériques";
        
        ActionSimple axa = new ActionSimple("AXA", "AXA Banque", "finance");
        ActionSimple bnp = new ActionSimple("BNP", "bnp pariba", "finance");
        ActionSimple afi = new ActionSimple("AFI", "Air France Industries", "transport");
        ActionSimple tis = new ActionSimple("TIS", "TISSEO", "transport");
        ActionSimple abs = new ActionSimple("ABS", "Air Bus", "aerospace");
        ActionSimple tas = new ActionSimple("TAS", "Thales ALenia Space", "aerospace");
        ActionSimple ats = new ActionSimple("ATS", "Atos", ESN);
        ActionSimple spr = new ActionSimple("SPR", "Sopra Steria", ESN);
        ActionSimple cap = new ActionSimple("CAP", "Capgemini", ESN);
        
        ActionComposee ar = new ActionComposee("AR");
        ar.enrgComposition(abs, 0.8d);
        ar.enrgComposition(tas, 0.2d);
        
        ActionComposee fi = new ActionComposee("FI");
        ar.enrgComposition(ats, 0.08d);
        ar.enrgComposition(spr, 0.5d);
        ar.enrgComposition(cap, 0.42d);
        
        ActionComposee sn = new ActionComposee("SN");
        ar.enrgComposition(abs, 0.8d);
        ar.enrgComposition(tas, 0.2d);

        Marche marche = Marche.getInstance();
        
        marche.addAction(axa, 5000);
        marche.addAction(bnp, 7500);
        marche.addAction(afi, 3000);
        marche.addAction(tis, 10700);
        marche.addAction(abs, 5000);
        marche.addAction(tas, 5000);
        marche.addAction(ats, 5000);
        marche.addAction(spr, 5000);
        marche.addAction(cap, 5000);
        marche.addAction(ar, 100);
        marche.addAction(fi, 100);
        marche.addAction(sn, 100);

        int jour = 0;                           // premier jours de la simulation on par du principe qu'on utilise que les jours
        boolean run = true;                     // état de l'execution
        String prompt;                          // capture les saisies user
        Scanner in = new Scanner(System.in);    // Scanner retourne les saisie user
        Portefeuille p = new Portefeuille(10000d);
        p.createOrderMarche(true, ats, 0, 2);
        
        while (run) {                           // tant qu'on tourne
            if (jour == 0) {                    // si premier jour 
                System.out.println("Bienvenue dans la simulation de bourse\n");
            }
            else {                              // sinon
                System.out.println("Jour " + jour + " de la simulation");
            }
            
            System.out.println("saisissez GO pour continuer STOP pour sortir");
            prompt = in.nextLine();
            
            if (prompt.equalsIgnoreCase("stop")) {run = false;} // Stop on stope
            
            if (run) {
                System.out.println("Vous êtes au jour" + jour); // quel jour
                Marche.getInstance().updatePrix(); // fonction mettant a jours le prix journalier du marché (append prix journalier dans Action)
                System.out.println("Liste des actions disponibles : "); // liste des actions disponibles
                Marche.getInstance().getActionComposeeList().toString();
                Marche.getInstance().getActionSimpleList();
            }

            System.out.println("liste des commandes disponibles : " // fonctionalités us
                    + "voir action : voir -a <libelle action>"
                    + "voir ...");
            Marche.getInstance().traiterOrdres(); // fonction qui essaye de passer les ordres et générer les transactions
            jour += 1; 
        }
    }
}
