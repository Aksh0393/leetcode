class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        long xor = 0;
        int m = nums1.length;
        int n = nums2.length;
        if ((m & 1) == 1)
            for (int i : nums2)
                xor ^= i;

        if ((n & 1) == 1)
            for (int i : nums1)
                xor ^= i;
        return (int) xor;
    }
}