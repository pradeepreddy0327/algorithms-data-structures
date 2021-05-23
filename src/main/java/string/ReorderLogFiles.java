package string;

import java.util.Arrays;

// lc 937
public class ReorderLogFiles {

    public static void main(String[] args) {
        ReorderLogFiles obj = new ReorderLogFiles();
        System.out.println(Arrays.toString(obj
                .reorderLogFiles(new String[] { "dig1 8 1 5 1", "let1 art can",
                        "dig2 3 6", "let2 own kit dig", "let3 art zero" })));
    }

    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            String[] aArr = a.split(" ");
            String[] bArr = b.split(" ");
            boolean isAL = Character.isAlphabetic(aArr[1].charAt(0));
            boolean isBL = Character.isAlphabetic(bArr[1].charAt(0));
            if (!isAL && isBL) {
                return 1;
            }
            if (isAL && !isBL) {
                return -1;
            }
            if (isAL && isBL) {
            int c = String.join(" ", Arrays.copyOfRange(aArr, 1, aArr.length))
                    .compareTo(String.join(" ",
                            Arrays.copyOfRange(bArr, 1, bArr.length)));
            return c != 0 ? c : aArr[0].compareTo(bArr[0]);
            }
            return 0;
        });
        return logs;
    }


}
