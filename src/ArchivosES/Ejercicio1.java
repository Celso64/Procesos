package ArchivosES;

import utils.Lector;
import utils.OperacionMatematica;

public class Ejercicio1 {

    public static void main(String[] args) {

        Lector lector = new Lector(System.in);

        lector.procesar((linea) -> {
            var operacion = new OperacionMatematica(linea);
            System.out.println( linea + " = " + operacion.calcular());
        });

        System.exit(lector.codigoSalida());
    }
}
