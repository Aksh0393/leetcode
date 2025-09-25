import java.util.*;

class Solution {
    int dp[][] = new int[201][201];

    public int minimumTotal(List<List<Integer>> a) {
        for (int aa[] : dp)
            Arrays.fill(aa, Integer.MAX_VALUE);
        return help(a, 0, 0);
    }

    int help(List<List<Integer>> a, int r, int c) {
        if (r == a.size())
            return 0;
        if (c == a.get(r).size())
            c = 0;
        if (dp[r][c] != Integer.MAX_VALUE)
            return dp[r][c];
        int c1 = help(a, r + 1, c);
        int c2 = help(a, r + 1, c + 1);

        return dp[r][c] = Math.min(c1, c2) + a.get(r).get(c);
    }
}