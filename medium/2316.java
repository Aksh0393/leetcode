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



// import java.util.*;

// class Solution {
//     class DSU {
//         int[] parent;
//         int[] size;

//         public DSU(int n) {
//             parent = new int[n];
//             size = new int[n];
//             for (int i = 0; i < n; i++) {
//                 parent[i] = i;
//                 size[i] = 1;
//             }
//         }

//         public int find(int x) {
//             if (parent[x] != x)
//                 parent[x] = find(parent[x]);
//             return parent[x];
//         }

//         public void union(int a, int b) {
//             int pa = find(a);
//             int pb = find(b);
//             if (pa != pb) {
//                 if (size[pa] < size[pb]) {
//                     parent[pa] = pb;
//                     size[pb] += size[pa];
//                 } else {
//                     parent[pb] = pa;
//                     size[pa] += size[pb];
//                 }
//             }
//         }
//     }

//     public long countPairs(int n, int[][] edges) {
//         DSU dsu = new DSU(n);

//         for (int[] edge : edges) {
//             dsu.union(edge[0], edge[1]);
//         }

//         Map<Integer, Long> componentSize = new HashMap<>();
//         for (int i = 0; i < n; i++) {
//             int root = dsu.find(i);
//             componentSize.put(root, componentSize.getOrDefault(root, 0l) + 1);
//         }

//         long totalPairs = 0;
//         for (long size : componentSize.values()) {
//             totalPairs += size * (n - size);
//             n -= size;
//         }

//         return totalPairs;
//     }
// }
