package utils;

public class HiloBuscador implements Runnable {

    private final String archivo;
    private final String directorio;

    public HiloBuscador(String parametro, String directorio) {
        this.archivo = parametro;
        this.directorio = directorio;
    }


    @Override
    public void run() {
        try {
            Process proceso = new ProcessBuilder()
                    .command("/bin/find", directorio, "-name", archivo)
                    .start();

            Lector lector = new Lector(proceso.getInputStream());

            String salida = lector.procesarConSalida((linea) -> new StringBuilder().append(linea).append("\n").toString());

            if (!salida.isEmpty()) System.out.printf("Encontre '%s' en '%s' \n", archivo, directorio);
            else System.out.printf("No encontre '%s' en '%s' \n", archivo, directorio);

        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
