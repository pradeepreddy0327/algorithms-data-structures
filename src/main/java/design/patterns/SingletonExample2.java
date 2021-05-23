package design.patterns;

// lazy initialization with Holder pattern.
public class SingletonExample2 {

    private SingletonExample2() {

    }

    static SingletonExample2 getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        static SingletonExample2 INSTANCE = new SingletonExample2();
    }

}
