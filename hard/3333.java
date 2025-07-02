import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;
    List<Integer> groups;
    int k;
    Integer[][] memo;

    public int possibleStringCount(String word, int k) {
        if (word.isEmpty()) return 0;

        this.groups = new ArrayList<>();
        this.k = k;

        // Run-length encoding
        int count = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1)) count++;
            else {
                groups.add(count);
                count = 1;
            }
        }
        groups.add(count);

        int groupCount = groups.size();
        long total = 1;
        for (int g : groups)
            total = (total * g) % MOD;

        if (k <= groupCount) return (int) total;

        int maxLen = k;
        memo = new Integer[groupCount + 1][maxLen];

        long invalid = dfs(0, 0);
        return (int) ((total - invalid + MOD) % MOD);
    }

    private int dfs(int i, int len) {
        if (i == groups.size()) {
            return len < k ? 1 : 0;
        }

        if (memo[i][len] != null) return memo[i][len];

        int ways = 0;
        int groupSize = groups.get(i);
        // Cut off early if len + 1 >= k
        for (int take = 1; take <= groupSize && len + take < k; take++) {
            ways = (ways + dfs(i + 1, len + take)) % MOD;
        }

        memo[i][len] = ways;
        return ways;
    }
}
