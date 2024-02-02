/*
 * Copyright 2024 Remi.
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

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

public class PortefeuilleTest {

    private Portefeuille portefeuille;
    private ActionSimple action;

    @BeforeEach
    public void setUp() {
        // Initialisation des objets nécessaires pour les tests
        portefeuille = new Portefeuille(1000.0);
        action = new ActionSimple("AXA", "AXA Banque", "finance");
    }

    @Test
    public void testCreateOrderLimiteAchatSoldeSuffisant() {
        // Teste si la création d'un ordre limite d'achat fonctionne correctement avec un solde suffisant
        Map<Action, Integer> actions = new HashMap<>();
        actions.put(action, 10);
        portefeuille.setActions(actions);

        portefeuille.createOrderLimite(true, action, 50.0, 5, 1, portefeuille);

        assertEquals(500.0, portefeuille.getSolde(), 0.01);
    }

    @Test
    public void testCreateOrderLimiteAchatSoldeInsuffisant() {
        // Teste si la création d'un ordre limite d'achat échoue correctement avec un solde insuffisant
        Map<Action, Integer> actions = new HashMap<>();
        actions.put(action, 10);
        portefeuille.setActions(actions);

        portefeuille.createOrderLimite(true, action, 200.0, 5, 1, portefeuille);

        assertEquals(1000.0, portefeuille.getSolde(), 0.01);
    }

    @Test
    public void testCreateOrderMarcheAchatQuantiteValide() {
        // Teste si la création d'un ordre au marché d'achat fonctionne correctement avec une quantité valide
        Map<Action, Integer> actions = new HashMap<>();
        actions.put(action, 10);
        portefeuille.setActions(actions);

        portefeuille.createOrderMarche(true, action, 5, 1, portefeuille);

        assertEquals(750.0, portefeuille.getSolde(), 0.01);
    }

    @Test
    public void testCreateOrderMarcheAchatQuantiteInvalide() {
        // Teste si la création d'un ordre au marché d'achat échoue correctement avec une quantité invalide
        Map<Action, Integer> actions = new HashMap<>();
        actions.put(action, 5);
        portefeuille.setActions(actions);

        portefeuille.createOrderMarche(true, action, 10, 1, portefeuille);

        assertEquals(1000.0, portefeuille.getSolde(), 0.01);
    }

}