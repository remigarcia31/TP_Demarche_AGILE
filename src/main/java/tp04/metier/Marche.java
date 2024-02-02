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


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
/**
 *
 * @author Yanpei
 */
public class Marche {
    private Map<String,Integer> ActionQteMap;
    private Map<String,Double> ActionPrixMap;
    private List<Ordre> OrderAchatList;
    private List<Ordre> OrderVenteList;
    private List<Ordre> ValidOrderList;
    private List<ActionSimple> ActionSimpleList;
    private List<ActionComposee> ActionComposeeList;
    private int jour;
    
    private static final Marche instance;
    static{
        instance = new Marche();
    }

    public Marche()
    {
        this.ActionQteMap = new HashMap<>();
        this.ActionPrixMap = new HashMap<>();
        this.OrderAchatList = new ArrayList<>();
        this.OrderVenteList = new ArrayList<>();
        this.ValidOrderList = new ArrayList<>();
        this.ActionSimpleList = new ArrayList<>();
        this.ActionComposeeList = new ArrayList<>();
        this.jour = 0;
    }
    
    public static Marche getInstance(){
        return instance;
    }

    public Map<String, Integer> getActionQteMap() {
        return ActionQteMap;
    }

    public void setActionQteMap(Map<String, Integer> ActionQteMap) {
        this.ActionQteMap = ActionQteMap;
    }

    public Map<String, Double> getActionPrixMap() {
        return ActionPrixMap;
    }

    public void setActionPrixMap(Map<String, Double> ActionPrixMap) {
        this.ActionPrixMap = ActionPrixMap;
    }

    public List<Ordre> getOrderAchatList() {
        return OrderAchatList;
    }

    public void setOrderAchatList(List<Ordre> OrderAchatList) {
        this.OrderAchatList = OrderAchatList;
    }

    public List<Ordre> getOrderVenteList() {
        return OrderVenteList;
    }

    public void setOrderVenteList(List<Ordre> OrderVenteList) {
        this.OrderVenteList = OrderVenteList;
    }

    public List<ActionComposee> getActionComposeeList() {
        return ActionComposeeList;
    }

    public void setActionComposeeList(List<ActionComposee> ActionComposeeList) {
        this.ActionComposeeList = ActionComposeeList;
    }

    public List<Ordre> getValidOrderList() {
        return ValidOrderList;
    }

    public void setValidOrderList(List<Ordre> ValidOrderList) {
        this.ValidOrderList = ValidOrderList;
    }

    public List<ActionSimple> getActionSimpleList() {
        return ActionSimpleList;
    }

    public void setActionSimpleList(List<ActionSimple> ActionSimpleList) {
        this.ActionSimpleList = ActionSimpleList;
    }

    public int getJ() {
        return jour;
    }

    public void setJ(int j) {
        this.jour = j;
    }
    
    public void addOrder(Ordre o){
        if (o.getEstAchat()){
            this.OrderAchatList.add(o);
        }
        else {
            this.OrderVenteList.add(o);
        }
    }
    
    public void addAction(Action a, int q){
        this.ActionQteMap.put(a.getLibelle(), q);
        this.ActionPrixMap.put(a.getLibelle(), a.derniere_valeur());
        if (a instanceof ActionSimple actionSimple) {
            this.ActionSimpleList.add(actionSimple);
        }
        if (a instanceof ActionComposee actionComposee) {
            this.ActionComposeeList.add(actionComposee);
        }
    }
    
    public void EchangeAction(String libelle, int q){
        this.ActionQteMap.put(libelle, this.ActionQteMap.get(libelle)+q);
    }
    
    public void updatePrix(){
        this.jour++;
        for (ActionSimple as : ActionSimpleList){
        as.Update();
        this.ActionPrixMap.put(as.getLibelle(),as.derniere_valeur());
    } 
        for (ActionComposee as : ActionComposeeList){
        as.Update();
        this.ActionPrixMap.put(as.getLibelle(),as.derniere_valeur());
    } 
    }
    
    public void validerOrdre(Ordre o){
        if (o.getEstAchat()){
            int q = o.getQuantite();
            double delta = q * this.ActionPrixMap.get(o.getAction().getLibelle());
            o.getPortefeuille().updateSolde(-delta);
            o.getPortefeuille().updateQteAction(o.getAction(),q);
            this.EchangeAction(o.getAction().getLibelle() , -o.getQuantite());
            this.ValidOrderList.add(o);
            this.OrderAchatList.remove(o);
            // attendre modification dans la classe portefeuille
        }
        else{
            int q = o.getQuantite();
            double delta=q*ActionPrixMap.get(o.getAction().getLibelle());
            o.getPortefeuille().updateSolde(delta);
            o.getPortefeuille().updateQteAction(o.getAction(),-q);
            this.EchangeAction(o.getAction().getLibelle(), o.getQuantite());
            this.ValidOrderList.add(o);
            this.OrderAchatList.remove(o);
        }
    }
    
    public void traiterOrdre(Ordre o){
        if (o.getEstAuMarche()){
            this.validerOrdre(o);
        }
        else{
            if (o.getEstAchat()){
                if (o.getPrixUnit() <= this.ActionPrixMap.get(o.getAction().getLibelle()))
                {
                    this.validerOrdre(o);
                }
                else if (o.getDateCloture()==this.jour){
                    this.ValidOrderList.add(o);
                    this.OrderAchatList.remove(o);
                    o.getPortefeuille().updateSolde(o.getQuantite()*o.getPrixUnit());}
            }
            else{
                if (o.getPrixUnit() >= this.ActionPrixMap.get(o.getAction().getLibelle()))
                {
                    this.validerOrdre(o);
                }
                else if (o.getDateCloture() == this.jour){
                    this.ValidOrderList.add(o);
                    this.OrderAchatList.remove(o);
                    o.getPortefeuille().updateQteAction(o.getAction(),o.getQuantite());}
            }
            }
        }
    public void traiterOrdres(){
        for (Ordre o : this.OrderVenteList){
            this.validerOrdre(o);
        } 
        for (Ordre o : this.OrderAchatList){
            this.validerOrdre(o);
        } 
    }
        
    }
    
   
