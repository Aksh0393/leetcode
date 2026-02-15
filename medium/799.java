import java.util.Arrays;

class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double dp[][] = new double[query_row + 1][query_row + 1];
        for (double i[] : dp)
            Arrays.fill(i, -1);
        // return Math.min(1.0, helper(poured, query_row, query_glass, dp));
        return Math.min(1.0, skibidi(poured, query_row, query_glass));
    }

    private double helper(int poured, int i, int j, double dp[][]) {
        if (i < 0 || j < 0 || j > i)
            return 0.0;
        if (i == 0 && j == 0)
            return dp[i][j] = poured;
        if (dp[i][j] != -1)
            return dp[i][j];
        double leftUp = (helper(poured, i - 1, j - 1, dp) - 1.0) / 2.0;
        double rightUp = (helper(poured, i - 1, j, dp) - 1.0) / 2.0;
        if (leftUp < 0)
            leftUp = 0.0;
        if (rightUp < 0)
            rightUp = 0.0;
        return dp[i][j] = leftUp + rightUp;

    }

    private double skibidi(int poured, int i, int j) {
        double dp[][] = new double[i + 1][i + 1];
        dp[0][0] = poured;
        for (int row = 0; row <= i; row++)
            for (int col = 0; col <= j; col++) {
                if (row == 0 && col == 0)
                    continue;
                if (col > row)
                    break;
                double leftUp = 0.0;
                double rightUp = 0.0;
                if (row - 1 >= 0 && col - 1 >= 0)
                    leftUp = (dp[row - 1][col - 1] - 1.0) / 2.0;
                if (row - 1 >= 0 && col <= row - 1)
                    rightUp = (dp[row - 1][col] - 1.0) / 2.0;
                if (leftUp < 0)
                    leftUp = 0.0;
                if (rightUp < 0)
                    rightUp = 0.0;
                dp[row][col] = leftUp + rightUp;
            }

        return dp[i][j];

    }
}