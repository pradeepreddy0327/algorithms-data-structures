package string;

import java.util.ArrayList;
import java.util.List;

// leetcode problem number 6
public class ZigZagConversion {

	public static void main(String[] args) {
		ZigZagConversion obj = new ZigZagConversion();
		System.out.println(obj.convert("PAYPALISHIRING", 3));
	}

	public String convert(String s, int numRows) {
		if (s.length() <= numRows)
			return s;
		List<StringBuilder> l = new ArrayList<>();
		int curRow = 0;
		boolean goingDown = false;
		for (char c : s.toCharArray()) {
			StringBuilder sb = new StringBuilder();
			if (l.size() < curRow + 1) {
				l.add(sb);
			} else {
				sb = l.get(curRow);
			}
			sb.append(c);
			if (curRow == 0 || curRow == numRows - 1) {
				goingDown = !goingDown;
			}
			curRow += goingDown ? 1 : -1;
		}
		StringBuilder ans = new StringBuilder();
		for (StringBuilder sb : l) {
			ans.append(sb.toString());
		}
		return ans.toString();
	}
}
