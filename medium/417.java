import java.util.*;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        Queue<int[]> pq = new LinkedList<>();
        Queue<int[]> aq = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            pacific[i][0] = true;
            atlantic[i][n - 1] = true;
            pq.add(new int[] { i, 0 });
            aq.add(new int[] { i, n - 1 });
        }

        for (int i = 0; i < n; i++) {
            pacific[0][i] = true;
            atlantic[m - 1][i] = true;
            pq.add(new int[] { 0, i });
            aq.add(new int[] { m - 1, i });
        }

        bfs(pq, heights, m, n, pacific);
        bfs(aq, heights, m, n, atlantic);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (pacific[i][j] && atlantic[i][j])
                    result.add(Arrays.asList(i, j));
        return result;
    }

    private void bfs(Queue<int[]> q, int[][] height, int m, int n, boolean vis[][]) {
        int dx[] = new int[] { 0, 0, 1, -1 };
        int dy[] = new int[] { 1, -1, 0, 0 };

        while (!q.isEmpty()) {
            int a[] = q.poll();
            int r = a[0];
            int c = a[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n || vis[nr][nc] || height[nr][nc] < height[r][c])
                    continue;
                vis[nr][nc] = true;
                q.add(new int[] { nr, nc });
            }
        }
    }
}