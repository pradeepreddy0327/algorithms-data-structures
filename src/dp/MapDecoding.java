package dp;

public class MapDecoding {

	// codefights dp:
	// https://app.codesignal.com/interview-practice/task/7o2Aba2Zep3MJPKQ3
	public static void main(String[] args) {
		System.out.println(new MapDecoding().mapDecoding(
				"1221112111122221211221221212212212111221222212122221222112122212121212221212122221211112212212211211"));

	}

	public int mapDecoding(String s) {
		final int MOD = 1000000007;
		char[] sc = s.toCharArray();
		int n = sc.length;
		int[] ways = new int[n + 1];
		ways[n] = 1;
		for (int i = n - 1; i >= 0; i--) {
			if (sc[i] == '0') {
				ways[i] = 0;
				continue;
			}
			ways[i] = ways[i + 1];
			if (i < n - 1 && Integer.valueOf(sc[i] + "" + sc[i + 1]) <= 26) {
				ways[i] = (ways[i + 1] + ways[i + 2]) % MOD;
			}

		}
		return ways[0];
	}

}
