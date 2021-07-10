package hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostVisitedPattern {

    public static void main(String[] args) {
        MostVisitedPattern obj = new MostVisitedPattern();
        System.out.println(obj.mostVisitedPattern(
                new String[]{"zkiikgv","zkiikgv","zkiikgv","zkiikgv"},
                new int[]{436363475,710406388,386655081,797150921},
                new String[]{"wnaaxbfhxp","mryxsjc","oz","wlarkzzqht"}
                                                 ));
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        String[][] arr = new String[username.length][3];
        for (int i = 0; i < username.length; i++) {
            arr[i][0] = username[i];
            arr[i][1] = String.valueOf(timestamp[i]);
            arr[i][2] = website[i];
        }
        Arrays.sort(arr, (a, b) -> Integer.valueOf(a[1])- Integer.valueOf(b[1]));
        Map<String, Integer> map = new HashMap<String, Integer>();
        int max = 0;
        for(int i = 2; i<arr.length;i++){
            if(arr[i-2][0].equals(arr[i-1][0]) && arr[i-2][0].equals(arr[i][0])){
                String key = arr[i-2][2]+"_"+arr[i-1][2]+"_"+arr[i][2];
                int count = map.getOrDefault(key, 0);
                max = Math.max(max, count+1);
                map.put(key,count+1);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                //ans = entry.getKey();
                return Arrays.asList(entry.getKey().split("_"));
            }
        }
        return null;
    }
}
