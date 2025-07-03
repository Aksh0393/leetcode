import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    HashMap<Integer, List<Integer>> graph;

    public long countPairs(int n, int[][] edges) {
        graph = new HashMap<>();

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        long ans = 0;
        boolean vis[] = new boolean[n];
        int remainingNodes = n;
        for (int i = 0; i < n; i++) {
            if (vis[i])
                continue;
            long componentSize[] = { 0 };
            dfs(i, componentSize, vis);
            ans = ans + (remainingNodes - componentSize[0]) * componentSize[0];
            remainingNodes -= componentSize[0];
        }
        return ans;

    }

    private void dfs(int u, long[] componentSize, boolean[] vis) {

        componentSize[0]++;
        vis[u] = true;
        if (!graph.containsKey(u))
            return;
        for (int v : graph.get(u)) {
            if (!vis[v]) {
                dfs(v, componentSize, vis);
            }
        }
    }
}