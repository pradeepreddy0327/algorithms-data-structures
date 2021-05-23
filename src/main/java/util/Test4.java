package util;

import java.util.Arrays;

public class Test4 {

	public static void main(String[] args) {
		Test4 obj = new Test4();
		System.out.println(obj.customSort("89aDcQAb51"));
	}

	public String customSort(String s) {
		String l = "";
		String u = "";
		String n = "";
		for (char c : s.toCharArray()) {
			if (Character.isDigit(c))
				n += c;
			else if (Character.isLowerCase(c))
				l += c;
			else
				u += c;
		}
		l = sort(l);
		u = sort(u);
		n = sort(n);
		int li = 0, ui = 0, ni = 0;
		String ans = "";
		for (char c : s.toCharArray()) {
			if (Character.isDigit(c))
				ans += n.charAt(ni++);
			else if (Character.isLowerCase(c))
				ans += l.charAt(li++);
			else
				ans += u.charAt(ui++);
		}
		return ans;
	}

	private String sort(String inputString) {
		char tempArray[] = inputString.toCharArray();

		Arrays.sort(tempArray);

		return new String(tempArray);
	}

}
