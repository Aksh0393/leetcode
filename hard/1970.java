
class Solution {

    private int dx[] = { 0, 0, 1, -1 };
    private int dy[] = { 1, -1, 0, 0 };

    public int latestDayToCross(int row, int col, int[][] cells) {

        int l = 0;
        int r = cells.length - 1;

        int ans = 0;

        while (l <= r) {

            int mid = l + (r - l) / 2;

            if (isPossible(row, col, mid, cells)) {
                ans = mid+1;
                l = mid + 1;
            } else
                r = mid - 1;
        }
        return ans;
    }

    private boolean isPossible(int m, int n, int days, int[][] cells) {
        int a[][] = new int[m][n];

        for (int i = 0; i <= days; i++) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;
            a[r][c] = 1;
        }
        boolean vis[][] = new boolean[m][n];
        for (int i = 0; i < n; i++) {
            if (a[0][i] == 0 && dfs(m, n, 0, i, a, vis))
                return true;
        }
        return false;
    }

    private boolean dfs(int m, int n, int i, int j, int[][] a, boolean vis[][]) {
        if (i < 0 || i >= m || j < 0 || j >= n || a[i][j] == 1 || vis[i][j])
            return false;

        if (i == m - 1)
            return true;

        vis[i][j] = true;
        for (int k = 0; k <= 3; k++) {
            int newR = i + dx[k];
            int newC = j + dy[k];
            if (dfs(m, n, newR, newC, a, vis))
                return true;
        }

        return false;

    }
}