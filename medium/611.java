import java.util.Arrays;

class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;

        Arrays.sort(nums);
        int count = 0;

        for (int k = n - 1; k > 1; k--) {  // k is the largest side
            int i = 0, j = k - 1;          // two pointers
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    count += (j - i);      // all pairs (i..j-1, j) will satisfy inequality
                    j--;
                } else {
                    i++;
                }
            }
        }
        return count;
    }
}