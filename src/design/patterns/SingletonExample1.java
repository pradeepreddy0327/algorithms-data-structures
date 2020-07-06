package design.patterns;

//creating Singleton object with Eager initialization.
public class SingletonExample1 {

    private SingletonExample1() {

    }

    // creating Singleton object with Eager initialization.
    private static SingletonExample1 INSTANCE = new SingletonExample1();

    public static SingletonExample1 getInstance() {
        return INSTANCE;
    }
}
