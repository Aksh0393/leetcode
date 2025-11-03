class Solution {
    public int minCost(String s, int[] cost) {
        int res = 0;
        int maxCost = cost[0];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                res += Math.min(maxCost, cost[i]);
                maxCost = Math.max(maxCost, cost[i]);
            } else
                maxCost = cost[i];
        }

        return res;
    }
}