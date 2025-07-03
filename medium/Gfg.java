
// https://www.geeksforgeeks.org/problems/negative-weight-cycle3504/1
import java.util.Arrays;

class Solution {
    public int isNegativeWeightCycle(int n, int[][] edges) {
        int[] dist = new int[n];
        int INF = Integer.MAX_VALUE;

        for (int start = 0; start < n; start++) {
            Arrays.fill(dist, INF);
            dist[start] = 0;

            // Relax all edges n - 1 times
            for (int i = 0; i < n - 1; i++) {
                for (int[] edge : edges) {
                    int u = edge[0], v = edge[1], w = edge[2];
                    if (dist[u] != INF && dist[u] + w < dist[v]) {
                        dist[v] = dist[u] + w;
                    }
                }
            }

            // Check for negative weight cycle
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1], w = edge[2];
                if (dist[u] != INF && dist[u] + w < dist[v]) {
                    return 1; // Negative cycle found
                }
            }
        }

        return 0;
    }
}
