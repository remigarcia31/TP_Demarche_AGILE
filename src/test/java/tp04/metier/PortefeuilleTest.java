package tp04.metier;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

public class PortefeuilleTest {
        
        public PortefeuilleTest() {
                
        }
    
        @org.junit.jupiter.api.Test
        public void testUniqueIds() {
            Portefeuille portefeuille1 = new Portefeuille(1000.0, "Hugo");
            Portefeuille portefeuille2 = new Portefeuille(500.5, "Rémi");
            Portefeuille portefeuille3 = new Portefeuille(700.5, "Gaboche");

            Set<Integer> ids = new HashSet<>();
            ids.add(portefeuille1.obtenirId());
            ids.add(portefeuille2.obtenirId());
            ids.add(portefeuille3.obtenirId());

            assertEquals(3, ids.size());
        }

        @org.junit.jupiter.api.Test
        public void testMouvementAction() {
            Portefeuille portefeuille = new Portefeuille(1000.0, "Hugo");
            Action action = new Action("Apple", 100.0, 10);
            portefeuille.ajouterAction(action);
            assertEquals(1, portefeuille.obtenirListeAction().size());
            portefeuille.enleverAction(action);
            assertEquals(0, portefeuille.obtenirListeAction().size());
        }
    
        @org.junit.jupiter.api.Test
        public void testAddTransaction() {
            Portefeuille portefeuille = new Portefeuille(1000.0, "Hugo");
            Transaction transaction = new Transaction(100.0, 10);
            portefeuille.ajouterTransaction(transaction);
            assertEquals(1, portefeuille.obtenirListeTransaction().size());
        }

        @org.junit.jupiter.api.Test
        public void testAddOrdre() {
            Portefeuille portefeuille = new Portefeuille(1000.0, "Hugo");
            Ordre ordre = new Ordre(100.0, 10);
            portefeuille.ajouterOrdre(ordre);
            assertEquals(1, portefeuille.obtenirListeOrdre().size());
        }
}
