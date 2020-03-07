package PassCodeNoArg;

 /*
    1. An interface with single method a.k.a FunctionalInterface
    2. A class that implements the interface
    3. A class that has a method that takes argument as Interface type
 */

@FunctionalInterface
interface Exec {
    // has only one method - so it can be declared with @FunctionalInterface annotation post Java 8
    void performExecution();
}

//FunctionalInterface with Generic type -- similar to Consumer<T> interface; can accept type as input, but doesn't return anything
@FunctionalInterface
interface TypedInterface<E> {
    void method(E e);
}

//FunctionalInterface with Generic type -- similar to BiConsumer<T, U> interface
@FunctionalInterface
interface TwoArgInterface<E, T> {
    void method(E e, T t);
}

class ExecuteImpl implements Exec {
    // usual way of implementing an interface using implements keyword; performExecution() is overridden here
    @Override
    public void performExecution() {
        System.out.println("Performing Execution -- Interface implements style");
    }
}

class Execute {
    // passing code as an argument, not implementing the interface (no use of implements keyword and no @Override
    void exec(Exec exec){
        exec.performExecution();
    }
}

public class PassCodeNoArg {
    public static void main(String[] args) {

        // calling the overridden method using object
        ExecuteImpl executeImpl = new ExecuteImpl();
        executeImpl.performExecution();

        Execute obj = new Execute();
        obj.exec(executeImpl);

        // anonymous inner class way of implementing the execute(Exec exec) method
        Execute execute = new Execute();
        execute.exec(new Exec() {
            @Override
            public void performExecution() {
                System.out.println("Performing Execution -- Anonymous Inner class style");
            }
        });

        // lambda class way of implementing the execute(Exec exec) method
        Execute executeLambda = new Execute();
        executeLambda.exec(() -> System.out.println("Performing Execution -- Java8 Lambda style"));

        // String type as parameter
        TypedInterface<String> stringTypedInterface = (name) -> System.out.println("String UpperCase: " + name.toUpperCase() + " " + name.getClass());
        stringTypedInterface.method("StringName");

        // Integer type as parameter
        TypedInterface<Integer> integerTypedInterface = (num) -> System.out.println("Integer : " + num + " " + num.getClass());
        integerTypedInterface.method(12);

        // String, String type as parameter
        TwoArgInterface<String, String> stringTwoArgInterface = (a, b) -> System.out.println("String,String lowercase : " + a.concat(b).toLowerCase());
        stringTwoArgInterface.method("HELLO ", "WORLD");

        // String, String type as parameter
        TwoArgInterface<Integer, Integer> integerTwoArgInterface = (a, b) -> System.out.println("Integer,Integer : " + (a+b));
        integerTwoArgInterface.method(11 , 12);
    }
}
