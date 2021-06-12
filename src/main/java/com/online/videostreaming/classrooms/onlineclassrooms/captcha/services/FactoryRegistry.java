package com.online.videostreaming.classrooms.onlineclassrooms.captcha.services;



public interface FactoryRegistry<S, F> {

    FactoryRegistry<S, F> registerFactory(S strategy, F factory);

    F getFactory(S strategy);
}
