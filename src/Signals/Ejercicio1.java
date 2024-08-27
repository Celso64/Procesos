package Signals;

import sun.misc.Signal;
import sun.misc.SignalHandler;
import utils.Lector;

public class Ejercicio1 {
    public static void main(String[] args) {

        Lector lector = new Lector(System.in);

        SignalHandler sh = s -> System.out.printf("%d -- %s%n", s.getNumber(), s.getName());

        Signal.handle(new Signal("INT"), sh);
        Signal.handle(new Signal("TERM"), sh);

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
