package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupStrings {
    public static void main(String[] args) {
        GroupStrings obj = new GroupStrings();
        System.out.println(obj.groupStrings(new String[]{"abc","bcd","acef","xyz","az","ba","a","z"}));
    }

    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s:strings){
            String key = shiftWord(s.toCharArray());
            List<String> l = map.getOrDefault(key, new ArrayList<>());
            l.add(s);
            map.putIfAbsent(key, l);
        }
        return new ArrayList<>(map.values());
    }

    private String shiftWord(char[] charArr){
        int diff = charArr[0]-'a';
        for(int i=0;i<charArr.length;i++){
            int j = charArr[i] - diff;
            if(j<'a'){
                charArr[i] = (char)(j+26);
            } else {
                charArr[i] = (char)j;
            }
        }
        return new String(charArr);
    }
}
