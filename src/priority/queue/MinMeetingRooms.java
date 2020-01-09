package priority.queue;

import java.util.Arrays;
import java.util.PriorityQueue;

// lc 253
public class MinMeetingRooms {

    public static void main(String[] args) {
        MinMeetingRooms obj = new MinMeetingRooms();
        System.out.println(obj.minMeetingRooms(
                new int[][] { { 0, 30 }, { 5, 10 }, { 15, 20 } }));
        System.out.println(
                obj.minMeetingRooms(new int[][] { { 7, 10 }, { 2, 4 } }));

    }

    public int minMeetingRooms(int[][] intervals) {
        int ans = 0;
        PriorityQueue<int[]> currentRunning = new PriorityQueue<>(
                (a, b) -> (a[1] - b[1]));
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        for (int i = 0; i < intervals.length; i++) {

            int[] slot = intervals[i];
            if (!currentRunning.isEmpty()
                    && currentRunning.peek()[1] <= slot[0]) {
                currentRunning.poll();
            }
            currentRunning.add(slot);
            ans = Math.max(ans, currentRunning.size());
        }
        return ans;
    }

}
