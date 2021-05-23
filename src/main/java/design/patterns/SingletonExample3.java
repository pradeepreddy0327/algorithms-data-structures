package design.patterns;

// singleton lazy initialization with double checked locking.
public class SingletonExample3 {

    private static volatile SingletonExample3 INSTANCE;

    private SingletonExample3() {

    }

    public SingletonExample3 getInstance() {
        if (INSTANCE == null) {

            synchronized (SingletonExample3.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingletonExample3();
                }
            }
        }
        return INSTANCE;
    }
}
