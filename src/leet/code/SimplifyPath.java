package leet.code;

import java.util.Stack;

public class SimplifyPath {
  //lp 71
	public static void main(String[] args) {
		SimplifyPath obj = new SimplifyPath();
		System.out.println(obj.simplifyPath("/"));
		System.out.println(obj.simplifyPath("/../"));

	}

	public String simplifyPath(String path) {
		Stack<String> stack = new Stack<>();
		String[] arr = path.split("/");
		for (String s : arr) {
			if (s.trim().isEmpty() || s.equals("."))
				continue;
			if (s.equals("..")) {
				if (!stack.isEmpty())
					stack.pop();
			} else
				stack.add(s);
		}
		String ans = "";
		while (!stack.isEmpty()) {
			ans = ans.length() > 0 ? stack.pop() + "/" + ans : stack.pop() + ans;
		}
		return "/" + ans;
	}

}
