package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// lc 380
public class RandomizedSet {

    private Map<Integer, Integer> map;
    private int[] arr;
    private int nextIndx;
    private Random random;
    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        System.out.println(obj.insert(0));
        System.out.println(obj.insert(1));
        System.out.println(obj.remove(0));
        System.out.println(obj.insert(2));
        System.out.println(obj.remove(1));
        System.out.println(obj.getRandom());
    }

    public RandomizedSet() {
        map = new HashMap<>();
        arr = new int[2];
        random = new Random();
        nextIndx = 0;
    }

    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, nextIndx);
            if (nextIndx == arr.length) {
                arr = Arrays.copyOf(arr, arr.length * 2);
            }
            arr[nextIndx++] = val;
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            nextIndx--;
            arr[map.get(val)] = arr[nextIndx];
            map.put(arr[map.get(val)], map.get(val));
            arr[nextIndx] = 0;
            map.remove(val);
            return true;
        }
        return false;
    }

    public int getRandom() {
        return map.size() > 0 ? arr[random.nextInt(map.size())] : -1;
    }

}
