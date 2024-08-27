package utils;

import java.util.Objects;

public class VerificadorCaracteres {

    private final Integer minimoCaracteres;

    public VerificadorCaracteres(Integer minimoCaracteres) {
        Objects.requireNonNull(minimoCaracteres);
        if(minimoCaracteres < 0 ) throw new IllegalArgumentException("No se puede evaluar valores negativos de caracteres");
        this.minimoCaracteres = minimoCaracteres;
    }

    public Boolean validarCadena(String cadena){
        return cadena.length() >= this.minimoCaracteres;
    }
}
