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
    }
}
