package math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuessTheWord {

    public static void main(String[] args) {
        GuessTheWord obj = new GuessTheWord();
        System.out.println(obj.guessTheWord(new String[]{"wichbx", "oahwep", "tpulot", "eqznzs", "vvmplb", "eywinm", "dqefpt", "kmjmxr",
                                                         "ihkovg", "trbzyb", "xqulhc", "bcsbfw", "rwzslk", "abpjhw", "mpubps", "viyzbc",
                                                         "kodlta", "ckfzjh", "phuepp", "rokoro", "nxcwmo", "awvqlr", "uooeon", "hhfuzz",
                                                         "sajxgr", "oxgaix", "fnugyu", "lkxwru", "mhtrvb", "xxonmg", "tqxlbr", "euxtzg",
                                                         "tjwvad", "uslult", "rtjosi", "hsygda", "vyuica", "mbnagm", "uinqur", "pikenp",
                                                         "szgupv", "qpxmsw", "vunxdn", "jahhfn", "kmbeok", "biywow", "yvgwho", "hwzodo",
                                                         "loffxk", "xavzqd", "vwzpfe", "uairjw", "itufkt", "kaklud", "jjinfa", "kqbttl",
                                                         "zocgux", "ucwjig", "meesxb", "uysfyc", "kdfvtw", "vizxrv", "rpbdjh", "wynohw",
                                                         "lhqxvx", "kaadty", "dxxwut", "vjtskm", "yrdswc", "byzjxm", "jeomdc", "saevda",
                                                         "himevi", "ydltnu", "wrrpoc", "khuopg", "ooxarg", "vcvfry", "thaawc", "bssybb",
                                                         "ccoyyo", "ajcwbj", "arwfnl", "nafmtm", "xoaumd", "vbejda", "kaefne", "swcrkh",
                                                         "reeyhj", "vmcwaf", "chxitv", "qkwjna", "vklpkp", "xfnayl", "ktgmfn", "xrmzzm",
                                                         "fgtuki", "zcffuv", "srxuus", "pydgmq"}, new Master("ccoyyo")));
        System.out.println(obj.guessTheWord(new String[]{"abcdef","acdefg","adefgh","aefghi","afghij","aghijk","ahijkl",
                                                         "aijklm","ajklmn","aklmno","almnoz","anopqr","azzzzz"}, new Master("azzzzz")));
    }

    public String guessTheWord(String[] wordList, Master master) {
        for (int i = 0; i < 100; i++) {
            int[][] freq = new int[6][26];
            for (String word : wordList) {
                for(int j=0;j<6;j++){
                 freq[j][word.charAt(j)-'a']++;
                }
            }
            String guessWord = wordList[0];
            int max = 0;
            for(String word:wordList){
                int count = 0;
                for(int j=0;j<6;j++){
                    count += freq[j][word.charAt(j)-'a'];
                }
                if(count>max){
                    max= count;
                    guessWord = word;
                }
            }
            int guess = master.guess(guessWord);
            if (guess == 6) {
                System.out.println(i);
                return guessWord;
            }
            List<String> filteredList = new ArrayList<>();
            for (String word : wordList) {
                if (match(guessWord, word) == guess) {
                    filteredList.add(word);
                }
            }
            wordList = filteredList.toArray(new String[filteredList.size()]);
        }
        return null;
    }

    private int match(String word1, String word2) {
        int matched = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word2.charAt(i) == word1.charAt(i)) matched++;
        }
        return matched;
    }
}

class Master {
    String correctWord;

    public Master(String correctWord) {
        this.correctWord = correctWord;
    }

    public int guess(String word) {
        int matched = 0;
        for (int i = 0; i < word.length(); i++) {
            if (correctWord.charAt(i) == word.charAt(i)) matched++;
        }
        return matched;
    }
}
