package Hilos;

import utils.HiloBuscador;

import java.util.Objects;

public class Ejercicio2 {

    public static void main(String[] args) {

        String archivo = args[0];
        String dir1 = args[1];
        String dir2 = args[2];

        if(Objects.isNull(archivo) || Objects.isNull(dir1) || Objects.isNull(dir2)) throw new IllegalArgumentException("Argumentos invalidos");

        Thread hiloBuscador1 = new Thread(new HiloBuscador(archivo, dir1));
        Thread hiloBuscador2 = new Thread(new HiloBuscador(archivo, dir2));

        hiloBuscador1.start();
        hiloBuscador2.start();

        try {
            hiloBuscador1.join();
            hiloBuscador2.join();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }


    }
}
