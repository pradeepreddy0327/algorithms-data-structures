package slidingwindow;

import java.util.ArrayList;
import java.util.List;


// Leetcode 986 Tags: Facebook
public class intervalIntersection {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> intersections = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < firstList.length && j < secondList.length) {
            int[] section1 = firstList[i];
            int[] section2 = secondList[j];
            if (Math.max(section1[0], section2[0]) <= Math.min(section1[1], section2[1])) {
                intersections.add(new int[]{Math.max(section1[0], section2[0]), Math.min(section1[1], section2[1])});
            }
            if(section1[1] <= section2[1]){
                i++;
            } else {
                j++;
            }
        }
        return intersections.toArray(new int[intersections.size()][2]);
    }
}
