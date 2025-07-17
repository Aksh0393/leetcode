import java.util.Arrays;

class Solution {
    public int maximumLength(int[] nums, int k) {
        int dp[][] = new int[k][nums.length];

        for (int i[] : dp)
            Arrays.fill(i, 1);

        int maxLen = 1;

        for (int i = 1; i < nums.length; i++)
            for (int j = 0; j < i; j++) {
                int mod = (nums[i] + nums[j]) % k;
                dp[mod][i] = Math.max(dp[mod][i], dp[mod][j] + 1);
                maxLen = Math.max(maxLen, dp[mod][i]);
            }

        return maxLen;
    }
}