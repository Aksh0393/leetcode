import java.util.*;

class Solution {
    public int maxLength(List<String> arr) {

        List<Integer> nums = new ArrayList<>();
        for (String i : arr) {
            HashSet<Character> set = new HashSet<>();
            for (char c : i.toCharArray())
                set.add(c);

            if (set.size() != i.length())
                continue;

            int temp = 0;
            for (char c : i.toCharArray())
                temp = temp | (1 << (c - '0'));
            nums.add(temp);

        }

        int result[] = new int[1];
        backtrack(nums, 0, 0, result);
        return result[0];

    }

    private void backtrack(List<Integer> nums, int i, int current, int[] result) {

        result[0] = Math.max(result[0], Integer.bitCount(current));

        if (i >= nums.size())
            return;

        for (int j = i; j < nums.size(); j++)
            if ((current & nums.get(j)) == 0)
                backtrack(nums, j + 1, current | nums.get(j), result);

    }

}