package hacker.rank;

import java.math.BigInteger;

public class TwoTwo {

    public static void main(String[] args) {
        System.out.println(twoTwo("2222222"));
        System.out.println(twoTwo("1024"));
        System.out.println(twoTwo("24256"));
        System.out.println(twoTwo("65536"));
        System.out.println(twoTwo("023223"));
        System.out.println(twoTwo("33579"));

        System.out.println(twoTwo(
                "9303535670983768199031344740966458039726609416797671171603074549512182887851493418575245449136173639177760276560207077549242900846267596823817051317718446589520242536874132581700120107002038199303870846751188192899823151552628349788604516295066307994130118526061826166445047808309163001841380667575628151274558987543914186376514799892578820116121531383164833962895501326553806236997089282520174174189206292883439012459432693877366459895758465185873923518437208883287869410049671804351768330228241833181048771841834309240249132277574952747489997467168763400466618303709392785810954982875161446396373040800947562126272731545618170968107390172263733095197200113358841034017182951507037254979515982202834948083154776267844089139019063040156654448338365040715366458968162887836583628774290327941701420576894069006881693378223441337877537377325813845730080900918242835443359855685076558915384842574884883772410178635875682021801984576460752303423488223007451985306231415357182726483615059804162147483648324"));

    }

    static int twoTwo(String a) {
        TrieNode root = getTrie();
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != '0') {
                count += root.countWords(a.substring(i));
            }
        }
        return count;
    }

    static TrieNode getTrie() {
        TrieNode root = new TrieNode();
        BigInteger b = new BigInteger("1");
        BigInteger two = new BigInteger("2");
        root.addWord(b.toString());
        for (int i = 1; i <= 800; i++) {
            b = b.multiply(two);
            root.addWord(b.toString());
        }
        return root;
    }

}

class TrieNode {
    char c;
    TrieNode[] children;
    boolean isWord;

    TrieNode() {
        children = new TrieNode[10];
    }

    void addWord(String s) {
        TrieNode n = this;
        for (char c : s.toCharArray()) {
            if (n.children[c - '0'] == null) {
                n.children[c - '0'] = new TrieNode();
            }
            n = n.children[c - '0'];
        }
        n.isWord = true;
    }

    int countWords(String s) {
        TrieNode n = this;
        int count = 0;
        for (char c : s.toCharArray()) {
            if (n.children[c - '0'] == null) {
                return count;
            }
            n = n.children[c - '0'];
            if (n.isWord) {
                count++;
            }
        }
        return count;
    }
}