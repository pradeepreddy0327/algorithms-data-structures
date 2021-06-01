package binarySearch;

import java.util.ArrayList;
import java.util.List;

// leetcode 1428  tags: Facebook
public class LeftMostColumnWithAtLeastOne {

    public static void main(String[] args){
        LeftMostColumnWithAtLeastOne obj= new LeftMostColumnWithAtLeastOne();
        System.out.println(obj.leftMostColumnWithOneV2(new BinaryMatrix(new int[][]{ {0,0},{1,1}})));
        System.out.println(obj.leftMostColumnWithOneV2(new BinaryMatrix(new int[][]{ {0,0},{0,1}})));
        System.out.println(obj.leftMostColumnWithOneV2(new BinaryMatrix(new int[][]{ {1,1,1,1,1},{0,0,0,1,1},{0,0,1,1,1},{0,0,0,0,1},{0,0,0,0,0}})));
    }

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> d = binaryMatrix.dimensions();
        int currentMin = d.get(1);
        for(int i=0;i<d.get(0);i++){
            int low = 0;
            int high = currentMin-1;
            while(low<high){
                int mid = (low+high)/2;
                int midValue = binaryMatrix.get(i, mid);
                if(midValue == 0){
                    low = mid+1;
                } else{
                    high = mid;
                }
            }
            if(binaryMatrix.get(i, high) == 1){
                if(high == 0) return 0;
                currentMin = high;
            }
        }
        return currentMin < d.get(1) ? currentMin : -1;
    }

    public int leftMostColumnWithOneV2(BinaryMatrix binaryMatrix) {
        List<Integer> d = binaryMatrix.dimensions();
        int row = 0;
        int column = d.get(1)-1;
        while(row < d.get(0) && column >= 0){
            if(binaryMatrix.get(row, column) == 1){
                column--;
            } else{
                row++;
            }
        }
        return column == d.get(1)-1 ? -1 : column+1;
    }
    private int getMinColumnWithOneInRow(BinaryMatrix binaryMatrix, int rowIndex, int startColumnIndex, int maxColumnIndex){
        if(startColumnIndex > maxColumnIndex) return -1;
        int endValue = binaryMatrix.get(rowIndex, maxColumnIndex);
        if(endValue == 0) return -1;
        if(startColumnIndex == maxColumnIndex) return maxColumnIndex;
        int midColumnIndex = (startColumnIndex+maxColumnIndex)/2;
        int minInFirstHalf = getMinColumnWithOneInRow(binaryMatrix, rowIndex, startColumnIndex, midColumnIndex);
        if(minInFirstHalf >= 0) return minInFirstHalf;
        int minInSecondHalf = getMinColumnWithOneInRow(binaryMatrix, rowIndex, midColumnIndex+1, maxColumnIndex-1);
        if(minInSecondHalf >= 0) return minInSecondHalf;
        return maxColumnIndex;
    }

     static class BinaryMatrix {
         int[][] matrix;
         List<Integer> d;
         BinaryMatrix(int[][] matrix){
             this.matrix = matrix;
             this.d = new ArrayList<>();
             d.add(matrix.length);
             d.add(matrix[0].length);
         }
        public int get(int row, int col) {
             return matrix[row][col];
        }
        public List<Integer> dimensions() {
             return d;
         }
  };
}
