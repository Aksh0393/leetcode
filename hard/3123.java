import java.util.*;

class Solution {
    HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();

    public boolean[] findAnswer(int n, int[][] edges) {
        map.clear();
        int m = edges.length;
        boolean[] ans = new boolean[m];

        // Build graph
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            map.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[] { v, w });
            map.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[] { u, w });
        }

        long[] fromSrc = dijkstra(n, 0);
        long[] fromDest = dijkstra(n, n - 1);
        long shortest = fromSrc[n - 1];

        for (int i = 0; i < m; i++) {
            int u = edges[i][0], v = edges[i][1], w = edges[i][2];

            if (fromSrc[u] != Integer.MAX_VALUE && fromDest[v] != Integer.MAX_VALUE &&
                    fromSrc[u] + w + fromDest[v] == shortest) {
                ans[i] = true;
            }
            if (fromSrc[v] != Integer.MAX_VALUE && fromDest[u] != Integer.MAX_VALUE &&
                    fromSrc[v] + w + fromDest[u] == shortest) {
                ans[i] = true;
            }
        }

        return ans;
    }

    private long[] dijkstra(int n, int src) {
        long[] dist = new long[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[] { 0, src });

        boolean[] visited = new boolean[n];

        while (!pq.isEmpty()) {
            long[] top = pq.poll();
            long d = top[0];
            int u = (int) top[1];

            if (visited[u])
                continue;
            visited[u] = true;

            for (int[] nei : map.getOrDefault(u, new ArrayList<>())) {
                int v = nei[0];
                int w = nei[1];
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new long[] { dist[v], v });
                }
            }
        }

        return dist;
    }
}
