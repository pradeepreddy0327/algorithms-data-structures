package array;

import java.util.HashMap;
import java.util.Map;

public class WordCount {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    int wordCount(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;
        Map<String, String[]> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                String[] arr = new String[3];
                arr[0] = getString(getFromMap(map, i - 1, j)[0], board[i][j],
                        word.length());
                arr[1] = getString(getFromMap(map, i - 1, j - 1)[1],
                        board[i][j], word.length());
                arr[2] = getString(getFromMap(map, i, j - 1)[2], board[i][j],
                        word.length());
                map.put(i + "_" + j, arr);
                for (int k = 0; k < 3; k++) {
                    if (arr[k].equals(word))
                        count++;
                }
            }
        }
        System.out.println(map);
        return count;
    }

    private String[] getFromMap(Map<String, String[]> map, int i, int j) {
        String[] arr = map.get(i + "_" + j);
        return arr == null ? new String[3] : arr;
    }

    private String getString(String str, char c, int l) {
        if (str == null)
            str = "";
        str = str + c;
        return str.length() > l ? str.substring(1) : str;
    }

}
