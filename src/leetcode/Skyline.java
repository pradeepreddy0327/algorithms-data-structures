package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Skyline {

    public static void main(String[] args) {
        Skyline.getSkyline(new int[][] { { 2, 9, 10 }, { 3, 7, 15 },
                { 5, 12, 12 }, { 15, 20, 10 }, { 19, 24, 8 } });

    }

    public static List<List<Integer>> getSkyline(int[][] buildings) {
        Map<Integer, Integer> lMaxMap = new TreeMap<>();
        TreeMap<Integer, List<Integer>> rMaxMap = new TreeMap<>();
        for (int i = 0; i < buildings.length; i++) {
            int li = buildings[i][0];
            int ri = buildings[i][1];
            int hi = buildings[i][2];
            lMaxMap.put(li, hi);
            addToRMap(rMaxMap, ri, hi);
            // rMaxMap.put(ri,hi);
            for (int j = 0; j < i; j++) {
                if (li >= buildings[j][0] && li <= buildings[j][1]
                        && buildings[j][2] > lMaxMap.get(li)) {
                    lMaxMap.put(li, buildings[j][2]);
                }
            }
            for (int j = i + 1; j < buildings.length; j++) {
                if (ri >= buildings[j][0] && ri <= buildings[j][1]) {
                    addToRMap(rMaxMap, ri, buildings[j][2]);
                    // rMaxMap.put(ri,buildings[j][2]);
                }
            }
        }
        System.out.println(lMaxMap);
        System.out.println(rMaxMap);
        return null;
    }

    private static void addToRMap(TreeMap<Integer, List<Integer>> rMaxMap,
            int key,
            int val) {
        List<Integer> list = rMaxMap.get(key);
        if (list == null) {
            list = new ArrayList<Integer>();
        }
        list.add(val);
        Collections.sort(list, (a, b) -> b.compareTo(a));
        if (list.size() > 2) {
            list.subList(0, 2);
        }
        rMaxMap.put(key, list);
    }
}
