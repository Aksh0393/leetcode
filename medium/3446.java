import java.util.*;

class Solution {
    public int[][] sortMatrix(int[][] grid) {

        // bottom left - non decreasing
        int n = grid.length;
        for (int row = 0; row < n; row++)
            solve(grid, row, 0, n, true);

        // top right -- non increasing
        for (int col = 1; col < n; col++)
            solve(grid, 0, col, n, false);

        return grid;

    }

    private void solve(int[][] grid, int row, int col, int n, boolean desc) {

        List<Integer> list = new ArrayList<>();

        int i = row;
        int j = col;

        while (i < n && j < n) {
            list.add(grid[i][j]);
            i++;
            j++;
        }

        if (desc)
            Collections.sort(list, Collections.reverseOrder());
        else
            Collections.sort(list);

        i = row;
        j = col;

        for (int val : list) {
            grid[i][j] = val;
            i++;
            j++;
        }

    }
}