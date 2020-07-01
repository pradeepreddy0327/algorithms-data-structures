package hacker.rank;

import java.util.Arrays;

public class MyArrayList<T> {

    public static void main(String[] args) {
        MyArrayList<Integer> obj = new MyArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            obj.add(i);
        }
        System.out.println(obj.size());
        obj.remove(0);
        obj.remove(1);
        System.out.println(obj.size());
        obj.add(25);
        System.out.println(obj);

    }

    private int size;
    private T[] array;

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        array = (T[]) new Object[16];
    }

    /**
     * The size of the list
     * 
     * @return the size
     */
    public synchronized int size() {
        return size;
    }

    /**
     * Gets the object at the index
     * 
     * @param idx
     *            The index
     * @return The object
     * @throws ArrayIndexOutOfBoundsException
     *             if OOB
     */
    public synchronized T get(int idx) {
        return array[idx];
    }

    /**
     * Add the object to the end of the list.
     * 
     * @param o
     *            The object, may be null.
     */
    public synchronized void add(T o) {
        if (size + 1 > array.length) {
            array = Arrays.copyOf(array, size * 2);
        }
        array[size++] = o;
    }

    /**
     * Removes the object at the index
     * 
     * @param idx
     *            The index.
     */
    public synchronized void remove(int idx) {
        if (idx >= size)
            throw new UnsupportedOperationException();
        for (int i = idx + 1; i < size; i++) {
            array[i - 1] = array[i];
        }
        size--;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (int i = 0; i < size; i++) {
            if (i > 0)
                sb.append(", ");
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}
