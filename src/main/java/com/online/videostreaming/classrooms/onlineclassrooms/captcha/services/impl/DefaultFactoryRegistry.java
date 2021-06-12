package com.online.videostreaming.classrooms.onlineclassrooms.captcha.services.impl;



import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import com.online.videostreaming.classrooms.onlineclassrooms.captcha.services.FactoryRegistry;


public class DefaultFactoryRegistry<S, F> implements FactoryRegistry<S, F> {

    private final Map<S, F> registry = new HashMap<>();
    private final transient ReentrantLock writeLock = new ReentrantLock();

    @Override
    public FactoryRegistry<S, F> registerFactory(S strategy, F factory) {
        writeLock.lock();
        try {
            registry.put(strategy, factory);
            return this;
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public F getFactory(S strategy) {
        return registry.get(strategy);
    }
}
