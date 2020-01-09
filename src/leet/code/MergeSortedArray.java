package leet.code;

public class MergeSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int[] a = {1,2,3,0,0,0};
       int[] b = {2,5,6};
       merge(a,3,b,3);
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		for (int i = 0; i < m; i++) {
			nums1[m + n - i - 1] = nums1[m - i -1];
			
		}
		int i = n;
		int j = 0;
		int k = 0;
		while (j < n && i < m + n) {
             if(nums2[j]<nums1[i]) {
            	 nums1[k]=nums2[j];
            	 j++;
             } else {
            	 nums1[k]=nums1[i];
            	 i++;
             }
             k++;
		}
		while(j<n) {
			nums1[k]=nums2[j];
			j++;
			k++;
		}
	}

}
