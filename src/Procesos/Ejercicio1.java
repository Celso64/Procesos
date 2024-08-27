package Procesos;

import utils.Lector;

public class Ejercicio1 {
    public static void main(String[] args) {
        try{
            Process proceso = new ProcessBuilder()
                                    .command("/bin/cat", "/home/carlos/Desktop/hola.txt")
                                    .start();

            Lector lector = new Lector(proceso.getInputStream());
            lector.procesar(System.out::println);
            System.out.println(proceso.waitFor());
        }catch (Exception e){
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
