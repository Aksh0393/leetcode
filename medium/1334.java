import java.util.Arrays;

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        long dist[][] = new long[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        for (int e[] : edges) {
            dist[e[0]][e[1]] = e[2];
            dist[e[1]][e[0]] = e[2];

        }

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++)
                    dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);

        int index = -1;
        int count = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int currCount = 0;
            for (int j = 0; j < n; j++) {
                if (i == j || dist[i][j] == Integer.MAX_VALUE)
                    continue;
                if (dist[i][j] <= distanceThreshold)
                    currCount++;

            }

            if (currCount <= count) {
                count = currCount;
                index = i;
            }
        }
        return index;
    }
}