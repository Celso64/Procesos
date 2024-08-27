package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

public class Lector {
    private final BufferedReader reader;
    private Integer codigoSalida;

    public Lector(InputStream reader) {
        this.reader = new BufferedReader(new InputStreamReader(reader));
        this.codigoSalida = 0;
    }

    public void procesar(Consumer<String> procesadorLinea){
        try {
            String linea;
            while (Objects.nonNull(linea = this.reader.readLine())) {
                try{
                    procesadorLinea.accept(linea);
                }catch (Exception e){
                    System.err.println(e.getMessage());
                    codigoSalida++;
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            codigoSalida++;
        }
    }

    public String procesarConSalida(Function<String, String> procesadorLinea){
        StringBuffer sb = new StringBuffer();
        try {
            String linea;
            while (Objects.nonNull(linea = this.reader.readLine())) {
                try{
                    sb.append(procesadorLinea.apply(linea));
                }catch (Exception e){
                    System.err.println(e.getMessage());
                    codigoSalida++;
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            codigoSalida++;
        }
        return sb.toString();
    }

    public Integer codigoSalida() {
        return codigoSalida;
    }
}
