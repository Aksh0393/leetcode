import java.util.*;

class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        Set<Integer> st = new HashSet<>();

        for (int i = n - 1; i >= 0; i--) {
            if (st.contains(nums[i]))
                return (i + 3) / 3;
            st.add(nums[i]);
        }

        return 0;
    }
}