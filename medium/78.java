import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int totalSubsets = 1 << nums.length; // 2^n subsets
        for (int i = 0; i < totalSubsets; i++) {
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & 1 << j) != 0)
                    curr.add(nums[j]);
            }
            list.add(curr);
        }
        return list;
    }
}