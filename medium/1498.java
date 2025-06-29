import java.util.Arrays;

class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        long mod = 1_000_000_007;
        long count = 0;

        while (l <= r) {
            if (nums[l] + nums[r] <= target) {
                count = (count + modPow(2, r - l, mod)) % mod;
                l++;
            } else {
                r--;
            }
        }

        return (int) count;
    }

    private long modPow(long base, int exp, long mod) {
        long res = 1;
        while (exp > 0) {
            if ((exp & 1) > 0)
                res = (res * base) % mod;

            base = (base * base) % mod;
            exp = exp >> 1;
        }
        return res;
    }
}
