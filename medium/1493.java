class Solution {
    public int longestSubarray(int[] nums) {
        int prevLen = 0;
        boolean isZero = false;
        int currLen = 0;
        int ans = 0;
        for (int i : nums) {
            if (i == 0) {
                isZero = true;
                prevLen = currLen;
                currLen = 0;
            } else
                currLen++;

            ans = Math.max(ans, prevLen + currLen);

        }

        if (isZero)
            return ans;

        return ans - 1;
    }
}