import java.util.ArrayList;
import java.util.HashMap;

class Solution {

    class DSU {
        int parent[];
        int size[];

        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int child) {
            if (parent[child] == child)
                return child;
            return parent[child] = find(parent[child]);
        }

        public boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb)
                return false;
            if (size[pa] < size[pb]) {
                parent[pa] = pb;
                size[pb] += size[pa];
            } else {
                parent[pb] = pa;
                size[pa] += size[pb];
            }
            return true;
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {

        DSU dsu = new DSU(n);
        for (int e[] : edges)
            dsu.union(e[0], e[1]);

        HashMap<Integer, Integer> graph = new HashMap<>();

        for (int[] edge : edges) {
            int root = dsu.find(edge[0]);
            graph.put(root, graph.getOrDefault(root, 0) + 1);
        }
        System.out.println(graph);

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (dsu.find(i) == i) {

                int v = dsu.size[i];
                int edgeCount = graph.getOrDefault(i, 0);
                if ((v * (v - 1)) / 2 == edgeCount)
                    count++;
            }
        }
        return count;

    }
}