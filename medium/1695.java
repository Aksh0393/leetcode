import java.util.Arrays;

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;

        int[] cus = new int[n];
        cus[0] = nums[0];
        for (int i = 1; i < n; i++)
            cus[i] = cus[i - 1] + nums[i];

        int[] mp = new int[10001];
        Arrays.fill(mp, -1);

        int maxS = 0;
        int i = 0;
        int j = 0;

        while (j < n) {
            i = Math.max(i, mp[nums[j]] + 1);
            int jthSum = cus[j];
            int ithSum = i - 1 < 0 ? 0 : cus[i - 1];
            maxS = Math.max(maxS, jthSum - ithSum);
            mp[nums[j]] = j;

            j++;
        }

        return maxS;
    }
}