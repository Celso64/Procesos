package utils;

public class HiloNumerado implements Runnable{

    private final Integer numero;

    public HiloNumerado(Integer numero) {
        this.numero = numero;
    }


    @Override
    public void run() {
        System.out.printf("Soy el hilo %d\n", this.numero);
    }
}
