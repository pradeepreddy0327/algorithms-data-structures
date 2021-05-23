package string;

import java.util.Map.Entry;
import java.util.TreeMap;

public class StringCompression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(betterCompression("a2c9b3c1"));
	}

	static String betterCompression(String s) {

		Character currenctChar = null;
		String freq = "";
		TreeMap<String, Integer> feqMap = new TreeMap<String, Integer>();
		for (char c : s.toCharArray()) {
			if (Character.isDigit(c)) {
				freq = freq + c;
			} else {
				if (currenctChar != null) {
					Integer n = feqMap.get(currenctChar + "");
					if (n == null)
						n = 0;
					n = n + Integer.valueOf(freq);
					feqMap.put(currenctChar + "", n);
				}
				currenctChar = c;
				freq = "";
			}
		}
		if (currenctChar != null) {
			Integer n = feqMap.get(currenctChar + "");
			if (n == null)
				n = 0;
			n = n + Integer.valueOf(freq);
			feqMap.put(currenctChar + "", n);
		}
		String ans = "";
		for (Entry<String, Integer> e : feqMap.entrySet()) {
			ans = ans + e.getKey() + e.getValue();
		}

		return ans;
	}

}
