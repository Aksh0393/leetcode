// class Solution {
//     public long maximumTripletValue(int[] nums) {
//         int n = nums.length;
//         int left[] = new int[n];
//         int right[] = new int[n];
//         left[0] = nums[0];
//         right[n - 1] = nums[n - 1];

//         for (int i = 1; i < n; i++) {
//             left[i] = Math.max(left[i - 1], nums[i]);
//             right[n - 1 - i] = Math.max(right[n - 1 - i + 1], nums[n - 1 - i]);
//         }

//         long ans = 0;
//         for (int i = 1; i < n-1; i++)
//             ans = Math.max(ans, 1l * (left[i-1] - nums[i]) * right[i+1]);

//         return ans;

//     }
// }

class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long result = 0;
        long maxDiff = 0;
        long maxi = 0;

        for (int i = 0; i < n; i++) {
            result = Math.max(result, maxDiff * nums[i]);
            maxDiff = Math.max(maxDiff, maxi - nums[i]);
            maxi = Math.max(maxi, nums[i]);
        }

        return result;

    }
}