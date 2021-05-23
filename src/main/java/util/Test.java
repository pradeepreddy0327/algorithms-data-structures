package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
        System.out.println("12" + "13" + String.format("%05d", 123456)
                + String.format("%02d", 123));
        String d = "2019-11-05T17:34:09.815+0000";
        Date date1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .parse(d);
        System.out.println(date1);
        String k = "0";
        System.out.println(new Date(Long.valueOf(k)));
		String s = "-";
		String p = "[0-9e.\\-+]+";
		String p2 = "[\\-+]?";
		Pattern r = Pattern.compile(p);
		Matcher m = r.matcher(s);
		System.out.println(m.matches());
		try {
			System.out.println(" try");
			int[][] a = { { 1, 1, 0 }, { 1, 0, 0 }, { 1, 9, 0 } };
			System.out.println(new Test().bfs(3, 3, a));
		} catch (Exception e) {

		} finally {
			System.out.println(" finally");
		}
	}

	public int minimumDistance(int numRows, int numColumns, List<List<Integer>> area) {
		// converting 2d list array for easy accessibility
		int[][] areaArray = new int[numRows][numColumns];
		int i = 0;
		int j = 0;
		for (List<Integer> row : area) {
			for (Integer column : row) {
				areaArray[i][j] = column;
				j++;
			}
			j = 0;
			i++;
		}
		return bfs(numRows, numColumns, areaArray);
	}

	private int bfs(int numRows, int numColumns, int[][] areaArray) {
		Queue<String> queue = new LinkedList<>();
		int[][] lvl = new int[numRows][numColumns];
		if (areaArray[0][0] == 0) {
            return -1;
        }
		if (areaArray[0][0] == 9) {
            return 0;
        }
		queue.add("0_0");
		lvl[0][0] = 0;
		while (!queue.isEmpty()) {
			String location = queue.poll();
			int x = Integer.valueOf(location.split("_")[0]);
			int y = Integer.valueOf(location.split("_")[1]);
			if (x + 1 < numRows && areaArray[x + 1][y] != 0 && lvl[x + 1][y] == 0) {
				if (areaArray[x + 1][y] == 1) {
					lvl[x + 1][y] = lvl[x][y] + 1;
					queue.add(x + 1 + "_" + y);
				} else if (areaArray[x + 1][y] == 9) {
					return lvl[x][y] + 1;
				}
			}
			if (y + 1 < numColumns && areaArray[x][y + 1] != 0 && lvl[x][y + 1] == 0) {
				if (areaArray[x][y + 1] == 1) {
					lvl[x][y + 1] = lvl[x][y] + 1;
					queue.add(x + "_" + y + 1);
				} else if (areaArray[x][y + 1] == 9) {
					return lvl[x][y] + 1;
				}
			}
		}
		return -1;
	}

}
