import java.util.TreeSet;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > indexDiff)
                set.remove((long) nums[i - indexDiff - 1]);

            long num = nums[i];
            long left = nums[i] - valueDiff;

            Long ceil = set.ceiling(left);

            if (null != ceil && Math.abs(num - ceil) <= valueDiff)
                return true;

            set.add(num);
        }
        return false;

    }
}
