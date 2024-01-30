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
import java.util.List;
import tp04.metier.Action;
import tp04.metier.ActionSimple;
/**
 *
 * @author Yanpei
 */
public class Marche {
    private List<Action> ActionList;
    private List<Order> OrderList;
    private List<Order> ValidOrderList;
    private List<ActionSimple> ActionSimpleList;
    private Jour j;
    
    private static final Marche instance;
    static{
        instance = new Marche();
    }

    private Marche(List<Action> ActionList, List<Order> OrderList, List<Order> ValidOrderList, List<ActionSimple> ActionSimpleList, Jour j) {
        this.ActionList = ActionList;
        this.OrderList = OrderList;
        this.ValidOrderList = ValidOrderList;
        this.ActionSimpleList = ActionSimpleList;
        this.j = j;
    }
    
    public static Marche getintance(){
        return instance;
    }

    private Marche() {
        
    }
    

    public List<Action> getActionList() {
        return ActionList;
    }

    public void setActionList(List<Action> ActionList) {
        this.ActionList = ActionList;
    }

    public List<Order> getOrderList() {
        return OrderList;
    }

    public void setQrderlist(List<Order> Orderlist) {
        this.OrderList = OrderList;
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
        this.OrderList.add(o);
    }
    
    public void addAction(Action a){
        this.ActionList.add(a);
        if (a instanceof ActionSimple) {
            this.ActionSimpleList.add((ActionSimple) a);
        }
    }
    
    
    
    public void traiterOrdre(Ordre o){
        
    }
}