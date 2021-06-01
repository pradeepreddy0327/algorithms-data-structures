package binarySearch;

import java.util.Random;

// leetcode 528  tags: Facebook
public class PickIndex {
    public static void main(String[] args) {
        PickIndex obj = new PickIndex(new int[]{1,3});
        System.out.println(obj.pickIndex());
        System.out.println(obj.pickIndex());
        System.out.println(obj.pickIndex());
        System.out.println(obj.pickIndex());
    }
    int[][] rangeArr;
    Random random;
    int sum;
    public PickIndex(int[] w) {
        this.rangeArr = new int[w.length][2];
        sum = 0;
        for(int i=0;i<w.length;i++){
            rangeArr[i] = new int[]{sum, sum+w[i]};
            sum += w[i];
        }
        random = new Random();
    }

    public int pickIndex() {
        int randIndex = random.nextInt(sum);
        return binarySearch(randIndex);
    }

    private int binarySearch(int randIndex){
        int low = 0;
        int high = rangeArr.length-1;
        while(low<=high){
            int  mid = (low+high)/2;
            if(rangeArr[mid][0] <= randIndex && rangeArr[mid][1] > randIndex){
                return mid;
            } else if(rangeArr[mid][0] > randIndex){
                high = mid - 1;
            } else{
                low = mid+1;
            }
        }
        return -1;
    }
}
