/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crudexample.model;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import java.util.concurrent.Executors;
/**
 *
 * @author miguelcatalan
 */
public class EventBusFactory {
    private static EventBus eventBus = new AsyncEventBus(Executors.newCachedThreadPool());
  
    public static EventBus getEventBus() {
        return eventBus;
    }
}
