package array;

// leetcode 238  tags: Facebook
public class ProductExceptItself {

    public int[] productExceptSelf(int[] nums) {
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];
        int[] ans = new int[nums.length];
        leftProduct[0] = 1;
        rightProduct[nums.length-1] = 1;

        for(int i=1;i<nums.length;i++){
            leftProduct[i] = leftProduct[i-1]*nums[i-1];
        }
        for(int i=nums.length-2;i>=0;i--){
            rightProduct[i] = rightProduct[i+1]*nums[i+1];
        }

        for(int i=0;i<nums.length;i++){
            ans[i] = leftProduct[i] * rightProduct[i];
        }
        return ans;
    }

    public int[] productExceptSelfV2(int[] nums) {

        int[] ans = new int[nums.length];
        ans[0] = 1;
        for(int i=1;i<nums.length;i++){
            ans[i] = ans[i-1]*nums[i-1];
        }
        int r  = 1;
        for(int i=nums.length-1;i>=0;i--){
            ans[i] = ans[i]*r;
            r *= nums[i];
        }

        return ans;
    }
}
