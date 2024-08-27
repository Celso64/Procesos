package Argumentos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Ejercicio1Y2 {

    private static final DateTimeFormatter DEFAULT_FORMAT = DateTimeFormatter.ISO_DATE_TIME;
    
    public static void main(String[] args) {

        LocalDateTime ahora = LocalDateTime.now();
        String formato = System.getenv("DATE_FORMAT");

        if ((args.length > 0) && args[0].equals("-f")) {
            try {
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(args[1]);
                System.out.println(ahora.format(dateTimeFormatter));
                System.exit(0);
            }catch (IllegalArgumentException e){
                System.err.println(e.getMessage());
                System.exit(1);
            }
        } else if (Objects.nonNull(formato)) {
            System.out.println(ahora.format(DateTimeFormatter.ofPattern(formato)));
            System.exit(0);
        }

        if ((args.length > 0) && args[0].equals("-h")) {
            System.out.println("Este programa muestra la hora y la fecha actual en formato ISO. Acepta:\n\t" +
                    "-f [FORMAT]\tPara definir el formato en que se mostrara la fecha y la hora\n\t" +
                    "-h\tPara ver la ayuda.");
            System.exit(0);
        }

        System.out.println(ahora.format(DateTimeFormatter.ISO_DATE));
        System.exit(0);
    }
}
