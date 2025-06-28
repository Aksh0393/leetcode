import java.util.Arrays;

class Solution {

    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int valueAndIndex[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            valueAndIndex[i][0] = nums[i];
            valueAndIndex[i][1] = i;
        }

        Arrays.sort(valueAndIndex, (a, b) -> Integer.compare(b[0], a[0]));
        Arrays.sort(valueAndIndex, 0, k, (a, b) -> Integer.compare(a[1], b[1]));
        int[] ans = new int[k];
        for (int i = 0; i < k; i++)
            ans[i] = valueAndIndex[i][0];

        return ans;
    }
}