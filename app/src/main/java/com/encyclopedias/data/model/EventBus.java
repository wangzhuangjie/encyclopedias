package com.encyclopedias.data.model;

import com.squareup.otto.Bus;

import java.util.ArrayList;

public class EventBus extends Bus {
    private ArrayList registeredObjects = new ArrayList<>();

    @Override
    public void register(Object object) {
        if (!registeredObjects.contains(object)) {
            registeredObjects.add(object);
            super.register(object);
        }
    }

    @Override
    public void unregister(Object object) {
        if (registeredObjects.contains(object)) {
            registeredObjects.remove(object);
            super.unregister(object);
        }
    }
}