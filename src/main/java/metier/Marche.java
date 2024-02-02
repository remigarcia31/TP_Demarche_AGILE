package metier;
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


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
/**
 *
 * @author Yanpei
 */
public class Marche {
    private Map<String,Integer> actionQteMap;
    private Map<String,Double> actionPrixMap;
    private List<Ordre> orderAchatList;
    private List<Ordre> orderVenteList;
    private List<Ordre> validOrderList;
    private List<ActionSimple> actionSimpleList;
    private List<ActionComposee> actionComposeeList;
    private int jour;
    
    private static final Marche instance;
    static{
        instance = new Marche();
    }

    public Marche()
    {
        this.actionQteMap = new HashMap<>();
        this.actionPrixMap = new HashMap<>();
        this.orderAchatList = new ArrayList<>();
        this.orderVenteList = new ArrayList<>();
        this.validOrderList = new ArrayList<>();
        this.actionSimpleList = new ArrayList<>();
        this.actionComposeeList = new ArrayList<>();
        this.jour = 0;
    }
    
    public static Marche getInstance(){
        return instance;
    }

    public Map<String, Integer> getActionQteMap() {
        return actionQteMap;
    }

    public void setActionQteMap(Map<String, Integer> ActionQteMap) {
        this.actionQteMap = ActionQteMap;
    }

    public Map<String, Double> getActionPrixMap() {
        return actionPrixMap;
    }

    public void setActionPrixMap(Map<String, Double> ActionPrixMap) {
        this.actionPrixMap = ActionPrixMap;
    }

    public List<Ordre> getOrderAchatList() {
        return orderAchatList;
    }

    public void setOrderAchatList(List<Ordre> OrderAchatList) {
        this.orderAchatList = OrderAchatList;
    }

    public List<Ordre> getOrderVenteList() {
        return orderVenteList;
    }

    public void setOrderVenteList(List<Ordre> OrderVenteList) {
        this.orderVenteList = OrderVenteList;
    }

    public List<ActionComposee> getActionComposeeList() {
        return actionComposeeList;
    }

    public void setActionComposeeList(List<ActionComposee> ActionComposeeList) {
        this.actionComposeeList = ActionComposeeList;
    }

    public List<Ordre> getValidOrderList() {
        return validOrderList;
    }

    public void setValidOrderList(List<Ordre> ValidOrderList) {
        this.validOrderList = ValidOrderList;
    }

    public List<ActionSimple> getActionSimpleList() {
        return actionSimpleList;
    }

    public void setActionSimpleList(List<ActionSimple> ActionSimpleList) {
        this.actionSimpleList = ActionSimpleList;
    }

    public int getJ() {
        return jour;
    }

    public void setJ(int j) {
        this.jour = j;
    }
    
    public void addOrder(Ordre o){
        if (o.getEstAchat()){
            this.orderAchatList.add(o);
        }
        else {
            this.orderVenteList.add(o);
        }
    }
    
    public void addAction(Action a, int q){
        this.actionQteMap.put(a.getLibelle(), q);
        this.actionPrixMap.put(a.getLibelle(), a.derniereValeur());
        if (a instanceof ActionSimple actionSimple) {
            this.actionSimpleList.add(actionSimple);
        }
        if (a instanceof ActionComposee actionComposee) {
            this.actionComposeeList.add(actionComposee);
        }
    }
    
    public void EchangeAction(String libelle, int q){
        this.actionQteMap.put(libelle, this.actionQteMap.get(libelle)+q);
    }
    
    public void updatePrix(){
        this.jour++;
        for (ActionSimple as : actionSimpleList){
        as.update();
        this.actionPrixMap.put(as.getLibelle(),as.derniereValeur());
    } 
        for (ActionComposee as : actionComposeeList){
        as.update();
        this.actionPrixMap.put(as.getLibelle(),as.derniereValeur());
    } 
    }
    
    public void validerOrdre(Ordre o){
        if (o.getEstAchat()){
            int q = o.getQuantite();
            double delta = q * this.actionPrixMap.get(o.getAction().getLibelle());
            o.getPortefeuille().updateSolde(-delta);
            o.getPortefeuille().updateQteAction(o.getAction(),q);
            this.EchangeAction(o.getAction().getLibelle() , -o.getQuantite());
            this.validOrderList.add(o);
            this.orderAchatList.remove(o);
            // attendre modification dans la classe portefeuille
        }
        else{
            int q = o.getQuantite();
            double delta=q*actionPrixMap.get(o.getAction().getLibelle());
            o.getPortefeuille().updateSolde(delta);
            o.getPortefeuille().updateQteAction(o.getAction(),-q);
            this.EchangeAction(o.getAction().getLibelle(), o.getQuantite());
            this.validOrderList.add(o);
            this.orderAchatList.remove(o);
        }
    }
    
    public void traiterOrdre(Ordre o){
        if (o.getEstAuMarche()){
            this.validerOrdre(o);
        }
        else{
            if (o.getEstAchat()){
                if (o.getPrixUnit() <= this.actionPrixMap.get(o.getAction().getLibelle()))
                {
                    this.validerOrdre(o);
                }
                else if (o.getDateCloture()==this.jour){
                    this.validOrderList.add(o);
                    this.orderAchatList.remove(o);
                    o.getPortefeuille().updateSolde(o.getQuantite()*o.getPrixUnit());}
            }
            else{
                if (o.getPrixUnit() >= this.actionPrixMap.get(o.getAction().getLibelle()))
                {
                    this.validerOrdre(o);
                }
                else if (o.getDateCloture() == this.jour){
                    this.validOrderList.add(o);
                    this.orderAchatList.remove(o);
                    o.getPortefeuille().updateQteAction(o.getAction(),o.getQuantite());}
            }
            }
        }
    public void traiterOrdres(){
        for (Ordre o : this.orderVenteList){
            this.validerOrdre(o);
        } 
        for (Ordre o : this.orderAchatList){
            this.validerOrdre(o);
        } 
    }
        
}