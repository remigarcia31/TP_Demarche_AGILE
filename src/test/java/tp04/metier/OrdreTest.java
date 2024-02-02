/*
 * Copyright 2024 hugob.
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

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 * @author hugob
 */
public class OrdreTest {

    @Test
    public void testGetQuantiteOrdre() {
        ActionSimple action = new ActionSimple("TestAction");
        Portefeuille portefeuille = new Portefeuille(1000.0);
        Ordre ordre = new Ordre(true, action, 100.0, 10, 20240101, 
                portefeuille);

        assertEquals(10, ordre.getQuantite());
    }

    @Test
    public void testModificationStatutOrdre() {
        ActionSimple action = new ActionSimple("TestAction");
        Portefeuille portefeuille = new Portefeuille(1000.0);
        Ordre ordre = new Ordre(true, action, 100.0, 10, 20240101, 
                portefeuille);

        ordre.setStatut(Ordre.Statut.VALIDER);
        assertEquals(Ordre.Statut.VALIDER, ordre.getStatut(), "Le statut de "
                + "l'ordre devrait être modifié à VALIDER");
    }

    @Test
    public void testAffichageToString() {
        ActionSimple action = new ActionSimple("TestAction");
        Portefeuille portefeuille = new Portefeuille(1000.0);
        Ordre ordre = new Ordre(true, action, 100.0, 10, 20240101, 
                portefeuille);

        String expected = "Achat de TestAction\nStatut de l'ordre : "
                + "OUVERT\nMarché/limit ?    : Limit\nPrix Unitaire     "
                + ": 100.0\nQuantité          : 10\nDate ouverture    : 0"
                + "\nDate cloture      : 20240101";
        assertEquals(expected, ordre.toString(), "La représentation textuelle "
                + "de l'ordre ne correspond pas à l'attendu");
    }

    @Test
    public void testModificationPrixUnitaire() {
        ActionSimple action = new ActionSimple("TestAction");
        Portefeuille portefeuille = new Portefeuille(1000.0);
        Ordre ordre = new Ordre(true, action, 100.0, 10, 20240101, 
                portefeuille);

        ordre.setPrixUnit(150);
        assertEquals(150.0, ordre.getPrixUnit(), 0.001, "Le prix unitaire "
                + "de l'ordre devrait être modifié à 150.0");
    }

    @Test
    public void testModificationDateOuverture() {
        ActionSimple action = new ActionSimple("TestAction");
        Portefeuille portefeuille = new Portefeuille(1000.0);
        Ordre ordre = new Ordre(true, action, 100.0, 10, 20240101, 
                portefeuille);

        ordre.setDateOuverture(20240102);
        assertEquals(20240102, ordre.getDateOuverture());
    }

    @Test
    public void testModificationDateCloture() {
        ActionSimple action = new ActionSimple("TestAction");
        Portefeuille portefeuille = new Portefeuille(1000.0);
        Ordre ordre = new Ordre(true, action, 100.0, 10, 20240101, 
                portefeuille);

        ordre.setDateCloture(20240102);
        assertEquals(20240102, ordre.getDateCloture());
    }

    @Test
    public void testQuantitéInvalide() {
        ActionSimple action = new ActionSimple("TestAction");
        Portefeuille portefeuille = new Portefeuille(1000.0);
        Ordre ordre = new Ordre(true, action, 100.0, 10, 20240101, 
                portefeuille);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        ordre.setQuantite(-10);
        });

        String expectedMessage = "La quantité ne peut pas être négative";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

}
