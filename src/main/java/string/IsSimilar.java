package string;

public class IsSimilar {

    public static void main(String[] args) {
        IsSimilar obj = new IsSimilar();
        System.out.println(obj.isSimilar("pale", "ple"));
        System.out.println(obj.isSimilar("pales", "pale"));
        System.out.println(obj.isSimilar("pale", "bale"));
        System.out.println(obj.isSimilar("pale", "bake"));
    }

    public boolean isSimilar(String s, String c) {
        if (Math.abs(s.length() - c.length()) > 1) {
            return false;
        }
        if (s.length() == c.length()) {
            int diff = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != c.charAt(i)) {
                    diff++;
                    if (diff > 1) {
                        return false;
                    }
                }
            }
        } else {
            int i = 0, j = 0;
            int diff = 0;
            if (s.length() > c.length()) {
                String t = c;
                c = s;
                s = t;
            }
            while (i < s.length() && j < c.length()) {
                if (s.charAt(i) != c.charAt(j)) {
                    diff++;
                    if (diff > 1) {
                        return false;
                    }
                    i--;
                }
                i++;
                j++;
            }
        }
        return true;
    }

}
