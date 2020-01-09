package leetcode;

public class HammingWeight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(hammingWeight(-4));
	}

	public static int hammingWeight( int n) {
		int i = 0;
		while (n != 0) {
			i += n % 2 != 0 ? 1 : 0;
			n = (n) / 2;
		}
		return i;
	}

}
