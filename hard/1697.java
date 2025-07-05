import java.util.Arrays;
import java.util.Comparator;

class DSU {
    int parent[];
    int rank[];

    DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
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

        if (rank[pa] > rank[pb])
            parent[pb] = pa;
        else {
            parent[pa] = pb;
            rank[pa]++;
        }
        return true;
    }
}

class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        DSU dsu = new DSU(n);
        for (int i = 0; i < queries.length; i++)
            queries[i] = new int[] { queries[i][0], queries[i][1], queries[i][2], i };

        Arrays.sort(edgeList, Comparator.comparingInt(a -> a[2]));
        Arrays.sort(queries, Comparator.comparingInt(a -> a[2]));

        boolean ans[] = new boolean[queries.length];

        int i = 0;
        for (int q[] : queries) {
            while (i < edgeList.length && edgeList[i][2] < q[2]) {
                dsu.union(edgeList[i][0], edgeList[i][1]);
                i++;
            }

            if (dsu.find(q[0]) == dsu.find(q[1]))
                ans[q[3]] = true;
        }

        return ans;
    }
}