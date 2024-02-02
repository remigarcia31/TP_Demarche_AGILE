/*
 * Copyright 2024 moham.
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

import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author moham
 */
public class ActionComposeeTest {
    
    public ActionComposeeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
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
     * Test of derniere_valeur method, of class ActionComposee.
     */
    @Test
    public void testDerniere_valeur() {
        System.out.println("derniere_valeur");
        ActionComposee instance = null;
        double expResult = 0.0;
        double result = instance.derniere_valeur();
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
