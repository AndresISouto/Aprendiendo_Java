package com.liceolapaz.daw.ais;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask; // future a secas tiene que ir con un Executor para que no haga falta crear un hilo en si,
// y usar una cantidad predefinida de estos

public class Future_ejemplo {
    public static void main(String[] args)  {
        //creamos un array de futuros vaolores
        FutureTask[] valoresFuturos = new FutureTask[5];

        for (int i = 0; i < 5; i++) {
            Callable_Ejemplo llamada = new Callable_Ejemplo();

            valoresFuturos[i] = new FutureTask<>(llamada);

            Thread hilo = new Thread(valoresFuturos[i]);
            hilo.start();
        }

        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(valoresFuturos[i].get());
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            } catch (ExecutionException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
