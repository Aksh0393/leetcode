import java.util.Arrays;

class Solution {
    int mod = 1_000_000_007;
    int dp[][];

    public int numberOfWays(int n, int x) {
        dp = new int[n + 1][n + 1];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        return solve(n, 1, x);
    }

    private int solve(int n, int num, int x) {
        if (n == 0)
            return 1;

        if (n < 0)
            return 0;

        if (num > n)
            return 0;

        if (dp[n][num] != -1)
            return dp[n][num];

        int powerVal = (int) Math.pow(num, x);

        int take = solve(n - powerVal, num + 1, x);
        int notTake = solve(n, num + 1, x);

        return dp[n][num] = (take + notTake) % mod;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.numberOfWays(3, 1);
    }
}