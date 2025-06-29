import java.util.Arrays;

class Solution {
    public int smallestDistancePair(int[] nums, int k) {

        Arrays.sort(nums);
        int l = 0;
        int r = nums[nums.length - 1] - nums[0];

        int res = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int count = countPairs(nums, mid);
            if (count < k)
                l = mid + 1;
            else {
                res = mid;
                r = mid - 1;
            }
        }
        return res;
    }

    private int countPairs(int nums[], int target) {
        int count = 0;
        int end = 0;
        int start = 0;
        int n = nums.length;
        while (end < n) {
            while (start <= end && nums[end] - nums[start] > target)
                start++;

            count += end - start;
            end++;
        }

        return count;
    }
}

// Here we are checking for the distance<=mid and counting pairs for