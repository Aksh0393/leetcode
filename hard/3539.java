// import java.util.HashMap;

// =================================TLE=================================
// class Solution {
//     final int MOD = 1_000_000_007;
//     public int magicalSum(int m, int k, int[] nums) {

//         return (int) solve(0, 0L, m, k, nums, new HashMap<String, Long>())%MOD;
//     }

//     private long solve(int count, long sum, int m, int k, int[] nums, HashMap<String, Long> map) {

//         if (count == m) {
//             if (Long.bitCount(sum) == k)
//                 return 1;
//             return 0;
//         }

//         String key = count + "-" + sum;
//         if (map.containsKey(key))
//             return map.get(key);
//         long totalSum = 0;
//         for (int i = 0; i < nums.length; i++) {
//             long newSum = sum + (1L << i);
//             long product = (nums[i] * solve(count + 1, newSum, m, k, nums, map)) % MOD;
//             totalSum = (totalSum + product) % MOD;
//         }

//         map.put(key, totalSum);
//         return totalSum % MOD;
//     }

// }

