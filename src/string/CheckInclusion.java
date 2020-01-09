package string;

import java.util.Arrays;

public class CheckInclusion {

	// leetcode 567
	public static void main(String[] args) {
		System.out.println(new CheckInclusion().checkInclusion("ab", "eidbaooo"));
		System.out.println("".indexOf("a"));

	}

	public boolean checkInclusion(String s1, String s2) {
		if (s1.length() > s2.length())
			return false;
		if (s2.indexOf(s1) > -1)
			return true;
		int[] a1 = new int[26];
		int[] a2 = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			a1[s1.charAt(i) - 'a']++;
		}
		for (int i = 0; i < s2.length(); i++) {
			a2[s2.charAt(i) - 'a']++;
			if (i >= s1.length()) {
				a2[s2.charAt(i - s1.length()) - 'a']--;
			}
			if (Arrays.equals(a1, a2))
				return true;
		}

		return false;
	}

}
