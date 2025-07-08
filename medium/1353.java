import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int maxEvents(int[][] events) {

        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> q = new PriorityQueue<>();
        int day = events[0][0];
        int i = 0;
        int n = events.length;
        int count = 0;
        while (!q.isEmpty() || i < n) {

            while (i < n && events[i][0] == day) {
                q.add(events[i][1]);
                i++;
            }

            if (!q.isEmpty()) {
                q.poll();
                count++;
            }

            day++;

            while (!q.isEmpty() && q.peek() < day)
                q.poll();
        }

        return count;
    }
}