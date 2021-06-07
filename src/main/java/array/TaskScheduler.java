package array;

import java.util.Arrays;

// leetcode 621  tags: Facebook
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int[] freqArr = new int[26];
        for(char task:tasks){
            freqArr[task-'A']++;
        }
        Arrays.sort(freqArr);
        int fMax = freqArr[25];
        int idleTime = (fMax-1)*n;
        for(int i=24;i>=0&&freqArr[i]>0;i--){
            idleTime -= Math.min(fMax-1, freqArr[i]);
        }
        idleTime = Math.max(0, idleTime);
        return tasks.length + idleTime;
    }
}
