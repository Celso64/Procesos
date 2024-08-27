package Signals;

import sun.misc.Signal;
import sun.misc.SignalHandler;
import utils.Lector;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Objects;

public class Ejercicio2 {
    public static void main(String[] args) {

        if(Objects.isNull(args[0])) System.exit(1);

        String path = System.getenv("PWD");
        String archivo = args[0];

        Lector lector = null;
        try {
            lector = new Lector(new FileInputStream(new File(path+"/"+archivo)));
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        SignalHandler sh = s -> {
            System.err.println("FIN");
            System.exit(s.getNumber());
        };

        Signal.handle(new Signal("INT"), sh);
        Signal.handle(new Signal("TERM"), sh);
        Signal.handle(new Signal("USR1"), s -> System.out.println(s.getNumber()));

        lector.procesar((linea) -> {
            try {
                Thread.sleep(1_000);
                System.out.println(linea);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.exit(lector.codigoSalida());
    }
}
