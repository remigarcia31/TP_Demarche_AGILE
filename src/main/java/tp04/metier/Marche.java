package tp04.metier;
/*
 * Copyright 2024 Yanpei.
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


import java.util.HashMap;
import java.util.Map;
import java.util.List;
import tp04.metier.Action;
import tp04.metier.ActionSimple;
/**
 *
 * @author Yanpei
 */
public class Marche {
    private Map<String,Integer> ActionQteMap;
    private Map<String,Integer> ActionPrixMap;
    private List<Order> OrderAchatList;
    private List<Order> OrderVenteList;
    private List<Order> ValidOrderList;
    private List<ActionSimple> ActionSimpleList;
    private List<ActionComposee> ActionComposeeList;
    private Jour j;
    
    private static final Marche instance;
    static{
        instance = new Marche();
    }

    public Marche(Map<String, Integer> ActionQteMap, Map<String, Integer> ActionPrixMap, List<Order> OrderAchatList, List<Order> OrderVenteList, List<Order> ValidOrderList, List<ActionSimple> ActionSimpleList, List<ActionComposee> ActionComposeeList, Jour j) {
        this.ActionQteMap = ActionQteMap;
        this.ActionPrixMap = ActionPrixMap;
        this.OrderAchatList = OrderAchatList;
        this.OrderVenteList = OrderVenteList;
        this.ValidOrderList = ValidOrderList;
        this.ActionSimpleList = ActionSimpleList;
        this.ActionComposeeList = ActionComposeeList;
        this.j = j;
    }


    
    public static Marche getintance(){
        return instance;
    }

    private Marche() {
        
    }

    public Map<String, Integer> getActionQteMap() {
        return ActionQteMap;
    }

    public void setActionQteMap(Map<String, Integer> ActionQteMap) {
        this.ActionQteMap = ActionQteMap;
    }

    public Map<String, Integer> getActionPrixMap() {
        return ActionPrixMap;
    }

    public void setActionPrixMap(Map<String, Integer> ActionPrixMap) {
        this.ActionPrixMap = ActionPrixMap;
    }

    public List<Order> getOrderAchatList() {
        return OrderAchatList;
    }

    public void setOrderAchatList(List<Order> OrderAchatList) {
        this.OrderAchatList = OrderAchatList;
    }

    public List<Order> getOrderVenteList() {
        return OrderVenteList;
    }

    public void setOrderVenteList(List<Order> OrderVenteList) {
        this.OrderVenteList = OrderVenteList;
    }

    public List<ActionComposee> getActionComposeeList() {
        return ActionComposeeList;
    }

    public void setActionComposeeList(List<ActionComposee> ActionComposeeList) {
        this.ActionComposeeList = ActionComposeeList;
    }

    public List<Order> getValidOrderList() {
        return ValidOrderList;
    }

    public void setValidOrderList(List<Order> ValidOrderList) {
        this.ValidOrderList = ValidOrderList;
    }

    public List<ActionSimple> getActionSimpleList() {
        return ActionSimpleList;
    }

    public void setActionSimpleList(List<ActionSimple> ActionSimpleList) {
        this.ActionSimpleList = ActionSimpleList;
    }

    public Jour getJ() {
        return j;
    }

    public void setJ(Jour j) {
        this.j = j;
    }
    
    public void addOrder(Order o){
        if (o.estAchat){
            this.OrderAchatList.add(o)
        }
        else {
            this.OrderVenteList.add(o)
        }
    }
    
    public void addAction(Action a, int q){
        this.ActionQteMap.put(a.getLibelle(), q);
        this.ActionPrixMap.put(a.getLibelle(), a.dernier_valeur());
        if (a instanceof ActionSimple actionSimple) {
            this.ActionSimpleList.add(actionSimple);
        }
        if (a instanceof ActionComposee actionComposee) {
            this.ActionComposeeList.add(actionComposee);
        }
    }
    
    public void EchangeAction(Action a, int q){
        this.ActionQteMap.put(a, this.ActionQteMap.get(a)+q);
    }
    
    public void UpdatePrix(){
        for (ActionSimple as : ActionSimpleList){
        as.Update();
    } 
        for (ActionComposee as : ActionComposeeList){
        as.Update();
    } 
    }
    
    public void validerOrdre(Ordre o){
        if (o.estAchat){
            double m=o.portefeuille.obtenirSolde();
            int q = o.portefeuille.obtenirMapAction(o.getAction);
            double delta=o.getQuantite()*ActionPrixMap(o.getAction().getLibelle());
            o.portefeuille.definirSolde(m-delta);
            o.portefeuille.definirMapAction();
            // attendre modification dans la classe portefeuille
        }
        else{
            double m=o.portefeuille.obtenirSolde();
            
            double delta=o.getQuantite()*ActionPrixMap(o.getAction().getLibelle());
            o.portefeuille.definirSolde(m+delta);
            o.portefeuille.definirSolde(m+delta);
        }
    }
    
    public void traiterOrdre(Ordre o){
        if (o.estAuMarche){
            this.validerOrdre(o);
        }
        else{
            if (o.estAchat){
                if Action
            }
        }
    }
    
   
}