package leetcode;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.text.DateFormatter;

import com.google.common.hash.Hashing;

public class Test {

	public static void main(String[] args) throws IOException {

		String dir = "/Users/pmuchchanthula/Desktop/sftp/taUpload";
		Path folder = Paths.get(dir);
		System.out.println(Files.exists(folder));
		if (!Files.exists(folder)) {
			Files.createDirectories(folder);
		}

		System.out.println(folder.toString());
		Scanner scan = new Scanner(System.in);
		LocalDate l = LocalDate.parse("05032018", DateTimeFormatter.ofPattern("MMddyyyy"));
		System.out.println(l.getDayOfWeek().name());
		System.out.println(NumberFormat.getCurrencyInstance().getCurrency().getSymbol(Locale.US));
		System.out.println(NumberFormat.getCurrencyInstance().getCurrency().getSymbol(Locale.US));
		System.out.println(NumberFormat.getCurrencyInstance().getCurrency().getSymbol(Locale.US));

		String[] arr = "B,E,R,T,V".split(",");
		Arrays.sort(arr);
		List<String> combinations = new ArrayList<>();
		addPnpCombinations(arr, combinations, 0);
		Collections.sort(combinations);
		System.out.println(combinations);

		System.out.println(combinations.size());

		int n = 10;
		System.out.println(Math.floor(((n + 17) * (2 * Math.pow(n, 2) + 20 * n + 81) + 15 * (n + 1) * Math.pow(-1, n)
				+ 120 * ((Math.floor(n / 5) + 1)
						* ((1 + (-1) ^ Math.floorMod(n, 5)) / 2 - Math.floor(((Math.floorMod(n, 5)) ^ 2) / 8))))
				/ 1200));
		Integer k = 10;
		System.out.println("MA, RE".replaceAll("\\s",""));
	}

	private static String getHash(String str) {
		return Hashing.sha1().hashString(str, StandardCharsets.UTF_8).toString();
	}

	private static void addPnpCombinations(String[] s, List<String> l, int i) {
		if (i < s.length) {
			List<String> t = new ArrayList<>();
			for (String a : l) {
				t.add(a + "," + s[i]);
			}
			l.addAll(t);
			l.add(s[i]);
			addPnpCombinations(s, l, i + 1);
		}
	}
}
