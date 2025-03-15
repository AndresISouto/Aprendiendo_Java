package com.liceolapaz.daw.ais;

import java.util.concurrent.RecursiveTask;

class Prueba_Forks extends RecursiveTask<Integer> {
    final int n;
    Prueba_Forks(int n) { this.n = n; }
    public Integer compute() {
        if (n <= 1)
            return n;
        Prueba_Forks f1 = new Prueba_Forks(n - 1);
        f1.fork();
        Prueba_Forks f2 = new Prueba_Forks(n - 2);
        f2.fork();
        return f2.join() + f1.join();
    }


}