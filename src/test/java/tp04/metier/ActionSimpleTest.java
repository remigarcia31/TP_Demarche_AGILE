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

import java.util.List;
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
public class ActionSimpleTest {
    
    public ActionSimpleTest() {
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
     * Test of enrgCours method, of class ActionSimple.
     */
    @Test
    public void testEnrgCours() {
        System.out.println("enrgCours");
        Double v = null;
        ActionSimple instance = null;
        instance.enrgCours(v);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class ActionSimple.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        ActionSimple instance = null;
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class ActionSimple.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int Id = 0;
        ActionSimple instance = null;
        instance.setId(Id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEntreprise method, of class ActionSimple.
     */
    @Test
    public void testGetEntreprise() {
        System.out.println("getEntreprise");
        ActionSimple instance = null;
        String expResult = "";
        String result = instance.getEntreprise();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEntreprise method, of class ActionSimple.
     */
    @Test
    public void testSetEntreprise() {
        System.out.println("setEntreprise");
        String Entreprise = "";
        ActionSimple instance = null;
        instance.setEntreprise(Entreprise);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDomaine method, of class ActionSimple.
     */
    @Test
    public void testGetDomaine() {
        System.out.println("getDomaine");
        ActionSimple instance = null;
        String expResult = "";
        String result = instance.getDomaine();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDomaine method, of class ActionSimple.
     */
    @Test
    public void testSetDomaine() {
        System.out.println("setDomaine");
        String Domaine = "";
        ActionSimple instance = null;
        instance.setDomaine(Domaine);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListeCours method, of class ActionSimple.
     */
    @Test
    public void testGetListeCours() {
        System.out.println("getListeCours");
        ActionSimple instance = null;
        List<Double> expResult = null;
        List<Double> result = instance.getListeCours();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListeCours method, of class ActionSimple.
     */
    @Test
    public void testSetListeCours() {
        System.out.println("setListeCours");
        List<Double> listeCours = null;
        ActionSimple instance = null;
        instance.setListeCours(listeCours);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valeur method, of class ActionSimple.
     */
    @Test
    public void testValeur() {
        System.out.println("valeur");
        int indice = 0;
        ActionSimple instance = null;
        double expResult = 0.0;
        double result = instance.valeur(indice);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dernier_valeur method, of class ActionSimple.
     */
    @Test
    public void testDernier_valeur() {
        System.out.println("dernier_valeur");
        ActionSimple instance = null;
        double expResult = 0.0;
        double result = instance.derniere_valeur();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Update method, of class ActionSimple.
     */
    @Test
    public void testUpdate() {
        System.out.println("Update");
        ActionSimple instance = null;
        instance.Update();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    
}
