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
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;

public class ActionSimpleTest {

    private ActionSimple actionSimple;

    @BeforeEach
    public void setUp() {
        actionSimple = new ActionSimple("AAPL", "Technology", "Apple Inc.");
    }

    @Test
    void testGetSetEntreprise() {
        actionSimple.setEntreprise("GOOGL");
        assertEquals("GOOGL", actionSimple.getEntreprise());
    }

    @Test
    void testGetSetDomaine() {
        actionSimple.setDomaine("Consumer Electronics");
        assertEquals("Consumer Electronics", actionSimple.getDomaine());
    }

    @Test
    void testGetSetListeCours() {
        List<Double> newList = new ArrayList<>();
        newList.add(150.0);
        newList.add(155.0);
        newList.add(160.0);
        actionSimple.setListeCours(newList);

        assertEquals(newList, actionSimple.getListeCours());
    }

    @Test
    void testEnrgCours() {
        actionSimple.enrgCours(150.0);

        assertEquals(150.0, actionSimple.derniere_valeur());
        assertEquals(150.0, actionSimple.valeur(0));
    }

    @Test
    void testUpdate() {
        actionSimple.Update();

        assertTrue(actionSimple.derniere_valeur() >= 0 && actionSimple.derniere_valeur() <= 200);
    }   
    
}
