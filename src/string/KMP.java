package string;

import java.util.Arrays;

// Knuth - Morris -Pratt pattern matching algorithm

public class KMP {

	public static void main(String[] args) {
		KMP obj = new KMP();
		System.out.println(Arrays.toString(obj.computeLPS("ABABCABAB")));
		System.out.println(obj.stringMatch("ABABDABACDABABCABAB", "ABABCABAB"));

	}

	public int stringMatch(String str, String pattern) {
		int[] lps = computeLPS(pattern);
		int N = str.length();
		int M = pattern.length();
		int i = 0, j = 0;
		while (i < N && j < M) {
			if (str.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			} else if (j > 0) {
				j = lps[j - 1];
			} else {
				i++;
			}
		}
		return j == M ? i - j : -1;
	}

	public int[] computeLPS(String pattern) {
		int N = pattern.length();
		int i = 1, j = 0;
		int[] lps = new int[N];
		lps[0] = 0;
		while (i < N) {
			if (pattern.charAt(i) == pattern.charAt(j)) {
				j++;
				lps[i] = j;
				i++;
			} else {
				if (j > 0) {
					j = lps[j - 1];
				} else {
					lps[i] = j;
					i++;
				}
			}
		}
		return lps;
	}

}
