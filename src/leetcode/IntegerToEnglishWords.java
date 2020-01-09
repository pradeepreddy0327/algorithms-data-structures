package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Leet Code Problem Number : 273
 */
public class IntegerToEnglishWords {
	static Map<Integer, String> digitsMap = new HashMap<>();
	static Map<Integer, String> tensMap = new HashMap<>();

	public static void main(String[] args) {

		digitsMap.put(1, "One");
		digitsMap.put(2, "Two");
		digitsMap.put(3, "Three");
		digitsMap.put(4, "Four");
		digitsMap.put(5, "Five");
		digitsMap.put(6, "Six");
		digitsMap.put(7, "Seven");
		digitsMap.put(8, "Eight");
		digitsMap.put(9, "Nine");

		tensMap.put(2, "Twenty");
		tensMap.put(3, "Thirty");
		tensMap.put(4, "Forty");
		tensMap.put(5, "Fifty");
		tensMap.put(6, "Sixty");
		tensMap.put(7, "Seventy");
		tensMap.put(8, "Eighty");
		tensMap.put(9, "Ninety");

		tensMap.put(10, "Ten");
		tensMap.put(11, "Eleven");
		tensMap.put(12, "Twelve");
		tensMap.put(13, "Thirteen");
		tensMap.put(14, "Fourteen");
		tensMap.put(15, "Fifteen");
		tensMap.put(16, "Sixteen");
		tensMap.put(17, "Seventeen");
		tensMap.put(18, "Eighteen");
		tensMap.put(19, "Nineteen");
		System.out.println(convertNumber(12567891));

	}

	private static String convertNumber(Integer num) {
		String ans = "";
		int c = 0;
		while (num > 0) {
			int threeDigits = num % 1000;
			num = num / 1000;
			String temp = convertThreeDigits(threeDigits);
			if (temp.length() > 0) {
				if (c == 1) {
					temp = temp + " Thousand";
				} else if (c == 2) {
					temp = temp + " Million";
				} else if (c == 3) {
					temp = temp + " Billion";
				}
			}
			ans = temp.trim() + " " + ans.trim();
			c++;
		}
		return ans.trim().length() > 0 ? ans.trim() : "Zero";
	}

	private static String convertThreeDigits(Integer i) {

		String s = "";
		int a = i % 10;
		i = i / 10;
		int b = i % 10;
		i = i / 10;
		int c = i % 10;
		if (digitsMap.get(c) != null) {
			s = digitsMap.get(c) + " Hundred";
		}
		if (digitsMap.get(b) != null) {
			if (tensMap.get(b) != null) {
				s = s + " " + tensMap.get(b);
			} else {
				s = s + " " + tensMap.get(b * 10 + a);
				return s.trim();
			}
		}
		if (digitsMap.get(a) != null) {
			s = s + " " + digitsMap.get(a);
		}
		return s.trim();
	}
}
