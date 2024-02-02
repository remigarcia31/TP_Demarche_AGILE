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

class PortefeuilleTest {

    private Portefeuille portefeuille;
    private ActionSimple action;

    @BeforeEach
    public void setUp() {
        portefeuille = new Portefeuille(1000.0);
        action = new ActionSimple("AXA", "AXA Banque", "finance");
    }

    @Test
    void testTestSolde() {
        assertTrue(portefeuille.testSolde(500.0));
        assertFalse(portefeuille.testSolde(1500.0));
    }
    
    @Test
    void testGetSetActions() {
        Map<Action, Integer> newActions = new HashMap<>();
        newActions.put(new ActionSimple("AAPL", "Apple Inc.", "Technology"), 50);
        newActions.put(new ActionSimple("GOOGL", "Alphabet Inc.", "Technology"), 30);

        portefeuille.setActions(newActions);

        assertEquals(newActions, portefeuille.getActions());
    }

    @Test
    void testGetSetSolde() {
        portefeuille.setSolde(1500.0);

        assertEquals(1500.0, portefeuille.getSolde());
    }

    @Test
    void testGetSetValeur() {
        portefeuille.setValeur(2000.0);

        assertEquals(2000.0, portefeuille.getValeur());
    }
}