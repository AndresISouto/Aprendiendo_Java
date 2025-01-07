package com.liceolapaz.daw.ais;

import java.util.Random;
import java.util.concurrent.Callable;

public class Callable_Ejemplo implements Callable {

    @Override
    public Object call() throws Exception {
        Random random = new Random();
        Integer numero = random.nextInt(5);
        Thread.sleep(1000);
        return numero;
    }
}
