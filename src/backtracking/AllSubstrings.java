package backtracking;

import java.util.ArrayList;
import java.util.List;

public class AllSubstrings {

    public static void main(String[] args) {
        AllSubstrings obj = new AllSubstrings();
        System.out.println(obj.allSubstrings("abc"));
    }

    public List<String> allSubstrings(String s) {
        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                ans.add(s.substring(i, j));
            }
        }
        return ans;
    }


}
