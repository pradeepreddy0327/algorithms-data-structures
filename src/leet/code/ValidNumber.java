package leet.code;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Leetcode #65
public class ValidNumber {

	public static void main(String[] args) {
		ValidNumber obj = new ValidNumber();
		System.out.println("0" + " : " + obj.validNumber("0"));
		System.out.println(" 0.1 " + " : " + obj.validNumber(" 0.1 "));
		System.out.println("abc" + " : " + obj.validNumber("abc"));
		System.out.println("1 a" + " : " + obj.validNumber("1 a"));
		System.out.println("2e10" + " : " + obj.validNumber("2e10"));

		System.out.println(" -90e3   " + " : " + obj.validNumber(" -90e3   "));
		System.out.println(" 1e" + " : " + obj.validNumber(" 1e"));
		System.out.println("e3" + " : " + obj.validNumber("e3"));
		System.out.println(" 6e-1" + " : " + obj.validNumber(" 6e-1"));

		System.out.println(" 99e2.5 " + " : " + obj.validNumber(" 99e2.5 "));
		System.out.println("53.5e93" + " : " + obj.validNumber("53.5e93"));
		System.out.println("--6" + " : " + obj.validNumber("--6"));

		System.out.println("-+3" + " : " + obj.validNumber("-+3"));
		System.out.println("95a54e53" + " : " + obj.validNumber("95a54e53"));
	}

	public boolean validNumber(String s) {
		s = s.trim();
		if (!checkPattern(s, "[0-9e.\\-+]+"))
			return false;
		int dotIndex = s.indexOf('.');
		if (dotIndex < 0)
			dotIndex = Integer.MAX_VALUE;
		int eIndex = s.indexOf('e');
		if (eIndex < 0)
			eIndex = Integer.MAX_VALUE;
		if (dotIndex < eIndex) {
			return (checkPattern(s.substring(0, dotIndex), "[-+]?[0-9]+")
					&& validDecimal(s.substring(dotIndex + 1), "[0-9]*"))
					|| (checkPattern(s.substring(0, dotIndex), "[-+]?[0-9]*")
							&& validDecimal(s.substring(dotIndex + 1), "[0-9]+"));
		} else if (dotIndex > eIndex) {
			return checkPattern(s.substring(0, eIndex), "[-+]?[0-9]+") && validExponent(s.substring(eIndex + 1));
		}
		return checkPattern(s, "[-+]?[0-9]+");
	}

	private boolean validDecimal(String s, String p) {
		int eIndex = s.indexOf('e');
		if (eIndex > -1) {
			return checkPattern(s.substring(0, eIndex), p) && validExponent(s.substring(eIndex + 1));
		}
		return checkPattern(s, p);
	}

	private boolean validExponent(String s) {
		// int dotIndex = s.indexOf('e');
		// if (dotIndex > -1) {
		// return checkPattern(s.substring(0, dotIndex), "[\\-+]?[0-9]+")
		// && checkPattern(s.substring(dotIndex + 1), "[0-9]+");
		// }
		return checkPattern(s, "[\\-+]?[0-9]+");
	}

	private boolean checkPattern(String s, String p) {
		Pattern r = Pattern.compile(p);
		Matcher m = r.matcher(s);
		return m.matches();
	}

}
