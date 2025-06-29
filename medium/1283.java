class Solution {
    public int smallestDivisor(int[] nums, int threshold) {

        int l = 1;
        int r = 1_000_000;
        int ans = 0;

        while (l <= r) {

            int mid = (l + r) / 2;
            int sum = 0;
            for (int i : nums)
                sum += (i + mid - 1) / mid;
            if (sum > threshold)
                l = mid + 1;
            else {
                ans = mid;
                r = mid - 1;
            }

        }
        return ans;
    }
}