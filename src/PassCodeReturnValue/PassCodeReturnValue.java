package PassCodeReturnValue;

import java.util.function.BiFunction;

@FunctionalInterface
interface AddExecutable {
    int execute(int a, int b);
}

interface ModuloExecutable {
    int executeModulo(int a, int b);
}

public class PassCodeReturnValue {
    public static void main(String[] args) {

        // 2 int parameters, return type int -- lambda
        // Passing code a + b
        AddExecutable addExecutableLambda = (a,b) -> a + b;
        System.out.println(addExecutableLambda.execute(10,20));

        // 2 int parameters, return type int -- anonymous inner class
        AddExecutable addExecutable = new AddExecutable() {
            @Override
            public int execute(int a, int b) {
                return a + b;
            }
        };
        System.out.println(addExecutable.execute(10,20));

        // 2 int parameters, return type int -- lambda; interface NOT declared as FunctionalInterface
        // Passing code a % b
        ModuloExecutable moduloExecutable = (i, j) -> i % j;
        System.out.println(moduloExecutable.executeModulo(5,3));

        // BiFunction is an Out-Of-the-Box FunctionalInterface provided by Java to support 2 parameters and return a value
        BiFunction<Integer, Integer, Integer> addFunction = (a, b) -> a + b;
        System.out.println(addFunction.apply(10,20));
    }
}