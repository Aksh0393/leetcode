import java.util.Arrays;

class Solution {
    public int numberOfSets(int n, int maxDistance, int[][] roads) {

        int dist[][] = new int[n][n];
        int count = 0;
        for (int set = 0; set < (1 << n); set++) {

            for (int i[] : dist)
                Arrays.fill(i, 1000000);

            for (int road[] : roads) {
                int u = road[0];
                int v = road[1];
                int wt = road[2];

                if ((set >> u & 1) == 1 && (set >> v & 1) == 1) {

                    dist[u][v] = Math.min(dist[u][v], wt);
                    dist[v][u] = Math.min(dist[v][u], wt);

                }
            }

            for (int via = 0; via < n; via++)
                for (int i = 0; i < n; i++)
                    for (int j = 0; j < n; j++)
                        dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);

            boolean isFound = true;

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) {
                    if (i == j)
                        continue;
                    if ((set >> i & 1) == 1 && (set >> j & 1) == 1)
                        if (dist[i][j] > maxDistance) {
                            isFound = false;
                            break;
                        }
                }

            count += isFound ? 1 : 0;
        }

        return count;
    }
}