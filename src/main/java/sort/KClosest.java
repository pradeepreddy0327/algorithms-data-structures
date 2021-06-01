package sort;

import java.util.Arrays;
import java.util.Random;

// leetcode 973  tags: Facebook
public class KClosest {

    public int[][] kClosest(int[][] points, int k){
        //Arrays.sort(points, (a, b) -> a[0]*a[0] + a[1]*a[1] - b[0]*b[0] - b[1]*b[1]);
        quickSelect(points, 0, points.length-1, k);
        return Arrays.copyOfRange(points, 0 ,k);
    }
    Random rand = new Random(0);
    private void quickSelect(int[][] points, int start, int end, int k){
        if(start >= end) return;
        int pivotIndex = rand.nextInt(end - start) + start;
        swap(points, pivotIndex, end);
        int[] pivot = points[end];
        int i = start;
        int j = end-1;
        while(i<=j){
            if(value(points[j])<value(pivot)){
                swap(points, i, j);
                i++;
            } else{
                j--;
            }
        }
        swap(points, i, end);
        if(i==k-1) return;
        else if(i>k-1) quickSelect(points, start, i-1, k);
        else quickSelect(points, i+1, end, k);
    }

    private void swap(int[][] points, int i, int j){
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
    private int value(int[] point){
        return point[0]*point[0] + point[1]*point[1];
    }
}
