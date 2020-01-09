package leet.code;

public class CanJump {

	// leetcode problem 55
	public static void main(String[] args) {
		System.out.println(new CanJump().canJump(new int[] { 3, 2, 1, 0, 4 }));

	}

	public boolean canJump(int[] nums) {
        int n= nums.length;
        
        int minIndex = n-1;
        for(int i=n-2;i>=0;i--){
            if(i+nums[i]>=minIndex) minIndex = i;
            
        }
        return minIndex==0;
	}


}
