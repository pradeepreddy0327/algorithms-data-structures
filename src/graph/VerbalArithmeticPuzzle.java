package graph;

import java.util.Arrays;

// lc 1307
public class VerbalArithmeticPuzzle {

    public static void main(String[] args) {
        VerbalArithmeticPuzzle obj = new VerbalArithmeticPuzzle();
        System.out.println(
                obj.isSolvable(new String[] { "SEND", "MORE" }, "MONEY"));
        System.out.println(obj.isSolvable(
                new String[] { "SIX", "SEVEN", "SEVEN" }, "TWENTY"));
        System.out.println(
                obj.isSolvable(new String[] { "THIS", "IS", "TOO" }, "FUNNY"));
        System.out.println(
                obj.isSolvable(new String[] { "LEET", "CODE" }, "POINT"));
        System.out.println(
                obj.isSolvable(new String[] { "ADICG", "C" }, "DHBADI"));
    }


    public boolean isSolvable(String[] words, String result) {
        int[] keys = new int[26];
        Arrays.fill(keys, -1);
        int i = 0;
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (keys[c - 'A'] < 0) {
                    keys[c - 'A'] = i++;
                }

            }
        }
        for (char c : result.toCharArray()) {
            if (keys[c - 'A'] < 0) {
                keys[c - 'A'] = i++;
            }
        }
        return isSolvable(keys, new int[i], words, result, new boolean[10], 0);
    }

    private boolean isSolvable(int[] keys, int[] vals, String[] words,
            String result, boolean[] used, int index) {
        if (index == vals.length) {
            return checkSum(keys, vals, words, result);
        }
        for (int i = 0; i <= 9; i++) {
            if (!used[i]) {
                used[i] = true;
                vals[index] = i;
                if (isSolvable(keys, vals, words, result, used, index + 1)) {
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }

    private boolean checkSum(int[] keys, int[] vals, String[] words,
            String result) {
        int sum = 0;
        for (String word : words) {
            sum += convertToNumber(keys, vals, word);
        }
        return sum == convertToNumber(keys, vals, result);
    }

    private int convertToNumber(int[] keys, int[] vals, String word) {
        int n = 0;
        for (char c : word.toCharArray()) {
            n = n * 10 + vals[keys[c - 'A']];
        }
        return n;
    }


}
