package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// leetcode 1036
public class EscapePossible {

    public static void main(String[] args) {
        EscapePossible obj = new EscapePossible();
        System.out.println(obj.isEscapePossible(new int[][] {},
                new int[] { 0, 0 }, new int[] { 999999, 999999 }));

    }

    public boolean isEscapePossible(int[][] blocked, int[] source,
            int[] target) {
        int max = 1000000;
        Queue<int[]> sq = new LinkedList<int[]>();
        Queue<int[]> tq = new LinkedList<int[]>();
        Set<String> sourceVisited = new HashSet<>();
        Set<String> targetVisited = new HashSet<>();
        Set<String> blockedSet = getBlockedSet(blocked);
        sq.add(source);
        tq.add(target);
        sourceVisited.add(getString(source));
        targetVisited.add(getString(target));
        int[][] dir = new int[][] { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        while (!sq.isEmpty() && !tq.isEmpty()) {
            int[] s = sq.poll();
            int[] t = tq.poll();
            for (int[] d : dir) {
                int[] adjS = new int[] { s[0] + d[0], s[1] + d[1] };
                if (adjS[0] >= 0 && adjS[0] < max && adjS[1] >= 0
                        && adjS[1] < max
                        && !blockedSet.contains(getString(adjS))) {
                    if (targetVisited.contains(getString(adjS))) {
                        return true;
                    }
                    if (!sourceVisited.contains(getString(adjS))) {
                        sq.add(adjS);
                        sourceVisited.add(getString(adjS));
                    }
                }
                int[] adjT = new int[] { t[0] + d[0], t[1] + d[1] };
                if (adjT[0] >= 0 && adjT[0] < max && adjT[1] >= 0
                        && adjT[1] < max
                        && !blockedSet.contains(getString(adjT))) {
                    if (sourceVisited.contains(getString(adjT))) {
                        return true;
                    }
                    if (!targetVisited.contains(getString(adjT))) {
                        tq.add(adjT);
                        targetVisited.add(getString(adjT));
                    }
                }
            }
            if (Math.max(sourceVisited.size(), targetVisited.size())
                    % 100 == 0) {
                System.out.println(
                        sourceVisited.size() + " :::: " + targetVisited.size());
            }
            if (sourceVisited.size() > 20000) {
                return true;
            }
        }
        return false;
    }

    private Set<String> getBlockedSet(int[][] blocked) {
        Set<String> blockedSet = new HashSet<>();
        for (int[] b : blocked) {
            blockedSet.add(getString(b));
        }
        return blockedSet;
    }

    private String getString(int[] arr) {
        return arr[0] + "_" + arr[1];
    }

}
