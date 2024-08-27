package ArchivosES;

import utils.Lector;
import utils.VerificadorCaracteres;

public class Ejercicio2 {

    public static void main(String[] args) {
        final String PARAM_MIN = "--len=";
        Integer longitudMinima = 10;

        if(args[0].startsWith(PARAM_MIN)){
            longitudMinima = Integer.parseInt(args[0].substring(PARAM_MIN.length()));
        }

        Lector lector = new Lector(System.in);

        VerificadorCaracteres verificador = new VerificadorCaracteres(longitudMinima);

        lector.procesar((linea) -> {
            if(verificador.validarCadena(linea)) System.out.println(linea.length());

            else {
                System.err.println(linea.length());
                throw new IllegalArgumentException("Linea demasiado corta.");
            }
        });

        System.exit(lector.codigoSalida());
    }
}
