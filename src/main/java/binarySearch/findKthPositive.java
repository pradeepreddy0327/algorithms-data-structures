package binarySearch;

// Leetcode 1539 Tags: Facebook
public class findKthPositive {

    public int findKthPositive(int[] arr, int k) {
        if(k<arr[0]) return k;
        if(k>arr[arr.length-1]-arr.length) return k+arr.length;
        int left  = 0;
        int right = arr.length -1;
        while(left < right){
            if(right - left  == 1) break;
            int mid = (left+right)/2;
            int missingTillMid = arr[mid] - mid -1;
            if(missingTillMid < k){
                left = mid;
            } else{
                right = mid;
            }
        }
        return left + k + 1;
    }

    public int findKthPositiveV2(int[] arr, int k) {
        for(int i=1; i<arr.length;i++){
            if(k <= arr[i]-(i+1)){
                return k+i;
            }
        }
        return k+arr.length;
    }
}
