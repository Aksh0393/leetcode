package medium;

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        java.util.Arrays.sort(nums);

        return helper(nums, upper + 1) - helper(nums, lower);
    }

    private long helper(int nums[], int sum) {
        long ans = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] >= sum)
                right--;
            else {
                ans += right - left;
                left++;
            }
        }
        return ans;
    }
}