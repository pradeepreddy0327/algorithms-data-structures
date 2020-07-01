package hacker.rank;

public class ThreadTest {
    private boolean satisfied = false;

    public synchronized void first() {
        satisfied = true;
        notifyAll();
    }

    public synchronized void second() {
        while (isSatisfied()) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public boolean isSatisfied() {
        return satisfied;
    }

    public static void main(final String[] args) {
        final ThreadTest b = new ThreadTest();
        (new Thread(new Runnable() {
            @Override
            public void run() {
                b.second();
            }
        })).start();

        (new Thread(new Runnable() {
            @Override
            public void run() {
                b.first();
            }
        })).start();
    }
}
