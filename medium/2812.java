import java.util.*;

class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {

        int m = grid.size();
        int n = grid.get(0).size();
        if (grid.get(0).get(0) == 1 || grid.get(m - 1).get(n - 1) == 1)
            return 0;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid.get(i).get(j) == 1)
                    q.add(new int[] { i, j });

        int level = 0;
        int dx[] = { 0, 0, -1, 1 };
        int dy[] = { 1 ,- 1, 0, 0 };
        int dist[][] = new int[m][n];
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int a[] = q.poll();
                int r = a[0];
                int c = a[1];
                for (int j = 0; j < 4; j++) {
                    int newR = r + dx[j];
                    int newC = c + dy[j];
                    if (newR >= 0 && newR < m && newC >= 0 && newC < n && grid.get(newR).get(newC) != 1
                            && dist[newR][newC] == 0) {
                        dist[newR][newC] = level + 1;
                        q.add(new int[] { newR, newC });
                    }
                }
            }
            level++;

        }

        int l = 0;
        int r = level - 1;
        int ans = 0;
        while (l <= r) {

            int mid = (l + r) / 2;
            boolean[][] visited = new boolean[m][n];
            if (dfs(0, 0, m, n, dist, mid, visited)) {
                ans = mid;
                l = mid + 1;
            } else
                r = mid - 1;
        }
        return ans;
    }

    private boolean dfs(int i, int j, int m, int n, int[][] dist, int mid, boolean vis[][]) {

        if (i >= m || i < 0 || j >= n || j < 0)
            return false;

        if (dist[i][j] < mid || vis[i][j])
            return false;

        if (i == m - 1 && j == n - 1)
            return true;

        vis[i][j] = true;

        return dfs(i + 1, j, m, n, dist, mid, vis)
                || dfs(i, j + 1, m, n, dist, mid, vis)
                || dfs(i - 1, j, m, n, dist, mid, vis)
                || dfs(i, j - 1, m, n, dist, mid, vis);

    }
}