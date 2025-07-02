class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] result = new int[n];

        int XOR = 0;
        for (int num : nums)
            XOR ^= num;

        int mask = (1 << maximumBit) - 1;

        for (int i = 0; i < n; i++) {
            result[i] = XOR ^ mask;

            XOR ^= nums[n - 1 - i];
        }

        return result;
    }
}
