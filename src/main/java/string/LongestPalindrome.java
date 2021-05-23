package string;

public class LongestPalindrome {

	// Leetcode Problem 4
	public static void main(String[] args) {
		String str = "forgeeksskeegfor";
		LongestPalindrome obj = new LongestPalindrome();
		System.out.println(obj.longestPalindrome(str));

	}

	public String longestPalindrome(String str) {

		int maxL = 0;
		int start = 0;
		int end = 0;
		for (int i = 1; i < str.length(); i++) {
			int low = i - 1;
			int high = i;
			while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)) {
				if (high - low + 1 > maxL) {
					maxL = high - low + 1;
					start = low;
					end = high;
				}
				high++;
				low--;
			}
			low = i - 1;
			high = i + 1;
			while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)) {
				if (high - low + 1 > maxL) {
					maxL = high - low + 1;
					start = low;
					end = high;
				}
				high++;
				low--;
			}
		}

		return str.length() > 0 ? str.substring(start, end + 1) : "";
	}
}
