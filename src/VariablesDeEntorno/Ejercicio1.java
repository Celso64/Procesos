package VariablesDeEntorno;

import java.util.Objects;

public class Ejercicio1 {
    public static void main(String[] args) {

        String user = System.getenv("USERNAME");
        String host = System.getenv("HOSTNAME");

        if(Objects.nonNull(user) && Objects.nonNull(host)){
            System.out.println(user + '@' + host);
        } else if (Objects.isNull(user) && Objects.isNull(host)) {
            System.out.println("USERNAME y HOSTNAME no definidos");
        } else if (Objects.isNull(user)){
            System.out.println("USERNAME no definido");
        } else if (Objects.isNull(host)) {
            System.out.println("HOSTNAME no definido");
        }
    }
}
