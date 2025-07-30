class Solution {
    public int longestSubarray(int[] nums) {

        int ans = 1;
        int max = nums[0];
        int streak = 0;

        for (int i : nums) {
            if (i > max) {
                max = i;
                ans = 1;
                streak = 1;
                continue;
            }

            if (i == max) {
                streak++;
                ans = Math.max(ans, streak);
            } else {
                streak = 0;
            }

        }
        return ans;
    }
}