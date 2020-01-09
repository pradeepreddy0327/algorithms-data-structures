package leet.code;

import java.util.ArrayList;
import java.util.List;

public class RemoveComments {

	// leetcode problem 722
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = { "a//*b//*c","blank","d/*/e*//f" };

		String[] a = { "/*Test program */", "int main()", "{ ", " // variable declaration ", "int a, b, c;",
				"/* This is a test", " multiline ", " comment for ", " testing */", "a = b + c;", "}" };
		System.out.println(new RemoveComments().removeComments(s));
	}

	public List<String> removeComments(String[] source) {

		List<String> ans = new ArrayList<String>();
		boolean commentStarted = false;
		for (String s : source) {
			if (commentStarted) {
				int i = s.indexOf("*/");
				if (i > -1) {
					commentStarted = handleLine(s.substring(i + 2), ans, true);
				} else
					continue;
			} else {
				commentStarted = handleLine(s, ans, false);
			}
		}
		List<String> r = new ArrayList<>();
		for (String s : ans) {
			if (!s.equals(""))
				r.add(s);
		}
		return r;
	}

	boolean handleLine(String s, List<String> ans, boolean cm) {
		int i = s.indexOf("/*");
		int j = s.indexOf("//");
		if (j != -1 & (j < i || i == -1)) {
			if (cm) {
				ans.add(ans.get(ans.size() - 1) + s.substring(0, j));
				ans.remove(ans.size() - 2);
			} else {
				ans.add(s.substring(0, j));
			}
			return false;
		} else if (i != -1 && (i < j || j == -1)) {
			if (cm) {
				ans.add(ans.get(ans.size() - 1) + s.substring(0, i));
				ans.remove(ans.size() - 2);
			} else {
				ans.add(s.substring(0, i));
			}
			while (s.indexOf("*/") > -1) {
				int k = s.indexOf("*/");
				if (k > i + 1) {
					return handleLine(s.substring(k + 2), ans, true);
				}
				s = s.substring(0,k)+"xx"+s.substring(k + 2);
			}
			return true;
		}
		if (cm) {
			ans.add(ans.get(ans.size() - 1) + s);
			ans.remove(ans.size() - 2);
		} else
			ans.add(s);
		return false;
	}

}
