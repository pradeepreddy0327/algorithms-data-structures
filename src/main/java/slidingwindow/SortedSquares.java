package slidingwindow;

// leetcode 977  tags: Facebook
public class SortedSquares {

    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int a = 0;
        int b = nums.length -1;
        int c  = b;
        while(a<=b){
            if(Math.abs(nums[a])>Math.abs(nums[b])){
                ans[c--] = nums[a]*nums[a];
                a++;
            } else{
                ans[c--] = nums[b]*nums[b];
                b--;
            }
        }
        return ans;
    }
}
