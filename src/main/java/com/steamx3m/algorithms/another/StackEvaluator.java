package com.steamx3m.algorithms.another;

import com.steamx3m.algorithms.structures.Stack;

import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

/**
 * Вычисление математических выражений на основе стекового алгоритма Дейкстры
 */
public class StackEvaluator {

    /**
     * обрабатываемые операции
     */
    private static final Set<String> OPERATIONS = Set.of("+", "-", "*", "/");

    /**
     * мапа, где ключ - операция, значения - функция которая применяется к аргументам
     */
    private static final Map<String, BiFunction<Double, Double, Double>> OPERATION_MAP = Map.of(
            "+", (v1, v2) -> v1 + v2,
            "-", (v1, v2) -> v1 - v2,
            "*", (v1, v2) -> v1 * v2,
            "/", (v1, v2) -> v1 / v2
    );

    /**
     * стек операций
     */
    private final Stack<String> ops = new Stack<>(String.class);
    /**
     * стек значений
     */
    private final Stack<Double> vals = new Stack<>(Double.class);

    /**
     * Вычислить значение
     *
     * @param line мат.выражение в виде строки.
     *             Алгортим накладывает ограничения на выходные строки.
     *             Операции должны быть обернуты в скобки, например ( 1 + 1 ) вместо 1+1
     *             Так же обязательны пробелы между частями выражения,
     *             по пробелам входная строка бъется на элементы
     * @return результат вычисления
     */
    public double compute(String line) {
        if (line == null || line.isEmpty()) {
            throw new RuntimeException("Line should not be empty");
        }

        String[] elements = line.split("\\ ");

        for (String element : elements) {
            if (OPERATIONS.contains(element)) {
                ops.push(element);
                continue;
            }

            // пропускаем все знаки (
            if (element.equals("(")) {
                continue;
            }

            if (element.equals(")")) {
                String operation = ops.pop();
                double val = vals.pop();
                double result = OPERATION_MAP.get(operation).apply(vals.pop(), val);
                vals.push(result);
                continue;
            }

            // если не сработал ни один блок-if выше, то это значит что element число
            vals.push(Double.parseDouble(element));

        }

        return vals.pop();
    }


}
