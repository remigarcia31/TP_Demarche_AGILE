package tp04.metier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
/*
public class PortefeuilleTest {
        
        public PortefeuilleTest() {
                
        }
        
        private Portefeuille portefeuille;
        private Action action;
        
        void MiseEnPlace() {
            portefeuille = new Portefeuille(1000.0, "Hugo");
            action = new Action("Apple", 100.0, 10);
        }
        
        @org.junit.jupiter.api.Test
        void testInitialisationPortefeuille() {
            assertEquals("Hugo", portefeuille.obtenirNomProprietaire());
            assertEquals(1000.0, portefeuille.obtenirSolde(), 0.001);
            assertTrue(portefeuille.obtenirListeAction().isEmpty());
        }

        @org.junit.jupiter.api.Test
        void testAjoutActionAuPortefeuille() {
            portefeuille.ajouterAction(action);
            assertEquals(1, portefeuille.obtenirListeAction().size());
            assertTrue(portefeuille.obtenirListeAction().contains(action));
        }
        
        @org.junit.jupiter.api.Test
        public void testMouvementAction() {
            portefeuille.ajouterAction(action);
            assertEquals(1, portefeuille.obtenirListeAction().size());
            portefeuille.enleverAction(action);
            assertEquals(0, portefeuille.obtenirListeAction().size());
        }

        @org.junit.jupiter.api.Test
        void testEnleverActionDuPortefeuille() {
            portefeuille.ajouterAction(action);
            portefeuille.enleverAction(action);
            assertEquals(0, portefeuille.obtenirListeAction().size());
        }

        @org.junit.jupiter.api.Test
        void testEnleverQuantiteActionDuPortefeuille() {
            portefeuille.ajouterAction(action);
            portefeuille.enleverQuantiteAction(action, 5);
            assertEquals(5, action.obtenirQuantite());
        }

        @org.junit.jupiter.api.Test
        void testAffichagePortefeuille() {
            String expected = "Portefeuille{nomProprietaire=Hugo, solde=1000.0, listeAction=[]}";
            assertEquals(expected, portefeuille.toString());
        }

        @org.junit.jupiter.api.Test
        void testDefinirNomProprietaire() {
            portefeuille.definirNomProprietaire("NouveauProprietaire");
            assertEquals("NouveauProprietaire", portefeuille.obtenirNomProprietaire());
        }

        @org.junit.jupiter.api.Test
        void testDefinirSolde() {
            portefeuille.definirSolde(1500.0);
            assertEquals(1500.0, portefeuille.obtenirSolde(), 0.001);
        }

        @org.junit.jupiter.api.Test
        void testAjoutEtEnleverAction() {
            portefeuille.ajoutAction(action);
            assertEquals(1, portefeuille.obtenirListeAction().size());

            portefeuille.enleverAction(action);
            assertEquals(0, portefeuille.obtenirListeAction().size());
        }
    
}
*/