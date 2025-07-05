// https://www.geeksforgeeks.org/problems/detect-cycle-using-dsu/1

import java.util.ArrayList;

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

            if (size[pa] > size[pb]) {
                parent[pb] = pa;
                size[pa] += size[pb];
            } else {
                parent[pa] = pb;
                size[pb] += size[pa];
            }
            return true;
        }
    }

    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {

        DSU dsu = new DSU(V);

        for (int i = 0; i < adj.size(); i++) {
            for (int v : adj.get(i)) {
                if (i == v)
                    continue;
                if (i < v) {
                    if (dsu.find(i) == dsu.find(v))
                        return 1;
                    else
                        dsu.union(i, v);
                }
            }
        }
        return 0;
    }
}