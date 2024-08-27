package Hilos;

import utils.HiloNumerado;

public class Ejercicio1 {
    public static void main(String[] args) throws InterruptedException {

        var hilo1 = new Thread(new HiloNumerado(1));
        var hilo2 = new Thread(new HiloNumerado(2));

        hilo1.start();
        hilo2.start();

        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
