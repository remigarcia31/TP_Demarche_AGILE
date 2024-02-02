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
package metier;

import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Remi
 */
public class ActionComposeeTest {
    
    public ActionComposeeTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        ActionComposee actc = new ActionComposee("test");
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of enrgComposition method, of class ActionComposee.
     */
    @Test
    public void testEnrgComposition() {
        System.out.println("enrgComposition");
        ActionSimple as = null;
        Double pourcentage = null;
        ActionComposee instance = null;
        instance.enrgComposition(as, pourcentage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMapPanier method, of class ActionComposee.
     */
    @Test
    public void testGetMapPanier() {
        System.out.println("getMapPanier");
        ActionComposee instance = null;
        Map<ActionSimple, Double> expResult = null;
        Map<ActionSimple, Double> result = instance.getMapPanier();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMapPanier method, of class ActionComposee.
     */
    @Test
    public void testSetMapPanier() {
        System.out.println("setMapPanier");
        Map<ActionSimple, Double> mapPanier = null;
        ActionComposee instance = null;
        instance.setMapPanier(mapPanier);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valeur method, of class ActionComposee.
     */
    @Test
    public void testValeur() {
        System.out.println("valeur");
        int j = 0;
        ActionComposee instance = null;
        double expResult = 0.0;
        double result = instance.valeur(j);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Update method, of class ActionComposee.
     */
    @Test
    public void testUpdate() {
        System.out.println("Update");
        ActionComposee instance = null;
        instance.Update();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}