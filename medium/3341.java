import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int minTimeToReach(int[][] moveTime) {

        int directions[][] = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        int m = moveTime.length;
        int n = moveTime[0].length;
        int dist[][] = new int[m][n];
        for (int a[] : dist)
            Arrays.fill(a, Integer.MAX_VALUE);

        dist[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[] { 0, 0, 0 });

        while (!pq.isEmpty()) {

            int p[] = pq.poll();
            int i = p[1];
            int j = p[2];
            int time_to_reach_u = p[0];
            if (i == m - 1 && j == n - 1)
                return time_to_reach_u;

            for (int dir[] : directions) {
                int nR = i + dir[0];
                int nC = j + dir[1];
                if (nR < 0 || nR >= m || nC < 0 || nC >= n)
                    continue;
                int wait = Math.max(moveTime[nR][nC] - time_to_reach_u, 0);
                int time_to_reach_nR_nC = time_to_reach_u + wait + 1;
                if (dist[nR][nC] > time_to_reach_nR_nC) {
                    dist[nR][nC] = time_to_reach_nR_nC;
                    pq.add(new int[] { time_to_reach_nR_nC, nR, nC });
                }

            }
        }
        return -1;
    }
}