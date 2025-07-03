// User function Template for Java

import java.util.Arrays;

class Solution {
    public void bellmanFord(int V, int[][] edges, int src) {
        int[] dist = new int[V];
        int max = Integer.MAX_VALUE;
        Arrays.fill(dist, max);
        dist[src] = 0;

        // Step 1: Relax edges V - 1 times
        for (int i = 0; i < V - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                if (dist[u] != max && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        // Step 2: Check for negative weight cycle
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if (dist[u] != max && dist[u] + w < dist[v]) {
                System.out.println("negative cycle detected");
                return;
            }
        }

    }
}
