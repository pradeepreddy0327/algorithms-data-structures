package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test2 {

	public static void main(String[] args) {
		List<List<Integer>> ll = new ArrayList<>();
		ll.add(getList(1, 2));
		ll.add(getList(3, 4));
		ll.add(getList(1, -1));
		Test2 obj = new Test2();
		System.out.println(obj.closest(3, ll, 2));

	}
	
	private static List<Integer> getList(int a, int b){
		List<Integer> l = new ArrayList<Integer>();
		l.add(a);
		l.add(b);
		return l;
	}

	List<List<Integer>> closest(int numDestinations, List<List<Integer>> allLOcations, int numDeliveries) {

		Collections.sort(allLOcations, (a, b) -> getDistance(a).compareTo(getDistance(b)));
		return allLOcations.subList(0, Math.min(numDeliveries, numDestinations));
	}

	private Integer getDistance(List<Integer> location) {
		Integer dist = 0;
		for (Integer i : location) {
			dist = dist + i * i;
		}
		return dist;
	}

}
