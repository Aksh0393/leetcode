import java.util.Arrays;

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int maxEl = Arrays.stream(nums).max().getAsInt() + k;
        int freq[] = new int[maxEl + 1];
        for (int num : nums)
            freq[num]++;

        for (int i = 1; i <= maxEl; i++)
            freq[i] += freq[i - 1];

        int result = 0;
        for (int target = 0; target <= maxEl; target++) {

            if (freq[target] == 0)
                continue;

            int left = Math.max(0, target - k);
            int right = Math.min(target + k, maxEl);
            int targetFreq = freq[target] - (target > 0 ? freq[target - 1] : 0);
            int totalFreq = freq[right] - (left > 0 ? freq[left - 1] : 0);
            int neededOperations = totalFreq - targetFreq;
            int maxAchievableFreq = targetFreq + Math.min(neededOperations, numOperations);
            result = Math.max(result, maxAchievableFreq);

        }

        return result;
    }
}