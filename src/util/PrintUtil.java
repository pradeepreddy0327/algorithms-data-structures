package util;

import java.util.List;

public class PrintUtil {

	public static <T> void printList(List<T> l) {
		for (T e : l) {
			System.out.println(e);
		}
		System.out.println();
	}

	public static <T> void printArray(T[] arr) {
		for (T e : arr) {
			System.out.println(e);
		}
		System.out.println();
	}
}
