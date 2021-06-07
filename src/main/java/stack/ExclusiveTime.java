package stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// leetcode 636  tags: Facebook
public class ExclusiveTime {

    public static void main(String[] args) {
        ExclusiveTime obj = new ExclusiveTime();
        System.out.println(Arrays.toString(obj.exclusiveTime(2,
                     Arrays.asList(new String[]{"0:start:0", "0:start:2", "0:end:5", "1:start:7", "1:end:7", "0:end:8"}))));
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Stack<Pair> started = new Stack<>();
        int used = 0;
        for (String log : logs) {
            String[] logDetails = log.split(":");
            if (logDetails[1].equals("start")) {
                started.push(new Pair(logDetails, used));
            } else {
                Pair prevLogDetailsPair = started.pop();
                int ranFor = Integer.valueOf(logDetails[2]) - Integer.valueOf(prevLogDetailsPair.logDetails[2]) + 1 - used + prevLogDetailsPair.used;
                ans[Integer.valueOf(logDetails[0])] += ranFor;
                used += ranFor;
            }
        }
        return ans;
    }

    class Pair{
        String[] logDetails;
        int used;
         Pair(String[] logDetails, int used){
             this.logDetails = logDetails;
             this.used = used;
         }
    }
}



