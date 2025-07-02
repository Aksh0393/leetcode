package revisit;

import java.util.HashSet;

class Solution {

    public int findMaximumXOR(int[] nums) {
        int ans = 0;

        for (int i = 31; i >= 0; i--) {
            int target = ans | (1 << i);
            if (canFormXOR(target, nums)) {
                ans = target;
            }
        }

        return ans;
    }

    private boolean canFormXOR(int target, int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            int masked = num & target;
            if (set.contains(masked ^ target))
                return true;
            set.add(masked);

        }
        return false;
    }
}