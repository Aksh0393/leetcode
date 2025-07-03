package revisit;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        long res = nums[0];  // Start with the first number
        for (int i = 1; i < nums.length; i++) {
            res += Math.max(nums[i] - nums[i - 1], 0);
        }
        return res;
    }
}


// import java.util.Arrays;

// class Solution {
//     private long dp[][];

//     public long maxAlternatingSum(int[] nums) {
//         dp = new long[nums.length + 1][2];
//         for (long i[] : dp)
//             Arrays.fill(i, -1);

//         // return solve(0, nums, 1);
//         return dynamic(nums);
//     }

//     private long solve(int i, int[] nums, int isEven) {
//         if (i >= nums.length)
//             return 0;

//         if (dp[i][isEven] != -1)
//             return dp[i][isEven];
//         long take = 0;
//         long val = nums[i];
//         if (isEven == 0)
//             val = -val;

//         take = val + solve(i + 1, nums, 1 - isEven);
//         long notTake = solve(i + 1, nums, isEven);
//         return dp[i][isEven] = Math.max(take, notTake);

//     }

//     private long dynamic(int nums[]) {
//         for (long i[] : dp)
//             Arrays.fill(i, 0);
//         for (int i = nums.length; i >= 0; i--) {
//             for (int isEven = 0; isEven <= 1; isEven++) {
//                 if (i >= nums.length) {
//                     dp[i][isEven] = 0;
//                     continue;
//                 }
//                 long take = 0;
//                 long val = nums[i];
//                 if (isEven == 0)
//                     val = -val;

//                 take = val + dp[i + 1][1 - isEven];
//                 long notTake = dp[i + 1][isEven];
//                 dp[i][isEven] = Math.max(take, notTake);

//             }
//         }
//         return dp[0][1];
//     }
// }