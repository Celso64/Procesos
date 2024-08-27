package VariablesDeEntorno;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Ejercicio2 {

    private static final DateTimeFormatter DEFAULT_FORMAT = DateTimeFormatter.ISO_DATE_TIME;

    public static void main(String[] args) {

        LocalDateTime ahora = LocalDateTime.now();
        String formato = System.getenv("DATE_FORMAT");

        if(Objects.isNull(formato)){
            System.out.println(ahora.format(DEFAULT_FORMAT));
        }
        System.out.println(ahora.format(DateTimeFormatter.ofPattern(formato)));
    }
}
