
class DSU {
    private int[] parent;
    private int[] size;

    public DSU(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x) {
        if (x == parent[x])
            return x;

        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);

        if (xParent == yParent)
            return;

        if (size[xParent] > size[yParent]) {
            parent[yParent] = xParent;
            size[xParent] += size[yParent];
        } else if (size[xParent] < size[yParent]) {
            parent[xParent] = yParent;
            size[yParent] += size[xParent];
        } else {
            parent[xParent] = yParent;
            size[yParent] += size[xParent];
        }

    }

}

class Solution {

    public int removeStones(int[][] stones) {

        DSU dsu = new DSU(stones.length);

        for (int i = 0; i < stones.length; i++)
            for (int j = i + 1; j < stones.length; j++)
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1])
                    dsu.union(i, j);

        int gangs = 0;
        for (int i = 0; i < stones.length; i++)
            if (dsu.find(i) == i)
                gangs++;

        return stones.length - gangs;
    }
}