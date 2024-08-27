package ValorDeRetorno;

public class Ejercicio2 {

    public static void main(String[] args) {
        String cwd = System.getenv("PWD");
        String home = System.getenv("HOME");
        String directorio = cwd.substring(home.length()+1, cwd.length()-1);

        if(directorio.contains("/")) System.exit(1);
        System.exit(0);
    }
}
