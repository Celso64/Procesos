package utils;

import java.util.*;
import java.util.function.BiFunction;

public class OperacionMatematica {

    private static final Map<String, BiFunction<Integer, Integer, Double>> OPERACIONES = Map.of(
            "+", ((a, b) -> a + b.doubleValue()),
            "-", ((a, b) -> a - b.doubleValue()),
            "*", (a, b) -> a * b.doubleValue(),
            "/", (a, b) -> a / b.doubleValue()
    );

    private final Integer op1, op2;
    private final String operador;


    public OperacionMatematica(String operacion) {

        List<String> simbolos = new ArrayList<>(Arrays.stream(operacion.split("\s")).toList());

        if (simbolos.size() != 3) throw new IllegalArgumentException("Los argumentos no son validos");

        Set<String> operadores = OPERACIONES.keySet();
        List<String> ops = simbolos.stream().filter(operadores::contains).toList();

        if (ops.size() != 1) throw new IllegalArgumentException("Operador Invalido");

        String op = ops.get(0);
        simbolos.removeIf(s -> s.equals(op));
        this.operador = op;

        try {
            this.op1 = Integer.parseInt(simbolos.get(0));
            this.op2 = Integer.parseInt(simbolos.get(1));
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("Operandos No Validos");
        }
    }

    public Double calcular(){
        return OPERACIONES.get(this.operador).apply(this.op1, this.op2);
    }

}
