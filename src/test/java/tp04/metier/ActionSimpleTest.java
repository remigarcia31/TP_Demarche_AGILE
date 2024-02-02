/*
 * Copyright 2024.
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
import org.junit.jupiter.api.Test;

public class ActionSimpleTest {

    @Test
    public void testEquals() {
        Action action1 = new ActionSimple("AXA", "AXA Banque", "finance");
        Action action2 = new ActionSimple("BNP", "bnp pariba", "finance");
        Action action3 = new ActionSimple("AFI", "Air France Industries", "transport");

        // Teste l'égalité basée sur le libellé
        assertEquals(action1, action2);
        assertNotEquals(action1, action3);
    }

    @Test
    public void testToString() {
        Action action = new ActionSimple("AXA", "AXA Banque", "finance");

        // Teste la représentation textuelle (toString) basée sur le libellé
        assertEquals("finance", action.toString());
    }

    @Test
    public void testDerniereValeur() {
        Action action = new ActionSimple("AXA", "AXA Banque", "finance");

        // Teste la dernière valeur de l'action
        assertEquals(50.0, action.derniere_valeur(), 0.01);
    }
}
